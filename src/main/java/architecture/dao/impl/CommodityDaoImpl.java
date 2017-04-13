package architecture.dao.impl;

import architecture.bean.CommodityBean;
import architecture.dao.CommodityDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Commodity dao impl
 * @author cuihao
 */
@Repository
public class CommodityDaoImpl implements CommodityDao {
    /**
     * Get detail info of a commodity by document id
     *
     * @param id id of DOCUMENT
     * @return {@link CommodityBean}
     */
    @Override
    public CommodityBean findById(String id) {
        return null;
    }

    /**
     * Core search method of commodities.
     *
     * @param keyword plain keyword (natural language) or empty string or null
     * @param offset  offset items default 0 (GREATER THAN OR EQUAL TO 0)
     * @param limit   limit items
     * @return sorted list of commodity entity.<br/>
     * if keyword is provided, the list will be sorted by correlation.<br/>
     * if keyword is null or empty, the list will be sorted by updated time.
     */
    @Override
    public List<CommodityBean> findByKeyWord(List<String> keyword, int offset, int limit) {
        return null;
    }

    /**
     * Update commodity entity
     *
     * @param commodityEntity commodity entity with ID
     * @return updated entity
     */
    @Override
    public CommodityBean save(CommodityBean commodityEntity) {
        return null;
    }

    /**
     * Delete a commodity by id
     *
     * @param id id
     * @return deleted commodity
     */
    @Override
    public CommodityBean delete(String id) {
        return null;
    }
}
