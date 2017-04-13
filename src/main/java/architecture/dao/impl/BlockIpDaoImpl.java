package architecture.dao.impl;

import architecture.bean.BlockIpBean;
import architecture.dao.BlockIpDao;
import architecture.entity.BlockIpEntity;
import architecture.jest.BeanResult;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Block ip dao impl
 * @author cuihao
 */
@Repository
public class BlockIpDaoImpl extends BaseDaoImpl<BlockIpEntity> implements BlockIpDao {

    private final String TYPE_NAME = "blockIp";
    /**
     * Find all block ips
     *
     * @return list of {@link BlockIpBean}
     */
    @Override
    public List<BlockIpBean> findAll(int offset, int size) {
        return super.findAll(offset,size,TYPE_NAME, BlockIpEntity.class).stream()
                .map(blockIp->new BlockIpBean(blockIp.getId(), blockIp.getData())).collect(Collectors.toList());
    }

    /**
     * Find block ips by id
     *
     * @param id id
     * @return {@link BlockIpBean}
     */
    @Override
    public BlockIpBean findById(String id) {
        BlockIpEntity entity = super.findById(id,TYPE_NAME,BlockIpEntity.class);
        if (entity!=null) {
            return new BlockIpBean(id, entity);
        }
        return null;
    }

    /**
     * Create block ip
     *
     *
     * @param blockIpEntity@return {@link BlockIpBean}
     */
    @Override
    public BlockIpBean create(BlockIpEntity blockIpEntity) {
        BeanResult<BlockIpEntity> result = super.create(blockIpEntity,TYPE_NAME, BlockIpEntity.class);
        return new BlockIpBean(result.getId(), result.getData());
    }

    /**
     * Update block ip
     *
     * @param bean block ip bean
     * @return {@link BlockIpBean}
     */
    @Override
    public BlockIpBean save(BlockIpBean bean) {
        BlockIpEntity entity =
                super.update(new BlockIpEntity(bean),bean.getId(),TYPE_NAME, BlockIpEntity.class);
        if (entity!=null) {
            return new BlockIpBean(bean.getId(), entity);
        }
        return null;
    }

    /**
     * Delete by id
     *
     * @param id id
     * @return deleted {@link BlockIpBean}
     */
    @Override
    public BlockIpBean delete(String id) {
        BlockIpEntity entity = super.delete(id,TYPE_NAME, BlockIpEntity.class);
        if (entity!=null) {
            return new BlockIpBean(id, entity);
        } else {
            return null;
        }
    }
}
