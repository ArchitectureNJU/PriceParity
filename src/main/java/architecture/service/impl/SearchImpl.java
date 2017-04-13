package architecture.service.impl;

import architecture.bean.CommodityBean;
import architecture.dao.CommodityDao;
import architecture.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

/**
 * Created by cxworks on 17-4-12.
 */
@Component
@Transactional
public class SearchImpl implements SearchService {
    @Autowired
    CommodityDao commodityDao;
    @Override
    public Iterator<CommodityBean> search(String keyword, int offset, int limit) {
        return commodityDao.findByKeyWord(keyword, offset, limit).iterator();
    }
}
