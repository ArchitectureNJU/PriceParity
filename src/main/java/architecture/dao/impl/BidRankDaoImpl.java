package architecture.dao.impl;

import architecture.bean.BidRankBean;
import architecture.dao.BidRankDao;
import architecture.entity.BidRankEntity;
import architecture.jest.BeanResult;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Bid rank dao impl
 * @author cuihao
 */
@Repository
public class BidRankDaoImpl extends BaseDaoImpl<BidRankEntity> implements BidRankDao {

    private final String TYPE_NAME = "bidRank";

    /**
     * Find all bid rank info
     *
     * @return list of bid rank info
     */
    @Override
    public List<BidRankBean> findAll(int offset, int size) {
        return super.findAll(offset,size,TYPE_NAME, BidRankEntity.class).stream()
                .map(result -> new BidRankBean(result.getId(), result.getData()))
                .collect(Collectors.toList());
    }

    /**
     * find info by key word
     *
     * @param id commodity id
     * @return list of bid rank info
     */
    @Override
    public BidRankBean findById(String id) {
        return new BidRankBean(id,super.findById(id,TYPE_NAME, BidRankEntity.class));
    }

    /**
     * Create bid rank info
     *
     * @param bidRankEntity entity to be created
     * @return created entity with document id
     */
    @Override
    public BidRankBean create(BidRankEntity bidRankEntity) {
        BeanResult<BidRankEntity> result = super.create(bidRankEntity, TYPE_NAME, BidRankEntity.class);
        return new BidRankBean(result.getId(), result.getData());
    }

    /**
     * Update bid rank info
     *
     * @param bidRankEntity entity to be updated
     *                      MUST with document id
     * @return updated entity
     */
    @Override
    public BidRankBean save(BidRankBean bidRankEntity) {
        return new BidRankBean(bidRankEntity.getId(),
                super.update(new BidRankEntity(bidRankEntity),bidRankEntity.getId(),TYPE_NAME, BidRankEntity.class));
    }

    @Override
    public BidRankBean delete(String id) {
        return new BidRankBean(id, super.delete(id,TYPE_NAME, BidRankEntity.class));
    }
}
