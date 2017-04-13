package architecture.service.impl;

import architecture.bean.CommodityBean;
import architecture.dao.CommodityDao;
import architecture.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

/**
 * Created by cxworks on 17-4-12.
 */
@Component
@Transactional
public class CommodityImpl implements CommodityService {
    @Autowired
    CommodityDao commodityDao;
    @Override
    public CommodityBean find(String id) {
        return commodityDao.findById(id);
    }

}
