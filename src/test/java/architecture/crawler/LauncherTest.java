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


        String[][] l = {
                {"联想", "lenovo","lianxiang"," lian xiang"," ThinkPad"},
                {"戴尔","dell"},
                {"小米","mi","xiaomi","xiao mi"},
                {"清华同方","thtf","qhtf"},
                {"华为","huawei"},
                {"苹果","apple","pingguo","ping guo"},
                {"三星","samsung"},
                {"华硕","asus","huashuo","hua shuo"},
                {"海尔","haier"},
                {"中柏","jumper"},
                {"富士通","fujitsu"},
                {"微软","microsoft"},
                {"镭蛇","razer"}
        };


//        for (int i = 0;i < 13;i++){
//            SynonymEntity entity = new SynonymEntity();
//            List<String> list = new ArrayList<String>();
//
//            for (int j = 0;j < l[i].length;j++){
////                if (j == 0)
////                    list.add(l[i][1]);
////                if (j == 1)
////                    list.add(l[i][0]);
////                else
//                    list.add(l[i][j]);
//            }
////
////
////            list.add("hp");
////            list.add("惠普");
////            list.add("hui pu");
////            list.add("huipu");
//            entity.setWords(list);
//            synonymDao.create(entity);
//
//
//        }

        SynonymEntity entity = new SynonymEntity();
        List<String> list = new ArrayList<String>();

        list.add("惠普");
        list.add("hp");
        list.add("hui pu");
        list.add("huipu");
        entity.setWords(list);
        synonymDao.create(entity);



    }
}