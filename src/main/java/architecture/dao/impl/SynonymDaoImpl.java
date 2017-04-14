package architecture.dao.impl;

import architecture.bean.SynonymBean;
import architecture.dao.SynonymDao;
import architecture.entity.SynonymEntity;
import architecture.jest.BeanResult;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * synonym dao impl
 * @author cuihao
 */
@Repository
public class SynonymDaoImpl extends BaseDaoImpl<SynonymEntity> implements SynonymDao {

    private final String TYPE_NAME = "synonym";
    /**
     * Find all synonym word
     *
     * @param offset offset items
     * @param size   size
     * @return list of {@link SynonymBean}
     */
    @Override
    public List<SynonymBean> findAll(int offset, int size) {
        return super.findAll(offset,size,TYPE_NAME, SynonymEntity.class).stream()
                .map(result -> new SynonymBean(result.getId(), result.getData()))
                .collect(Collectors.toList());
    }

    /**
     * Find synonym word by id
     *
     * @param id id
     * @return {@link SynonymBean}
     */
    @Override
    public SynonymBean findById(String id) {
        SynonymEntity entity = super.findById(id,TYPE_NAME, SynonymEntity.class);
        if (entity!=null) {
            return new SynonymBean(id, entity);
        }
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
        BeanResult<SynonymEntity> result = super.create(entity, TYPE_NAME, SynonymEntity.class);
        return new SynonymBean(result.getId(), result.getData());
    }

    /**
     * Update synonym word
     *
     * @param bean bean with valid id
     * @return {@link SynonymBean}
     */
    @Override
    public SynonymBean save(SynonymBean bean) {
        SynonymEntity entity =
                super.update(new SynonymEntity(bean),bean.getId(),TYPE_NAME, SynonymEntity.class);
        if (entity!=null) {
            return new SynonymBean(bean.getId(), entity);
        }
        return null;
    }

    /**
     * Delete by id
     *
     * @param id id
     * @return {@link SynonymBean}
     */
    @Override
    public SynonymBean delete(String id) {
        SynonymEntity entity = super.delete(id,TYPE_NAME, SynonymEntity.class);
        if (entity!=null) {
            return new SynonymBean(id, entity);
        } else {
            return null;
        }
    }
}
