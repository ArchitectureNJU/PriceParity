package architecture.crawler.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;

/**
 * Created by raychen on 2017/4/12.
 */
public class JDCrawler extends BaseCrawler {

    private static final String domain = "https://www.jd.com/";
    private BufferedWriter writer;

    @Override
    public String getDomain() {
        return domain;
    }

    @Override
    public void parseHTML(String html) {
    }


}
