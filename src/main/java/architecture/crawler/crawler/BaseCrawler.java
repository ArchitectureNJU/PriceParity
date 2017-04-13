package architecture.crawler.crawler;

import architecture.crawler.model.Product;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by raychen on 2017/4/12.
 */
public abstract class BaseCrawler extends WebCrawler {

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !getPatten().matcher(href).matches()
                && href.startsWith(getDomain());
    }

    @Override
    public void visit(Page page) {
        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String html = htmlParseData.getHtml();
            parseHTML(html);
        }
    }

    public Pattern getPatten(){
        return Pattern.compile(".*(\\.(css|js|mp3|mp3|zip|gz))$");
    }

    public abstract String getDomain();
    public abstract void parseHTML(String html);

    protected void addToDatabase(List<Product> productList){

    }
}
