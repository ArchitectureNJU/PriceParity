package architecture.dao;

import architecture.bean.BlockIpBean;
import architecture.entity.BlockWordEntity;

import java.util.List;

/**
 * Block ip dao
 * @author cuihao
 */
public interface BlockIpDao {
    /**
     * Find all block ips
     * @return list of {@link BlockIpBean}
     */
    List<BlockIpBean> findAll(int offset, int size);

    /**
     * Find block ips by id
     * @param id id
     * @return {@link BlockIpBean}
     */
    BlockIpBean findById(long id);

    /**
     * Create block ip
     * @param entity entity without ip
     * @return {@link BlockIpBean}
     */
    BlockIpBean create(BlockWordEntity entity);

    /**
     * Update block ip
     * @param bean block ip bean
     * @return {@link BlockIpBean}
     */
    BlockIpBean save(BlockIpBean bean);

    /**
     * Delete by id
     * @param id id
     * @return deleted {@link BlockIpBean}
     */
    BlockIpBean delete(long id);
}
