package architecture.dao.impl;

import architecture.dao.BaseDao;
import architecture.jest.BeanResult;
import architecture.jest.ClientFactory;
import architecture.jest.JestService;
import architecture.utils.JsonMapping;
import architecture.utils.SRSLogger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.SearchResult;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
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

    public List<BeanResult<T>> findAll(int offset, int size, String type, Class<T> clazz) {
        JestClient client = clientFactory.getClient();
        Map<String,Object> query = new HashMap<>();
        if (offset>=0 && size>=0) {
            query.put("size",size);
            query.put("from", offset);
        }
        String queryJson = JsonMapping.toJson(query);
        SearchResult result = jestService.search(client,INDEX_NAME,type,queryJson);
        List<BeanResult<T>> results = new ArrayList<>();
        if (result!=null && result.isSucceeded()) {
            List<SearchResult.Hit<T,Void>> hits = result.getHits(clazz);
            JsonObject jsonObject = result.getJsonObject();
            JsonArray hitsArray = jsonObject.getAsJsonObject("hits").getAsJsonArray("hits");
            for (int i = 0; i < result.getTotal()&&i<hitsArray.size(); i++) {
                JsonObject object = hitsArray.get(i).getAsJsonObject();
                results.add(new BeanResult<T>(hits.get(i).source,object.get("_id").getAsString()));
            }
        } else {
            logger.log(BaseDaoImpl.class, result==null?"null result":result.getErrorMessage());
        }
        return results;
    }

    public BeanResult<T> create(T entity, String type, Class<T> clazz) {
        JestClient client = clientFactory.getClient();
        DocumentResult result = jestService.index(client,INDEX_NAME, type, entity);
        if (result!=null && result.isSucceeded()) {
            return new BeanResult<T>(findById(result.getId(), type, clazz),result.getId());
        } else {
            logger.log(BaseDaoImpl.class, result==null?"null result":result.getErrorMessage());
        }
        return null;
    }

    public T update(T entity, String id, String type, Class<T> clazz) {
        JestClient client = clientFactory.getClient();
        DocumentResult result = jestService.index(client,INDEX_NAME, type, id+"", entity);
        if (result!=null && result.isSucceeded()) {
            return result.getSourceAsObject(clazz);
        } else {
            logger.log(BaseDaoImpl.class, result==null?"null result":result.getErrorMessage());
        }
        return null;
    }

    public T findById(String id, String type, Class<T> clazz) {
        JestClient client = clientFactory.getClient();
        JestResult result = jestService.get(client,INDEX_NAME, type, id+"");
        if (result!=null && result.isSucceeded()) {
            return result.getSourceAsObject(clazz);
        } else {
            logger.log(BaseDaoImpl.class, result==null?"null result":result.getErrorMessage());
        }
        return null;
    }

    public T delete(String id, String type, Class<T> clazz) {
        JestClient client = clientFactory.getClient();
        T data = findById(id, type, clazz);
        JestResult result = jestService.delete(client, INDEX_NAME, type, id);
        if (result!=null && result.isSucceeded()) {
            return data;
        } else {
            logger.log(BaseDaoImpl.class, result==null?"null result":result.getErrorMessage());
        }
        return null;
    }
}
