package architecture.crawler;

import architecture.crawler.controller.BaseController;
import architecture.crawler.controller.JDController;
import architecture.crawler.crawler.JDCrawler;
import architecture.crawler.parser.DDParser;
import architecture.crawler.parser.JDParser;
import architecture.crawler.parser.Parser;
import architecture.crawler.util.CrawlerUtil;
import architecture.crawler.util.JSEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by raychen on 2017/4/12.
 */
public class Launcher {

//    public static String JDtest = "https://search.jd.com/Search?keyword=hp&enc=utf-8";

    public static void main(String[] args) throws IOException {
//        String ans = JSEngine.getAjaxCotnent(JDtest);
//        JDCrawler crawler = new JDCrawler();
//        crawler.parseHTML(ans);
//        BaseController jdController = new JDController();
//        jdController.start(JDCrawler.class, 5);
        CrawlerUtil crawler = new CrawlerUtil();
        Parser parserJD = new JDParser();
        Parser parserDD = new DDParser();
        parserJD.parseHtml(crawler.processUrl("https://search.jd.com/Search?keyword=hp&enc=utf-8"));
        parserDD.parseHtml(crawler.processUrl("http://search.dangdang.com/?key=hp&act=input"));
    }

}
