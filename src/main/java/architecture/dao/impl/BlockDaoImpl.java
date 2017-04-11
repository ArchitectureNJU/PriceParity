package architecture.dao.impl;

import architecture.dao.BlockDao;
import architecture.entity.CommodityEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * block dao impl
 * @author cuihao
 */
@Repository
public class BlockDaoImpl implements BlockDao {
    /**
     * Block commodity by document id
     *
     * @param id document id
     * @return blocked commodity
     */
    @Override
    public CommodityEntity block(int id) {
        return null;
    }

    /**
     * Block keyword with high correlation
     *
     * @param keyword keyword to be blocked
     * @param offset
     * @param size    size of list
     *                -1 with no limit  @return blocked list sorted by correlation desc
     */
    @Override
    public List<CommodityEntity> blockKeyWord(String keyword, int offset, int size) {
        return null;
    }

    /**
     * Get all blocked list
     *
     * @param offset offset items
     * @param size   -1 with no limit
     * @return blocked list
     */
    @Override
    public List<CommodityEntity> blockList(int offset, int size) {
        return null;
    }

    /**
     * Unblock keyword
     *
     * @param keyword keyword
     * @return unblock list
     */
    @Override
    public List<CommodityEntity> unblockKeyWord(String keyword) {
        return null;
    }

    /**
     * unblock one commodity by id
     *
     * @param id document id of commodity
     * @return unblocked commodity
     */
    @Override
    public CommodityEntity unblock(int id) {
        return null;
    }
}
