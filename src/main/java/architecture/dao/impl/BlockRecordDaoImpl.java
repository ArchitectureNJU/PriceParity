package architecture.dao.impl;

import architecture.bean.BlockRecordBean;
import architecture.dao.BlockRecordDao;
import architecture.entity.BlockRecordEntity;
import architecture.jest.BeanResult;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Block record dao impl
 */
@Repository
public class BlockRecordDaoImpl extends BaseDaoImpl<BlockRecordEntity> implements BlockRecordDao {

    private final String TYPE_NAME = "blockRecord";
    /**
     * Find all block records
     *
     * @return list of {@link BlockRecordBean}
     */
    @Override
    public List<BlockRecordBean> findAll(int offset, int size) {
        return super.findAll(offset,size,TYPE_NAME, BlockRecordEntity.class).stream()
                .map(result -> new BlockRecordBean(result.getId(), result.getData()))
                .collect(Collectors.toList());
    }

    /**
     * Find block records by id
     *
     * @param id id
     * @return {@link BlockRecordBean}
     */
    @Override
    public BlockRecordBean findById(String id) {
        BlockRecordEntity entity = super.findById(id,TYPE_NAME, BlockRecordEntity.class);
        if (entity!=null) {
            return new BlockRecordBean(id, entity);
        }
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
        BeanResult<BlockRecordEntity> result = super.create(entity, TYPE_NAME, BlockRecordEntity.class);
        return new BlockRecordBean(result.getId(), result.getData());
    }

    /**
     * Update block record
     *
     * @param bean block record bean
     * @return {@link BlockRecordBean}
     */
    @Override
    public BlockRecordBean save(BlockRecordBean bean) {
        BlockRecordEntity entity =
                super.update(new BlockRecordEntity(bean),bean.getId(),TYPE_NAME, BlockRecordEntity.class);
        if (entity!=null) {
            return new BlockRecordBean(bean.getId(), entity);
        }
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
        BlockRecordEntity entity = super.delete(id,TYPE_NAME, BlockRecordEntity.class);
        if (entity!=null) {
            return new BlockRecordBean(id, entity);
        } else {
            return null;
        }
    }
}
