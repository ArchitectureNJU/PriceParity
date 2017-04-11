package architecture.jest;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetRequestBuilder;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;

import java.util.List;

/**
 * Standard document operation
 * @author cuihao
 */
public class DocumentApi {

    /**
     * Update a JSON document in a specific index.<br/>
     * PUT _index/_type/_id
     * {
     * ...json
     * }
     * @param client created client
     * @param index index param
     * @return {@link IndexResponse}(index,type,id,version,status)
     */
    public static IndexResponse index(Client client, ApiIndex index) {
        return client.prepareIndex(index.get_index(), index.get_type(), index.get_id())
                .setSource(index.getJson()).get();
    }

    /**
     * Create a JSON document in a specific index.<br/>
     * POST _index/_type/_id
     * {
     * ...json
     * }
     * @param client created client
     * @param index index param
     * @return {@link IndexResponse}(index,type,id,version,status)
     */
    public static IndexResponse post(Client client, ApiIndex index) {
        return client.prepareIndex(index.get_index(), index.get_type())
                .setSource(index.getJson()).get();
    }

    /**
     * Get a typed JSON document by id
     * GET _index/_type/_id
     * @param client client
     * @param index index param
     * @return {@link GetResponse}(source)
     */
    public static GetResponse get(Client client, ApiIndex index) {
        return client.prepareGet(index.get_index(), index.get_type(), index.get_id())
                .setOperationThreaded(true).get();
    }

    /**
     * Delete a typed JSON document by id
     * DELETE _index/_type/_id
     * @param client client
     * @param index index param
     * @return {@link DeleteResponse}
     */
    public static DeleteResponse delete(Client client, ApiIndex index) {
        return client.prepareDelete(index.get_index(), index.get_type(), index.get_id()).get();
    }

    /**
     * Update a typed JSON document. DIFFERENT from index: you can update a part of document.
     * @param client client
     * @param index index param
     * @return {@link UpdateResponse}
     */
    public static UpdateResponse update(Client client, ApiIndex index) {
        return client.prepareUpdate(index.get_index(), index.get_type(), index.get_id())
                .setDoc(index.getJson()).get();
    }

    /**
     * Multiple get operation executed in one request.
     * @param client client
     * @param indexs index
     * @return {@link MultiGetResponse}
     * for (MultiGetItemResponse itemResponse : multiGetItemResponses) {
     *      GetResponse response = itemResponse.getResponse();
     *      if (response.isExists()) {
     *          String json = response.getSourceAsString();
     *      }
     * }
     */
    public static MultiGetResponse multiGet(Client client, List<ApiIndex> indexs) {
        MultiGetRequestBuilder builder = client.prepareMultiGet();
        indexs.forEach(index->builder.add(index.get_index(), index.get_type(), index.get_id()));
        return builder.get();
    }

    /**
     * Bulk allows one to index and delete several documents in single request
     * @param client elastic client
     * @param indexList index list: if json is null,the generate a delete request
     * @return {@link BulkResponse}
     */
    public static BulkResponse bulk(Client client, List<ApiIndex> indexList) {
        BulkRequestBuilder builder = client.prepareBulk();
        indexList.forEach(index -> {
            if (index.getJson()!=null && !index.getJson().isEmpty()) {
                builder.add(client.prepareIndex(index.get_index(), index.get_type(), index.get_id())
                        .setSource(index.getJson()));
            } else {
                builder.add(client.prepareDelete(index.get_index(), index.get_type(), index.get_id()));
            }
        });
        return builder.get();
    }

}
