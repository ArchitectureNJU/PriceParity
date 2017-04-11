package architecture.dao;

import architecture.entity.BidRankEntity;

import java.util.List;

/**
 * bid rank related dao
 * @author cuihao
 */
public interface BidRankDao {
    /**
     * Find all bid rank info
     * @return list of bid rank info
     */
    List<BidRankEntity> findAll();

    /**
     * find info by key word
     * @param keyword commodity key word
     * @return list of bid rank info
     */
    List<BidRankEntity> findByKeyWord(String keyword);

    /**
     * Create bid rank info
     * @param bidRankEntity entity to be created
     * @return created entity with document id
     */
    BidRankEntity create(BidRankEntity bidRankEntity);

    /**
     * Update bid rank info
     * @param bidRankEntity entity to be updated
     *                      MUST with document id
     * @return updated entity
     */
    BidRankEntity save(BidRankEntity bidRankEntity);
}
