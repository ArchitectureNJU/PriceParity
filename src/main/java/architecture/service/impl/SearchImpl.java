package architecture.service.impl;

import architecture.bean.CommodityBean;
import architecture.dao.CommodityDao;
import architecture.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cxworks on 17-4-12.
 */
@Component
@Transactional
public class SearchImpl implements SearchService {
    @Autowired
    CommodityDao commodityDao;
    @Override
    public List<CommodityBean> search(String keyword, int offset, int limit) {
        List<String> keywords=new ArrayList<>();
        if (keyword.length()!=0) {
            String[] keys = keyword.split("\\+");
            keywords.addAll(Arrays.asList(keys));
        }
        return commodityDao.findByKeyWord(keywords, offset, limit);
    }
}
