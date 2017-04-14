package architecture.dao.impl;

import architecture.bean.BlockWordBean;
import architecture.dao.BlockWordDao;
import architecture.entity.BlockWordEntity;
import architecture.jest.BeanResult;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * block word dao impl
 * @author cuihao
 */
@Repository
public class BlockWordDaoImpl extends BaseDaoImpl<BlockWordEntity> implements BlockWordDao {

    private final String TYPE_NAME = "blockWord";
    /**
     * Find all block word
     *
     * @param offset offset items
     * @param size   size
     * @return list of {@link BlockWordBean}
     */
    @Override
    public List<BlockWordBean> findAll(int offset, int size) {
        return super.findAll(offset,size,TYPE_NAME, BlockWordEntity.class).stream()
                .map(result -> new BlockWordBean(result.getId(), result.getData()))
                .collect(Collectors.toList());
    }

    /**
     * Find block word by id
     *
     * @param id id
     * @return {@link BlockWordBean}
     */
    @Override
    public BlockWordBean findById(String id) {
        BlockWordEntity entity = super.findById(id,TYPE_NAME, BlockWordEntity.class);
        if (entity!=null) {
            return new BlockWordBean(id, entity);
        }
        return null;
    }

    /**
     * Create block word
     *
     * @param entity entity without id
     * @return {@link BlockWordBean}
     */
    @Override
    public BlockWordBean create(BlockWordEntity entity) {
        BeanResult<BlockWordEntity> result = super.create(entity, TYPE_NAME, BlockWordEntity.class);
        return new BlockWordBean(result.getId(), result.getData());
    }

    /**
     * Update block word
     *
     * @param bean bean with valid id
     * @return {@link BlockWordBean}
     */
    @Override
    public BlockWordBean save(BlockWordBean bean) {
        BlockWordEntity entity =
                super.update(new BlockWordEntity(bean),bean.getId(),TYPE_NAME, BlockWordEntity.class);
        if (entity!=null) {
            return new BlockWordBean(bean.getId(), entity);
        }
        return null;
    }

    /**
     * Delete by id
     *
     * @param id id
     * @return {@link BlockWordBean}
     */
    @Override
    public BlockWordBean delete(String id) {
        BlockWordEntity entity = super.delete(id,TYPE_NAME, BlockWordEntity.class);
        if (entity!=null) {
            return new BlockWordBean(id, entity);
        } else {
            return null;
        }
    }
}
