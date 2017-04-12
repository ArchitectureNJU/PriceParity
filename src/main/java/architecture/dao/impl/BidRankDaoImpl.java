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
public class BidRankDaoImpl implements BidRankDao {
    /**
     * Find all bid rank info
     *
     * @return list of bid rank info
     */
    @Override
    public List<BidRankBean> findAll() {
        return null;
    }

    /**
     * find info by key word
     *
     * @param keyword commodity key word
     * @return list of bid rank info
     */
    @Override
    public List<BidRankBean> findByKeyWord(String keyword) {
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
        return null;
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
}
