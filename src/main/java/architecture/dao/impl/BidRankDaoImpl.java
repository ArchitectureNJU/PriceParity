package architecture.dao.impl;

import architecture.dao.BidRankDao;
import architecture.entity.BidRankEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * bid rank dao impl
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
    public List<BidRankEntity> findAll() {
        return null;
    }

    /**
     * find info by key word
     *
     * @param keyword commodity key word
     * @return list of bid rank info
     */
    @Override
    public List<BidRankEntity> findByKeyWord(String keyword) {
        return null;
    }

    /**
     * Create bid rank info
     *
     * @param bidRankEntity entity to be created
     * @return created entity with document id
     */
    @Override
    public BidRankEntity create(BidRankEntity bidRankEntity) {
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
    public BidRankEntity save(BidRankEntity bidRankEntity) {
        return null;
    }
}
