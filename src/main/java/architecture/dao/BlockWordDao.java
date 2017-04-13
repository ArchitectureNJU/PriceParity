package architecture.dao;

import architecture.bean.BlockWordBean;
import architecture.entity.BlockRecordEntity;
import architecture.entity.CommodityEntity;

import java.util.List;

/**
 * block commodity dao
 * @author cuihao
 */
public interface BlockWordDao {
    /**
     * Find all block word
     * @param offset offset items
     * @param size size
     * @return list of {@link BlockWordBean}
     */
    List<BlockWordBean> findAll(int offset, int size);

    /**
     * Find block word by id
     * @param id id
     * @return {@link BlockWordBean}
     */
    BlockWordBean findById(String id);

    /**
     * Create block word
     * @param entity entity without id
     * @return {@link BlockWordBean}
     */
    BlockWordBean create(BlockRecordEntity entity);

    /**
     * Update block word
     * @param bean bean with valid id
     * @return {@link BlockWordBean}
     */
    BlockWordBean save(BlockWordBean bean);

    /**
     * Delete by id
     * @param id id
     * @return {@link BlockWordBean}
     */
    BlockWordBean delete(String id);
}
