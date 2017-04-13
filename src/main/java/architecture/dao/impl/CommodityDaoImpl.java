package architecture.dao.impl;

import architecture.bean.CommodityBean;
import architecture.dao.CommodityDao;
import architecture.entity.CommodityEntity;
import architecture.jest.*;
import architecture.utils.JsonMapping;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.searchbox.core.SearchResult;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Commodity dao impl
 * @author cuihao
 */
@Repository
public class CommodityDaoImpl extends BaseDaoImpl<CommodityEntity> implements CommodityDao {

    private final String TYPE_NAME = "commodity";

    @Resource
    private JestService jestService;

    @Resource
    private ClientFactory clientFactory;
    /**
     * Get detail info of a commodity by document id
     *
     * @param id id of DOCUMENT
     * @return {@link CommodityBean}
     */
    @Override
    public CommodityBean findById(String id) {
        CommodityEntity entity = super.findById(id,TYPE_NAME, CommodityEntity.class);
        if (entity!=null) {
            new CommodityBean(id, entity);
        }
        return null;
    }

    /**
     * Core search method of commodities.
     *
     * @param keyword plain keyword (natural language) or empty string or null
     * @param offset  offset items default 0 (GREATER THAN OR EQUAL TO 0)
     * @param limit   limit items
     * @return sorted list of commodity entity.<br/>
     * if keyword is provided, the list will be sorted by correlation.<br/>
     * if keyword is null or empty, the list will be sorted by updated time.
     */
    @Override
    public List<CommodityBean> findByKeyWord(List<String> keyword, int offset, int limit) {
        Map<String,Object> query = new HashMap<>();
        if (offset>=0 && limit >= 0) {
            query.put("from",offset);
            query.put("size",limit);
        }
        if (keyword!=null && keyword.size()>0) {
            StringBuilder queryKey = new StringBuilder("");
            for (String string: keyword) {
                queryKey.append(string).append(" ");
            }
            query.put("query",new QueryObj(new MatchObj(queryKey.toString(), queryKey.toString())));
        }
        SearchResult result =
                jestService.search(clientFactory.getClient() ,"srs", TYPE_NAME, JsonMapping.toJson(query));
        List<BeanResult<CommodityEntity>> results = new ArrayList<>();
        if (result!=null && result.isSucceeded()) {
            List<SearchResult.Hit<CommodityEntity,Void>> hits = result.getHits(CommodityEntity.class);
            JsonObject jsonObject = result.getJsonObject();
            JsonArray hitsArray = jsonObject.getAsJsonObject("hits").getAsJsonArray("hits");
            for (int i = 0; i < result.getTotal(); i++) {
                JsonObject object = hitsArray.get(i).getAsJsonObject();
                results.add(new BeanResult<>(hits.get(i).source,object.get("_id").getAsString()));
            }
        }
        return results.stream()
                .map(r->new CommodityBean(r.getId(),r.getData())).collect(Collectors.toList());
    }

    /**
     * Update commodity entity
     *
     * @param commodityEntity commodity entity with ID
     * @return updated entity
     */
    @Override
    public CommodityBean save(CommodityBean commodityEntity) {
        CommodityEntity entity =
                super.update(new CommodityEntity(commodityEntity),commodityEntity.getId(),TYPE_NAME, CommodityEntity.class);
        if (entity!=null) {
            return new CommodityBean(commodityEntity.getId(), entity);
        }
        return null;
    }

    /**
     * Delete a commodity by id
     *
     * @param id id
     * @return deleted commodity
     */
    @Override
    public CommodityBean delete(String id) {
        CommodityEntity entity = super.delete(id,TYPE_NAME, CommodityEntity.class);
        if (entity!=null) {
            return new CommodityBean(id, entity);
        } else {
            return null;
        }
    }
}
