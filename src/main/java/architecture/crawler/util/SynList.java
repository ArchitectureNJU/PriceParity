package architecture.crawler.util;

import architecture.dao.SynonymDao;
import architecture.entity.SynonymEntity;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by raychen on 2017/4/14.
 */
public class SynList {

    @Resource
    SynonymDao synonymDao;

    public void addToDatabase(String[][] syns){
        for (int i = 0;i < 13;i++){
            SynonymEntity entity = new SynonymEntity();
            List<String> list = new ArrayList<String>();

            for (int j = 0;j < syns[i].length;j++){
                    list.add(syns[i][j]);
            }
            entity.setWords(list);
            synonymDao.create(entity);
        }
    }


//    public static String[] hp = {"惠普", "hp", "hui pu", "huipu"};
//    public static String[] lx = {"联想", "lenovo","lianxiang"," lian xiang"," ThinkPad"};
//    public static String[] dl = {"戴尔","dell"};
//    public static String[] xm = {"小米","mi","xiaomi","xiao mi"};
//    public static String[] qh = {"清华同方","thtf","qhtf"};
//    public static String[] hw = {"华为","huawei"};
//    public static String[] pg = {"苹果","apple","pingguo","ping guo"};
//    public static String[] sx = {"三星","samsung"};
//    public static String[] hs = {"华硕","asus","huashuo","hua shuo"};
//    public static String[] he = {"海尔","haier"};
//    public static String[] zb = {"中柏","jumper"};
//    public static String[] fst = {"富士通","fujitsu"};
//    public static String[] wr = {"微软","microsoft"};
//    public static String[] dr = {"戴睿","dere"};
//    public static String[] ls = {"镭蛇","razer"};
//    public static String[] by = {"宝扬","byone"};
}
