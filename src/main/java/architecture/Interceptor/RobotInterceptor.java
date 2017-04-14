package architecture.Interceptor;

import architecture.bean.BlockRecordBean;
import architecture.dao.BlockRecordDao;
import architecture.entity.BlockRecordEntity;
import architecture.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by chentiange on 2017/4/11.
 */

public class RobotInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    BlockRecordDao blockRecordDao;
    @Autowired
    ServletContext context;

    /**
     * limit time
     */
    private static final long LIMITED_TIME_MILLIS = 60 * 1000;

    /**
     * times in security time
     */
    private static final int LIMIT_NUMBER = 20;

    /**
     * security time
     */
    private static final int MIN_SAFE_TIME = 5000;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String clientip = request.getRemoteAddr();
        if (isRobot(request,response, clientip)){
            response.sendRedirect(request.getContextPath()+"/frequent");
            //intercept this request
            return false;
        }
        return true;
    }


    private boolean isRobot(HttpServletRequest request, HttpServletResponse response, String ip) throws ServletException, IOException {
        boolean robot = false;
        List<BlockRecordBean> records = blockRecordDao.findAll(-1,0);
        filterRobotIpRecord(records);
        if (isLimitedIP(records, ip)){
            String id = new String();
            for (BlockRecordBean record: records){
                if (record.getIp().equals(ip)){
                    id = record.getId();
                }
            }
            BlockRecordBean bean = blockRecordDao.findById(id);


            long lastBlockTime = System.currentTimeMillis();
            bean.setLastBlockTime(DateUtils.longToStringFull(lastBlockTime));
            long blockTime = lastBlockTime + LIMITED_TIME_MILLIS;
            bean.setBlockTime(blockTime);
            long times = bean.getTimes();
            times++;
            bean.setTimes(times);
            //update record
            blockRecordDao.save(bean);



            //remaining time
//            String blocktimeStr = bean.getBlockTime();
//            long rejectedTime = DateUtils.StringFullToLong(blocktimeStr)-System.currentTimeMillis();
//            request.setAttribute("remainingTime", ((rejectedTime / 1000) + (rejectedTime % 1000 > 0 ? 1 : 0)));
            return true;
        }
        Map<String, Long[]> ipMap = (Map<String, Long[]>) context.getAttribute("ipMap");
        if (ipMap.containsKey(ip)) {
            Long[] ipInfo = ipMap.get(ip);
            ipInfo[0] = ipInfo[0] + 1;
            if (ipInfo[0] > LIMIT_NUMBER) {
                Long ipAccessTime = ipInfo[1];
                Long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ipAccessTime <= MIN_SAFE_TIME) {
                    //add new record
                    BlockRecordEntity entity = new BlockRecordEntity();
                    entity.setIp(ip);
                    entity.setBlockTime(currentTimeMillis + LIMITED_TIME_MILLIS);
                    entity.setLastBlockTime(currentTimeMillis);
                    entity.setTimes(1);
                    blockRecordDao.create(entity);
//                    request.setAttribute("remainingTime", LIMITED_TIME_MILLIS);
                    response.sendRedirect(request.getContextPath()+"/frequent");
                    return true;
                } else {
                    initIpVisitsNumber(ipMap, ip);
                }
            }
        } else {
            initIpVisitsNumber(ipMap, ip);
        }
        context.setAttribute("ipMap", ipMap);
        return robot;
    }

    private void initIpVisitsNumber(Map<String, Long[]> ipMap, String ip) {
        Long[] ipInfo = new Long[2];
        ipInfo[0] = 0L;// counter
        ipInfo[1] = System.currentTimeMillis();// the first time
        ipMap.put(ip, ipInfo);
    }

    /**
     * compare ip
     * @param records
     * @param ip
     * @return
     */
    private boolean isLimitedIP(List<BlockRecordBean> records, String ip) {
        if (records == null || ip == null) {
            // not limited
            return false;
        }
        for (BlockRecordBean record: records){
            if (record.getIp().equals(ip)){
                return true;
            }
        }
        return false;
    }

    /**
     * get rid of out-dated robot
     * @param records
     */
    private void filterRobotIpRecord(List<BlockRecordBean> records) {
        if (records == null){
            return;
        }
        for (BlockRecordBean record: records){

            long expireTime = record.getBlockTime();
            long currentTime = System.currentTimeMillis();
            if (expireTime <= currentTime){
                String id = record.getId();
                blockRecordDao.delete(id);
            }

        }
    }
}
