package architecture.dao;

import architecture.bean.SynonymBean;
import architecture.entity.SynonymEntity;

import java.util.List;

/**
 * synonym dao
 * @author cuihao
 */
public interface SynonymDao {
    /**
     * Find all synonym word
     * @param offset offset items
     * @param size size
     * @return list of {@link SynonymBean}
     */
    List<SynonymBean> findAll(int offset, int size);

    /**
     * Find synonym word by id
     * @param id id
     * @return {@link SynonymBean}
     */
    SynonymBean findById(String id);

    /**
     * Create synonym word
     * @param entity entity without id
     * @return {@link SynonymBean}
     */
    SynonymBean create(SynonymEntity entity);

    /**
     * Update synonym word
     * @param bean bean with valid id
     * @return {@link SynonymBean}
     */
    SynonymBean save(SynonymBean bean);

    /**
     * Delete by id
     * @param id id
     * @return {@link SynonymBean}
     */
    SynonymBean delete(String id);
}
