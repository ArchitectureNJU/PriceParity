package architecture.service;

import architecture.entity.CommodityEntity;

import java.util.Iterator;

/**
 * Created by cxworks on 17-4-12.
 */
public interface CommodityService {


    public CommodityEntity find(int id);


    public Iterator<CommodityEntity> list();
}
