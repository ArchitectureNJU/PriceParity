package architecture.dao.impl;

import architecture.dao.BaseDao;
import architecture.jest.ClientFactory;
import architecture.jest.JestService;
import architecture.utils.JsonMapping;
import architecture.utils.SRSLogger;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.BulkResult;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.SearchResult;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * base dao template impl
 *
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

    @Resource
    private ClientFactory clientFactory;

    @Resource
    private JestService jestService;

    @Resource
    private SRSLogger logger;

    private final String INDEX_NAME = "srs";

    private Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    public List<T> findAll(int offset, int size, String type) {
        JestClient client = clientFactory.getClient();
        Map<String,Object> query = new HashMap<>();
        query.put("size",size);
        query.put("from", offset);
        String queryJson = JsonMapping.toJson(query);
        SearchResult result = jestService.search(client,INDEX_NAME,type,queryJson);
        if (result!=null && result.isSucceeded()) {
            return result.getSourceAsObjectList(clazz);
        } else {
            logger.log(BaseDaoImpl.class, result==null?"null result":result.getErrorMessage());
        }
        return new ArrayList<T>(0);
    }
    public long create(T entity, String type) {
        JestClient client = clientFactory.getClient();
        List<T> list = new ArrayList<T>(1);
        list.add(entity);
        BulkResult bulkResult = jestService.index(client,INDEX_NAME, type, list);
        if (bulkResult!=null && bulkResult.isSucceeded()) {
            return Long.parseLong(bulkResult.getItems().get(0).id);
        } else {
            logger.log(BaseDaoImpl.class, bulkResult==null?"null result":bulkResult.getErrorMessage());
        }
        return 0;
    }
    public T update(T entity, long id, String type) {
        JestClient client = clientFactory.getClient();
        DocumentResult result = jestService.index(client,INDEX_NAME, type, id+"", entity);
        if (result!=null && result.isSucceeded()) {
            return result.getSourceAsObject(clazz);
        } else {
            logger.log(BaseDaoImpl.class, result==null?"null result":result.getErrorMessage());
        }
        return null;
    }
    public T findById(long id, String type) {
        JestClient client = clientFactory.getClient();
        JestResult result = jestService.get(client,INDEX_NAME, type, id+"");
        if (result!=null && result.isSucceeded()) {
            return result.getSourceAsObject(clazz);
        } else {
            logger.log(BaseDaoImpl.class, result==null?"null result":result.getErrorMessage());
        }
        return null;
    }
    public T delete(long id, String type) {
        JestClient client = clientFactory.getClient();
        JestResult result = jestService.delete(client, INDEX_NAME, type, id+"");
        if (result!=null && result.isSucceeded()) {
            return result.getSourceAsObject(clazz);
        } else {
            logger.log(BaseDaoImpl.class, result==null?"null result":result.getErrorMessage());
        }
        return null;
    }
}
