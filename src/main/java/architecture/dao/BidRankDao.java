package architecture.dao;

import architecture.bean.BidRankBean;
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
    List<BidRankBean> findAll(int offset, int size);

    /**
     * find info by key word
     * @param id commodity id
     * @return bid rank info
     */
    BidRankBean findById(String id);

    /**
     * Create bid rank info
     * @param bidRankEntity entity to be created
     * @return created entity with document id
     */
    BidRankBean create(BidRankEntity bidRankEntity);

    /**
     * Update bid rank info
     * @param bidRankEntity entity to be updated
     *                      MUST with document id
     * @return updated entity
     */
    BidRankBean save(BidRankBean bidRankEntity);

    BidRankBean delete(String id);
}
