package architecture.service;

import architecture.bean.CommodityBean;

import java.util.Iterator;

/**
 * Created by cxworks on 17-4-12.
 */
public interface SearchService {

    public Iterator<CommodityBean> search(String keyword, int offset, int limit);
}
