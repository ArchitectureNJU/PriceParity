package architecture.dao.impl;

import architecture.bean.BidRankBean;
import architecture.dao.BidRankDao;
import architecture.entity.BidRankEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        return null;
    }

    /**
     * find info by key word
     *
     * @param id commodity id
     * @return list of bid rank info
     */
    @Override
    public List<BidRankBean> findById(long id) {
        return null;
    }

    /**
     * Create bid rank info
     *
     * @param bidRankEntity entity to be created
     * @return created entity with document id
     */
    @Override
    public BidRankBean create(BidRankEntity bidRankEntity) {
        long id = super.create(bidRankEntity, TYPE_NAME);
        return new BidRankBean(id, super.findById(id, TYPE_NAME));
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
        return null;
    }

    @Override
    public BidRankBean delete(long id) {
        return null;
    }
}
