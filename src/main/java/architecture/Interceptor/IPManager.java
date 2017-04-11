package architecture.Interceptor;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by chentiange on 2017/4/12.
 */
public class IPManager {

    private static String filePath = System.getProperty("user.dir")+"/src/main/java/architecture/Interceptor/rejectedip";
    public boolean isIPVaild(String ip){
        boolean valid = true;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String tmp = null;
            while ((tmp=reader.readLine())!=null){
                if (tmp.equals(ip)){
                    valid = false;
                    return valid;
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valid;
    }

    public boolean addRejectedIP(String ip){
        boolean success = true;
        try {
            FileWriter fileWriter = new FileWriter(filePath,true);
            fileWriter.write(ip+"\n");
            fileWriter.close();
        } catch (IOException e) {
            return false;
        }

        return success;
    }

    public boolean removeRejectedIP(String ip){
        boolean success = true;

        ArrayList<String> ips = new ArrayList<String>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(filePath)));
        } catch (FileNotFoundException e) {
            return false;
        }
        String temp;
        try {
            while ((temp=br.readLine())!= null){
                ips.add(temp);
            }
        } catch (IOException e) {
            return false;
        }
        ips.remove(ip);
        try {
            FileWriter writer = new FileWriter(filePath,false);
            writer.write("");
            writer.close();

            FileWriter fileWriter = new FileWriter(filePath,true);
            for (String nowip:ips) {
                fileWriter.write(nowip + "\n");
            }
            fileWriter.close();
        }catch (IOException e){
           return false;
        }
        return success;
    }

    public Iterator<String> showRejectedIPs(){
        ArrayList<String> ips = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String tmp = null;
            while ((tmp=reader.readLine())!=null){
                ips.add(tmp);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ips.iterator();
    }

//    public static void main(String[] args) {
//        IPManager i = new IPManager();
//        System.out.println(i.isIPVaild("127.0.0.1"));
////        i.addRejectedIP("127.0.0.3");
////        i.removeRejectedIP("127.0.0.2");
//        Iterator<String> iterable = i.showRejectedIPs();
//        while (iterable.hasNext()){
//            System.out.println(iterable.next());
//        }
//    }
}
