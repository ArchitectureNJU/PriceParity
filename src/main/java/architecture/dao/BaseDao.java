package architecture.dao;

import architecture.jest.BeanResult;

import java.util.List;

/**
 * Dao operation template
 * @param <T> entity class
 * @author cuihao
 */
public interface BaseDao<T> {
    List<BeanResult<T>> findAll(int offset, int size, String type, Class<T> clazz);
    BeanResult<T> create(T entity, String type, Class<T> clazz);
    T update(T bean,String id,  String type, Class<T> clazz);
    T findById(String id, String type, Class<T> clazz);
    T delete(String id, String type, Class<T> clazz);
}
