package architecture.dao.impl;

import architecture.bean.BlockRecordBean;
import architecture.dao.BlockRecordDao;
import architecture.entity.BlockRecordEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Block record dao impl
 */
@Repository
public class BlockRecordDaoImpl implements BlockRecordDao {
    /**
     * Find all block records
     *
     * @return list of {@link BlockRecordBean}
     */
    @Override
    public List<BlockRecordBean> findAll(int offset, int size) {
        return null;
    }

    /**
     * Find block records by id
     *
     * @param id id
     * @return {@link BlockRecordBean}
     */
    @Override
    public BlockRecordBean findById(String id) {
        return null;
    }

    /**
     * Create block record
     *
     * @param entity entity without record
     * @return {@link BlockRecordBean}
     */
    @Override
    public BlockRecordBean create(BlockRecordEntity entity) {
        return null;
    }

    /**
     * Update block record
     *
     * @param bean block record bean
     * @return {@link BlockRecordBean}
     */
    @Override
    public BlockRecordBean save(BlockRecordBean bean) {
        return null;
    }

    /**
     * Delete by record
     *
     * @param id record
     * @return deleted {@link BlockRecordBean}
     */
    @Override
    public BlockRecordBean delete(String id) {
        return null;
    }
}
