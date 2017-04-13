package architecture.dao;

import java.util.List;

/**
 * Dao operation template
 * @param <T> entity class
 * @author cuihao
 */
public interface BaseDao<T> {
    List<T> findAll(int offset, int size, String type);
    long create(T entity, String type);
    T update(T bean,long id,  String type);
    T findById(long id, String type);
    T delete(long id, String type);
}
