package architecture.dao;

import architecture.bean.CommodityBean;
import architecture.entity.CommodityEntity;

import java.util.List;

/**
 * commodity dao
 * @author cuihao
 */
public interface CommodityDao {

    /**
     * Get detail info of a commodity by document id
     * @param id id of DOCUMENT
     * @return {@link CommodityBean}
     */
    CommodityBean findById(String id);

    /**
     * Core search method of commodities.
     * @param keyword plain keyword (natural language) or empty string or null
     * @param offset offset items default 0 (GREATER THAN OR EQUAL TO 0)
     * @param limit limit items
     * @return sorted list of commodity entity.<br/>
     *      if keyword is provided, the list will be sorted by correlation.<br/>
     *      if keyword is null or empty, the list will be sorted by updated time.
     */
    List<CommodityBean> findByKeyWord(List<String> keyword, int offset, int limit);

    /**
     * Update commodity entity
     * @param commodityEntity commodity entity with ID
     * @return updated entity
     */
    CommodityBean save(CommodityBean commodityEntity);

    /**
     * Delete a commodity by id
     * @param id id
     * @return deleted commodity
     */
    CommodityBean delete(String id);

    /**
     * Create commodity bean
     * @param entity entity
     * @return {@link CommodityBean}
     */
    CommodityBean create(CommodityEntity entity);
}
