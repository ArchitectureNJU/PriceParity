package architecture.jest;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.*;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.mapping.GetMapping;
import io.searchbox.indices.mapping.PutMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Jest basic operation
 * @author cuihao
 */
@Service
public class JestService {

    /**
     * Create index
     * @param jestClient client
     * @param indexName name of index to be created
     * @return {@link JestClient}
     */
    public JestResult createIndex(JestClient jestClient, String indexName) {
        JestResult jr = null;
        try {
            jr = jestClient.execute(new CreateIndex.Builder(indexName).build());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return jr;
    }

    /**
     * Update mapping
     * @param jestClient jestClient
     * @param indexName index name
     * @param typeName type name
     * @param source update mapping json
     * @return {@link JestResult}
     */
    public JestResult createIndexMapping(JestClient jestClient, String indexName, String typeName, String source) {
        PutMapping putMapping = new PutMapping.Builder(indexName, typeName, source).build();
        try {
            return jestClient.execute(putMapping);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get document mapping
     * @param jestClient jestClient
     * @param indexName index name
     * @param typeName type name
     * @return {@link JestResult}
     */
    public JestResult getIndexMapping(JestClient jestClient, String indexName, String typeName) {
        GetMapping getMapping = new GetMapping.Builder().addIndex(indexName).addType(typeName).build();
        JestResult jr = null;
        try {
            jr = jestClient.execute(getMapping);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jr;
    }

    /**
     * Create documents
     * @param jestClient jestClient
     * @param indexName index name
     * @param typeName type name
     * @param objs objs need to be added.
     * @return {@link BulkResult}
     */
    public BulkResult index(JestClient jestClient, String indexName, String typeName, List objs) {

        Bulk.Builder bulk = new Bulk.Builder().defaultIndex(indexName).defaultType(typeName);
        for (Object obj : objs) {
            Index index = new Index.Builder(obj).build();
            bulk.addAction(index);
        }
        BulkResult br = null;
        try {
            br = jestClient.execute(bulk.build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return br;
    }

    public DocumentResult index(JestClient jestClient, String indexName, String typeName, String id, Object object) {
        Index index = new Index.Builder(object).index(indexName).type(typeName).id(id).build();
        DocumentResult result = null;
        try {
            result = jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Search document
     * @param jestClient jestClient
     * @param indexName index name
     * @param typeName type name
     * @param query query json
     * @return {@link SearchResult}
     */
    public SearchResult search(JestClient jestClient, String indexName, String typeName, String query) {

        Search search = new Search.Builder(query)
                .addIndex(indexName)
                .addType(typeName)
                .build();
        try {
            return jestClient.execute(search);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Count document number
     * @param jestClient jestClient
     * @param indexName index name
     * @param typeName type name
     * @param query query
     * @return {@link CountResult}
     */
    public CountResult count(JestClient jestClient, String indexName, String typeName, String query) {

        Count count = new Count.Builder()
                .addIndex(indexName)
                .addType(typeName)
                .query(query)
                .build();
        CountResult results = null;
        try {
            results = jestClient.execute(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * Get document
     * @param jestClient jest client
     * @param indexName index name
     * @param typeName type name
     * @param id document id
     * @return {@link JestClient}
     */
    public JestResult get(JestClient jestClient, String indexName, String typeName, String id) {

        Get get = new Get.Builder(indexName, id).type(typeName).build();
        try {
            return jestClient.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Delete index
     * @param jestClient jest client
     * @param indexName index name
     * @return {@link JestResult}
     */
    public JestResult delete(JestClient jestClient, String indexName) {

        JestResult jr = null;
        try {
            jr = jestClient.execute(new DeleteIndex.Builder(indexName).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jr;
    }

    /**
     * Delete document
     * @param jestClient jest client
     * @param indexName index name
     * @param typeName type name
     * @param id id
     * @return {@link DocumentResult}
     */
    public DocumentResult delete(JestClient jestClient, String indexName, String typeName, String id) {

        DocumentResult dr = null;
        try {
            dr = jestClient.execute(new Delete.Builder(id).index(indexName).type(typeName).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dr;
    }

}
