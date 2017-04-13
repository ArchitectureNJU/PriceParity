package architecture.crawler.util;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.fetcher.PageFetchResult;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.parser.ParseData;
import edu.uci.ics.crawler4j.parser.Parser;
import edu.uci.ics.crawler4j.url.WebURL;
import org.apache.http.HttpStatus;

/**
 * Created by raychen on 2017/4/14.
 */
public class CrawlerUtil {

    private Parser parser;
    private PageFetcher pageFetcher;

    private void init(){
        CrawlConfig config = new CrawlConfig();
        parser = new Parser(config);
        pageFetcher = new PageFetcher(config);
    }

    public String processUrl(String url) {
        init();
        Page page = download(url);
        if (page != null) {
            ParseData parseData = page.getParseData();
            if (parseData != null) {
                if (parseData instanceof HtmlParseData) {
                    HtmlParseData htmlParseData = (HtmlParseData) parseData;
                    return htmlParseData.getHtml();
                }
            } else {
                System.out.println("Couldn't parse the content of the page.");
            }
        } else {
            System.out.println("Couldn't fetch the content of the page.");
        }
        System.out.println("==============");
        return null;
    }

    private Page download(String url) {
        WebURL curURL = new WebURL();
        curURL.setURL(url);
        PageFetchResult fetchResult = null;
        try {
            fetchResult = pageFetcher.fetchPage(curURL);
            if (fetchResult.getStatusCode() == HttpStatus.SC_OK) {
                Page page = new Page(curURL);
                fetchResult.fetchContent(page);
                parser.parse(page, curURL.getURL());
                return page;
            }
        } catch (Exception e) {
            System.err.println("Error occurred while fetching url: " + curURL.getURL() + e);
        } finally {
            if (fetchResult != null) {
                fetchResult.discardContentIfNotConsumed();
            }
        }
        return null;
    }
}
