package architecture.crawler.parser;

import architecture.crawler.model.Product;

import java.util.List;

/**
 * Created by raychen on 2017/4/14.
 */
public interface Parser {
    void parseHtml(String html);
    void parseDetail(String html, Product product);
    void addToDatabase(List<Product> products);
}
