package architecture.dao.impl;

import architecture.bean.BlockIpBean;
import architecture.dao.BlockIpDao;
import architecture.entity.BlockWordEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Block ip dao impl
 * @author cuihao
 */
@Repository
public class BlockIpDaoImpl implements BlockIpDao {
    /**
     * Find all block ips
     *
     * @return list of {@link BlockIpBean}
     */
    @Override
    public List<BlockIpBean> findAll(int offset, int size) {
        return null;
    }

    /**
     * Find block ips by id
     *
     * @param id id
     * @return {@link BlockIpBean}
     */
    @Override
    public BlockIpBean findById(long id) {
        return null;
    }

    /**
     * Create block ip
     *
     * @param entity entity without ip
     * @return {@link BlockIpBean}
     */
    @Override
    public BlockIpBean create(BlockWordEntity entity) {
        return null;
    }

    /**
     * Update block ip
     *
     * @param bean block ip bean
     * @return {@link BlockIpBean}
     */
    @Override
    public BlockIpBean save(BlockIpBean bean) {
        return null;
    }

    /**
     * Delete by id
     *
     * @param id id
     * @return deleted {@link BlockIpBean}
     */
    @Override
    public BlockIpBean delete(long id) {
        return null;
    }
}
