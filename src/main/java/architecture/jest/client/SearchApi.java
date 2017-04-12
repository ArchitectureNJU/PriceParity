package architecture.jest.client;

import architecture.jest.ApiIndex;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.Nullable;
import org.elasticsearch.index.query.QueryBuilder;

/**
 * elastic search api
 * @deprecated
 * @author cuihao
 */
public class SearchApi {

    /**
     * Get all documents of one type.
     * @param client client
     * @param index index param
     * @param offset offset items
     * @param size size of query
     * @return {@link SearchResponse}
     */
    public static SearchResponse searchAll(Client client, ApiIndex index, int offset, int size) {
        return client.prepareSearch(index.get_index())
                .setTypes(index.get_type())
                .setFrom(offset).setSize(size).get();
    }

    /**
     * Core search api of elastic
     * @param client elastic client
     * @param indexs all indexs need to be searched
     * @param types all types
     * @param query query DSL message (score field)
     * @param filter filter message (non-score field)
     * @param offset offset items
     * @param size size
     * @return {@link SearchResponse}
     */
    public static SearchResponse search(Client client, String[] indexs, String[] types,
                                        @Nullable QueryBuilder query, @Nullable QueryBuilder filter, int offset, int size) {
        SearchRequestBuilder builder =  client.prepareSearch(indexs)
                .setTypes(types)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
        if (query!=null) builder.setQuery(query);
        if (filter!=null) builder.setPostFilter(filter);
        if (offset>=0) builder.setFrom(offset);
        if (size>=0) builder.setSize(size);
        return builder.get();
    }
}
