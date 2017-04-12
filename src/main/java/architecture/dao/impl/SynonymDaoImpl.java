package architecture.dao.impl;

import architecture.bean.SynonymBean;
import architecture.dao.SynonymDao;
import architecture.entity.SynonymEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * synonym dao impl
 * @author cuihao
 */
@Repository
public class SynonymDaoImpl implements SynonymDao {
    /**
     * Find all synonym word
     *
     * @param offset offset items
     * @param size   size
     * @return list of {@link SynonymBean}
     */
    @Override
    public List<SynonymBean> findAll(int offset, int size) {
        return null;
    }

    /**
     * Find synonym word by id
     *
     * @param id id
     * @return {@link SynonymBean}
     */
    @Override
    public SynonymBean findById(long id) {
        return null;
    }

    /**
     * Create synonym word
     *
     * @param entity entity without id
     * @return {@link SynonymBean}
     */
    @Override
    public SynonymBean create(SynonymEntity entity) {
        return null;
    }

    /**
     * Update synonym word
     *
     * @param bean bean with valid id
     * @return {@link SynonymBean}
     */
    @Override
    public SynonymBean save(SynonymBean bean) {
        return null;
    }

    /**
     * Delete by id
     *
     * @param id id
     * @return {@link SynonymBean}
     */
    @Override
    public SynonymBean delete(long id) {
        return null;
    }
}
