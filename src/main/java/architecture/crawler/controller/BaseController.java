package architecture.crawler.controller;

import architecture.crawler.model.Product;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

import java.util.List;

/**
 * Created by raychen on 2017/4/12.
 */
public abstract class BaseController {

    public CrawlController controller;
    protected CrawlConfig config;
    public static final String saveRoot = "src/main/resources/store";

    protected void config(){
        config = new CrawlConfig();
        config.setMaxDepthOfCrawling(0);
        config.setMaxPagesToFetch(1);
    }

    public void start(Class c, int num){
        config();
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        try {
            controller = new CrawlController(config, pageFetcher, robotstxtServer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        addSeed();
        controller.start(c, num);
    }

    protected abstract void addSeed();

}
