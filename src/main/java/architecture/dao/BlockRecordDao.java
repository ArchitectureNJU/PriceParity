package architecture.dao;

import architecture.bean.BlockRecordBean;
import architecture.entity.BlockRecordEntity;

import java.util.List;

/**
 * Block record dao
 * @author cuihao
 */
public interface BlockRecordDao {
    /**
     * Find all block records
     * @return list of {@link BlockRecordBean}
     */
    List<BlockRecordBean> findAll(int offset, int size);

    /**
     * Find block records by id
     * @param id id
     * @return {@link BlockRecordBean}
     */
    BlockRecordBean findById(String id);

    /**
     * Create block record
     * @param entity entity without record
     * @return {@link BlockRecordBean}
     */
    BlockRecordBean create(BlockRecordEntity entity);

    /**
     * Update block record
     * @param bean block record bean
     * @return {@link BlockRecordBean}
     */
    BlockRecordBean save(BlockRecordBean bean);

    /**
     * Delete by record
     * @param id record
     * @return deleted {@link BlockRecordBean}
     */
    BlockRecordBean delete(String id);
}
