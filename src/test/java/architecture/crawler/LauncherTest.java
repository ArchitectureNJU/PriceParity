package architecture.crawler;

import architecture.PriceParityApplicationTests;
import architecture.crawler.parser.JDParser;
import architecture.crawler.parser.Parser;
import architecture.crawler.util.CrawlerUtil;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by cuihao on 2017/4/14.
 */
public class LauncherTest extends PriceParityApplicationTests{

    static CrawlerUtil crawler = new CrawlerUtil();
    @Resource(type = JDParser.class)
    private Parser parserJD;
    @Test
    public void crawl() throws Exception {
        parserJD.parseHtml(crawler.processUrl("https://search.jd.com/Search?keyword="+"hp"+"&enc=utf-8"));
    }
}