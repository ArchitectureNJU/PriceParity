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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by raychen on 2017/4/14.
 */
public class DDParser implements Parser {

    @Resource
    private CommodityDao commodityDao;

    private CrawlerUtil crawler = new CrawlerUtil();

    @Override
    public void parseHtml(String html) {
        Document doc = Jsoup.parse(html);
        Elements goodsList = doc
                .select("div#search_nature_rg li");
        List<Product> products = new ArrayList<>();
        for (Element goods: goodsList) {
            String avatar_url = goods
                    .select("img")
                    .attr("src");
            String price = goods
                    .select("p.price span")
                    .text();
            String title = goods
                    .select("p.name a")
                    .text();
            String id = goods.attr("id");

            Product product = new Product();
            product.setAvatar(avatar_url);
            product.setId(id);
            product.setPrice(price);
            product.setTitle(title);
            product.setUrl("http://product.dangdang.com/"+id+".html");
            product.setSource("DangDang");
            product.setTime(new Date().toString());
            String detailHtml = crawler.processUrl("http://product.dangdang.com/"+id+".html");
            parseDetail(detailHtml, product);
            products.add(product);
        }
        addToDatabase(products);
    }

    @Override
    public void parseDetail(String html, Product product) {
        Document doc = Jsoup.parse(html);
        Element goodsDetail = doc
                .select("div.product_main")
                .get(0);
        Elements comments = doc
                .select("div#comment_list div.comment_items");
        //update product
        if (product.getAvatar() == null){
            String avatarUrl = goodsDetail
                    .select("img#largePic")
                    .attr("src");
            product.setAvatar(avatarUrl);
        }
        //comments
        List<Comment> commentList = new ArrayList<>();
        for (Element e: comments) {
            Comment comment = new Comment();
            String avatar = e.select("div.items_left_pic img").attr("src");
            String user = e.select("div.items_left_pic span.name").text();
            String content = e.select("div.describe_detail span").text();
            String time = e.select("div.starline span").text();
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
