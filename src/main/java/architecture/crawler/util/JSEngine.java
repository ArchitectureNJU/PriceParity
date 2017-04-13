package architecture.crawler.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by raychen on 2017/4/13.
 */
public class JSEngine {
    public static String getAjaxCotnent(String url) throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("src/main/resources/phantomjs /Users/raychen/D/github/architectureNJU/PriceParity/src/main/resources/js/util.js "+url);//这里我的codes.js是保存在c盘下面的phantomjs目录
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer sbf = new StringBuffer();
        String tmp;
        while((tmp = br.readLine())!=null){
            sbf.append(tmp);
        }
        int t = sbf.indexOf("<html>");
        String ret = sbf.substring(t);
        return ret;
    }
}
