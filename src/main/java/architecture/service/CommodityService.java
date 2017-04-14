package architecture.service;

import architecture.bean.CommodityBean;
import architecture.entity.CommodityEntity;

import java.util.Iterator;

/**
 * Created by cxworks on 17-4-12.
 */
public interface CommodityService {


    public CommodityBean find(String id);


    public CommodityBean add(CommodityEntity entity);
}
