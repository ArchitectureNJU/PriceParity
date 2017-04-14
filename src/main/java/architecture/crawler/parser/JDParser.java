package architecture.crawler.parser;

import architecture.crawler.model.Comment;
import architecture.crawler.model.Product;
import architecture.crawler.util.CrawlerUtil;
import architecture.crawler.util.FileUtil;
import architecture.dao.CommodityDao;
import architecture.dao.impl.CommodityDaoImpl;
import architecture.entity.CommodityEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by raychen on 2017/4/14.
 */
@Component
public class JDParser implements Parser{

    @Resource
    private CommodityDao commodityDao;

    private CrawlerUtil crawler = new CrawlerUtil();

    @Override
    public void parseHtml(String html) {
        Document doc = Jsoup.parse(html);
        Elements goodsList = doc
                .select("div#J_goodsList")
                .get(0)
                .select("li.gl-item");
        List<Product> products = new ArrayList<>();
        for (Element goods: goodsList) {
            String avatar_url = goods
                    .select("img.err-product")
                    .attr("src");
            String price = goods
                    .select("div.p-price i")
                    .text();
            String title = goods
                    .select("div.p-name a")
                    .attr("title");
            String id = goods.attr("data-sku");

            Product product = new Product();
            product.setAvatar(avatar_url);
            product.setId(id);
            product.setPrice(price);
            product.setTitle(title);
            product.setUrl("https://item.jd.com/"+id+".html");
            product.setSource("JD");
            product.setTime(new Date().toString());
            String detailHtml = crawler.processUrl("https://item.jd.com/"+id+".html");
            parseDetail(detailHtml, product);
            products.add(product);
        }
        addToDatabase(products);
    }

    @Override
    public void parseDetail(String html, Product product) {
        Document doc = Jsoup.parse(html);
        Element goodsDetail = doc
                .select("div.product-intro")
                .get(0);
        Elements comments = doc
                .select("div.J-comments-list div.comment-item");
        //update product
        if (product.getAvatar() == null){
            String avatarUrl = goodsDetail
                    .select("div#preview img#spec-img")
                    .attr("src");
            product.setAvatar(avatarUrl);
        }
        String depict = goodsDetail
                .select("div#p-ad")
                .text();
        product.setDepict(depict);
        //comments
        List<Comment> commentList = new ArrayList<>();
        for (Element e: comments) {
            Comment comment = new Comment();
            String avatar = e.select("div.user-info img").attr("src");
            String user = e.select("div.user-info").text();
            String content = e.select("div.comment-column p.comment-con").text();
            String time = e.select("div.comment-message div.order-info span")
                    .get(2)
                    .text();
            comment.setAvatar(avatar);
            comment.setTime(time);
            comment.setSource(product.getSource());
            comment.setUser(user);
            comment.setContent(content);
            commentList.add(comment);
        }
        product.setComments(commentList);
    }

    @Override
    public void addToDatabase(List<Product> products) {
        for (Product pr: products) {
            CommodityEntity entity = new CommodityEntity();
            entity.setSource(pr.getSource());
            entity.setAvatar(pr.getAvatar());
            entity.setComments(new ArrayList<>());
            entity.setPrice(Double.parseDouble(pr.getPrice()));
            entity.setName(pr.getTitle());
            entity.setUpdated_at(new Date(pr.getTime()));
            entity.setUrl(pr.getUrl());
            commodityDao.create(entity);
        }
    }

}
