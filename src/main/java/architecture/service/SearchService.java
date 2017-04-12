package architecture.service;

import architecture.entity.CommodityEntity;

import java.util.Iterator;

/**
 * Created by cxworks on 17-4-12.
 */
public interface SearchService {

    public Iterator<CommodityEntity> search(String keyword, int offset, int limit);
}
