package architecture.dao.impl;

import architecture.bean.BlockWordBean;
import architecture.dao.BlockWordDao;
import architecture.entity.BlockWordEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * block word dao impl
 * @author cuihao
 */
@Repository
public class BlockWordDaoImpl implements BlockWordDao {
    /**
     * Find all block word
     *
     * @param offset offset items
     * @param size   size
     * @return list of {@link BlockWordBean}
     */
    @Override
    public List<BlockWordBean> findAll(int offset, int size) {
        return null;
    }

    /**
     * Find block word by id
     *
     * @param id id
     * @return {@link BlockWordBean}
     */
    @Override
    public BlockWordBean findById(String id) {
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
        return null;
    }

    /**
     * Update block word
     *
     * @param bean bean with valid id
     * @return {@link BlockWordBean}
     */
    @Override
    public BlockWordBean save(BlockWordBean bean) {
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
        return null;
    }
}
