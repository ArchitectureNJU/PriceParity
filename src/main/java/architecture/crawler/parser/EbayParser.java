package architecture.crawler.parser;

import architecture.crawler.model.Product;
import architecture.crawler.util.CrawlerUtil;
import architecture.crawler.util.FileUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by raychen on 2017/4/14.
 */
public class EbayParser implements Parser {

    private CrawlerUtil crawler = new CrawlerUtil();

    @Override
    public void parseHtml(String html) {
        Document doc = Jsoup.parse(html);
        Elements goodsList = doc
                .select("div#Results li.lvresult");
        List<Product> products = new ArrayList<>();
        for (Element goods: goodsList) {
            String avatar_url = goods
                    .select("div.lvpic img")
                    .attr("src");
            String price = goods
                    .select("li.lvprice span")
                    .text();
            String title = goods
                    .select("h3.lvtitle")
                    .text();
            String id = goods.attr("id");
            String url = goods
                    .select("h3.lvtitle a")
                    .attr("href");

            Product product = new Product();
            product.setAvatar(avatar_url);
            product.setId(id);
            product.setPrice(price);
            product.setTitle(title);
            product.setUrl(url);
            product.setSource("Ebay");
            product.setTime(new Date().toString());
            String detailHtml = crawler.processUrl(url);
//            parseDetail(detailHtml, product);
            products.add(product);
        }
        addToDatabase(products);
    }

    @Override
    public void parseDetail(String html, Product product) {
    }

    @Override
    public void addToDatabase(List<Product> products) {
        for (Product p: products) {
            FileUtil.printToFile(p.getId());
            FileUtil.printToFile(p.getTime());
            FileUtil.printToFile(p.getAvatar());
            FileUtil.printToFile(p.getDepict());
            FileUtil.printToFile(p.getPrice()+"");
            FileUtil.printToFile(p.getSource());
            FileUtil.printToFile(p.getTitle());
            FileUtil.printToFile(p.getUrl());
            FileUtil.printToFile("------------------------------------------------------");
        }
    }
}
