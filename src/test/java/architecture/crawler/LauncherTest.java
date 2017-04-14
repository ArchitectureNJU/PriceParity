package architecture.crawler;

import architecture.PriceParityApplicationTests;
import architecture.crawler.parser.DDParser;
import architecture.crawler.parser.EbayParser;
import architecture.crawler.parser.JDParser;
import architecture.crawler.parser.Parser;
import architecture.crawler.util.CrawlThread;
import architecture.crawler.util.CrawlerUtil;
import architecture.dao.SynonymDao;
import architecture.dao.impl.SynonymDaoImpl;
import architecture.entity.SynonymEntity;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cuihao on 2017/4/14.
 */
public class LauncherTest extends PriceParityApplicationTests{

    static CrawlerUtil crawler = new CrawlerUtil();

//    @Resource(type = JDParser.class)
//    private Parser parserJD;
//    @Resource(type = DDParser.class)
//    private Parser parserDD;
    @Resource(type = EbayParser.class)
    private Parser parserEbay;

//    @Test
    public void sout(){

        System.out.println('¥' + 1);
    }


//    @Test
    public void crawl() throws Exception {

        String[] cos = {"lenovo","ThinkPad","dell","mi","huawei","apple","samsung",
                "asus","haier","fujitsu","microsoft","dere","razer","jumper"};
//        String[] cos = {"mi","huawei","apple","samsung",
//                "asus","haier","fujitsu","microsoft","dere","razer","jumper"};
//        String[] cos2 = {"mi","thtf","huawei","apple","samsung",
//                "asus","haier","fujitsu","microsoft","dere","razer","jumper"};

        for (int i = 0;i < cos.length;i++){
//            parserJD.parseHtml(crawler.processUrl("https://search.jd.com/Search?keyword="+cos[i]+"&enc=utf-8"));
//            parserDD.parseHtml(crawler.processUrl("http://search.dangdang.com/?key="+cos[i]+"&act=input"));
            parserEbay.parseHtml(crawler.processUrl("http://www.ebay.com/sch/i.html?_from=R40&_nkw="+cos[i]+"&_sacat=0"));
        }

//        parserJD.parseHtml(crawler.processUrl("https://search.jd.com/Search?keyword="+"hp"+"&enc=utf-8"));
//        parserDD.parseHtml(crawler.processUrl("http://search.dangdang.com/?key="+"hp"+"&act=input"));
//        parserEbay.parseHtml(crawler.processUrl("http://www.ebay.com/sch/i.html?_from=R40&_nkw="+"hp"+"&_sacat=0"));
    }

    @Resource
    SynonymDao synonymDao;
    @Test
    public void addSyn(){

        SynonymEntity entity = new SynonymEntity();
        List<String> list = new ArrayList<String>();
        list.add("hp");
        list.add("惠普");
        list.add("hui pu");
        list.add("huipu");
        entity.setWords(list);
        synonymDao.create(entity);



    }
}