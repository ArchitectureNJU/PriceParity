package architecture.Interceptor;

import architecture.bean.BlockIpBean;
import architecture.bean.BlockWordBean;
import architecture.dao.BlockIpDao;
import architecture.entity.BlockIpEntity;
import architecture.entity.BlockWordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chentiange on 2017/4/12.
 */


public class IPManager {
    @Autowired
    BlockIpDao blockIpDao;

//    private static String filePath = System.getProperty("user.dir")+"/src/main/java/architecture/Interceptor/rejectedip";
    public boolean isIPVaild(String ip){
        boolean valid = true;
        List<BlockIpBean>  blockedipbeans = blockIpDao.findAll(-1,0);
        for (BlockIpBean bean : blockedipbeans){
            if (bean.getIp().equals(ip)){
                valid = false;
                return valid;
            }
        }
        return valid;
    }

    public boolean addRejectedIP(String ip){
        boolean success = true;
        BlockIpEntity entity = new BlockIpEntity();
        entity.setIp(ip);
        entity.setEndTime(System.currentTimeMillis());
        BlockIpBean result = blockIpDao.create(entity);
        if (result == null){
            success = false;
        }

        return success;
    }

    public boolean removeRejectedIP(String ip){
        boolean success = true;
        BlockIpBean bean = blockIpDao.findById(ip);
        String id = bean.getId();
        BlockIpBean result = blockIpDao.delete(id);
        if (result == null){
            success = false;
        }
        return success;
    }

    public Iterator<String> showRejectedIPs(){
        ArrayList<String> ips = new ArrayList<>();
        List<BlockIpBean>  blockedipbeans = blockIpDao.findAll(-1,0);
        for (BlockIpBean bean: blockedipbeans){
            ips.add(bean.getIp());
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
