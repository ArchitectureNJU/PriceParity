package architecture.crawler;

import architecture.crawler.parser.*;
import architecture.crawler.util.CrawlerUtil;

import java.io.IOException;

/**
 * Created by raychen on 2017/4/12.
 */
public class Launcher {

    static CrawlerUtil crawler = new CrawlerUtil();
    static Parser parserJD = new JDParser();
    static Parser parserDD = new DDParser();
    static Parser parserE = new EbayParser();

    public static void main(String[] args) throws IOException {
        crawl("hp");
    }

    public static void crawl(String keyword){
        parserJD.parseHtml(crawler.processUrl("https://search.jd.com/Search?keyword="+keyword+"&enc=utf-8"));
//        parserDD.parseHtml(crawler.processUrl("http://search.dangdang.com/?key="+keyword+"&act=input"));
//        parserE.parseHtml(crawler.processUrl("http://www.ebay.com/sch/i.html?_from=R40&_nkw="+keyword+"&_sacat=0"));
    }

}
