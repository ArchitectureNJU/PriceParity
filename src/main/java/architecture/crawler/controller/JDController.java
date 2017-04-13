package architecture.crawler.controller;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;

/**
 * Created by raychen on 2017/4/12.
 */
public class JDController extends BaseController {

    @Override
    protected void config() {
        super.config();
        config.setCrawlStorageFolder(saveRoot+"/jd");
        config.setPolitenessDelay(1000);
    }

    @Override
    protected void addSeed() {
        controller.addSeed("https://search.jd.com/Search?keyword=hp&enc=utf-8");
    }
}
