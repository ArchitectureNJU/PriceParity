package architecture.dao;

import architecture.entity.CommodityEntity;

import java.util.List;

/**
 * block commodity dao
 * @author cuihao
 */
public interface BlockDao {
    /**
     * Block commodity by document id
     * @param id document id
     * @return blocked commodity
     */
    CommodityEntity block(int id);

    /**
     * Block keyword with high correlation
     * @param keyword keyword to be blocked
     * @param size size of list
     *             -1 with no limit
     * @return blocked list sorted by correlation desc
     */
    List<CommodityEntity> blockKeyWord(String keyword, int offset, int size);

    /**
     * Get all blocked list
     * @param offset offset items
     * @param size -1 with no limit
     * @return blocked list
     */
    List<CommodityEntity> blockList(int offset, int size);

    /**
     * Unblock keyword
     * @param keyword keyword
     * @return unblock list
     */
    List<CommodityEntity> unblockKeyWord(String keyword);

    /**
     * unblock one commodity by id
     * @param id document id of commodity
     * @return unblocked commodity
     */
    CommodityEntity unblock(int id);
}
