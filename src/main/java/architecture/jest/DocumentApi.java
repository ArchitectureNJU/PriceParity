package architecture.jest;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;

/**
 * Standard document operation
 * @author cuihao
 */
public class DocumentApi {

    /**
     * Add or updates a JSON document in a specific index.<br/>
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


}
