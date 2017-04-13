package architecture.service.impl;

import architecture.dao.CommodityDao;
import architecture.entity.CommodityEntity;
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
    public CommodityEntity find(int id) {
        return null;
    }

    @Override
    public Iterator<CommodityEntity> list() {
        return null;
    }
}
