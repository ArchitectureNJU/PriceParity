package architecture.service.impl;

import architecture.bean.BidRankBean;
import architecture.bean.BlockWordBean;
import architecture.bean.CommodityBean;
import architecture.bean.SynonymBean;
import architecture.dao.BidRankDao;
import architecture.dao.BlockWordDao;
import architecture.dao.CommodityDao;
import architecture.dao.SynonymDao;
import architecture.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by cxworks on 17-4-12.
 */
@Component
@Transactional
public class SearchImpl implements SearchService {
    @Autowired
    CommodityDao commodityDao;
    @Autowired
    BidRankDao bidRankDao;
    @Autowired
    SynonymDao synonymDao;
    @Autowired
    BlockWordDao blockWordDao;
    @Override
    public List<CommodityBean> search(String keyword, int offset, int limit) {
        List<String> keywords=new ArrayList<>();
        List<SynonymBean> list=synonymDao.findAll(0,500);
        if (keyword.length()!=0) {
            String[] keys = keyword.split("\\+");
            for (String key:keys){
                List<String> temp=list.stream().filter(b->b.has(key)).map(b->b.getZero()).collect(Collectors.toList());
                keywords.addAll(temp);
            }
            keywords.addAll(Arrays.asList(keys));

        }
        List<CommodityBean> preResult=commodityDao.findByKeyWord(keywords, offset, limit);

        List<BidRankBean> rules=bidRankDao.findAll(-1,-1);
        Map<String,Double> map=rules.stream().collect(Collectors.toConcurrentMap(bean->bean.getCommodityId(),
                bean->bean.getMoney()));
        List<String> blockRules=blockWordDao.findAll(0,500).stream()
                .map(b->b.getKeyWord()).collect(Collectors.toList());
        List<CommodityBean> sorted=preResult.stream().filter(b->!b.blocked(blockRules)).sorted((b1,b2)->{
            String bs1=b1.getId();
            String bs2=b2.getId();
            if (map.containsKey(bs1)&&map.containsKey(bs2)){
                return map.get(bs1).compareTo(map.get(bs2));
            }else if (map.containsKey(bs1)){
                return 1;
            }else if (map.containsKey(bs2)){
                return -1;
            }else {
                return ((Double)b1.getPrice()).compareTo(b2.getPrice());
            }
        }).collect(Collectors.toList());
        return sorted;
    }
}
