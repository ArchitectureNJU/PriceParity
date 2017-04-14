package architecture.crawler.util;

import architecture.crawler.parser.Parser;

/**
 * Created by raychen on 2017/4/14.
 */
public class CrawlThread implements Runnable {

    static CrawlerUtil crawler = new CrawlerUtil();
    private Parser parser;
    private String url;

    public CrawlThread(Parser parser, String url) {
        this.parser = parser;
        this.url = url;
    }

    @Override
    public void run() {
        parser.parseHtml(crawler.processUrl(url));
    }
}
