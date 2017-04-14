package architecture.crawler.parser;

import architecture.crawler.model.Product;
import architecture.crawler.util.CrawlerUtil;
import architecture.crawler.util.FileUtil;
import architecture.dao.CommodityDao;
import architecture.entity.CommodityEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by raychen on 2017/4/14.
 */
@Component
public class EbayParser implements Parser {

    @Resource
    private CommodityDao commodityDao;

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
        for (Product pr: products) {

            System.out.println(pr.getTitle());

            CommodityEntity entity = new CommodityEntity();
            entity.setSource(pr.getSource());
            entity.setAvatar(pr.getAvatar());
            entity.setComments(new ArrayList<>());
            String price = pr.getPrice();
            price = price.substring(4,price.length());
            price = price.replace(",","");
            int index = price.indexOf('.');
            if (index != -1)
                price = price.substring(0,index + 3);

            System.out.println(price);


            entity.setPrice(Double.parseDouble(price));
            entity.setName(pr.getTitle());
            entity.setUpdated_at(new Date(pr.getTime()));
            entity.setUrl(pr.getUrl());
            commodityDao.create(entity);
        }
    }
}
