package architecture.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by chentiange on 2017/4/11.
 */
public class RobotInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    ServletContext context;

    /**
     * 默认限制时间（单位：ms）
     */
    private static final long LIMITED_TIME_MILLIS = 60 * 1000;

    /**
     * 用户连续访问最高阀值，超过该值则认定为恶意操作的IP，进行限制
     */
    private static final int LIMIT_NUMBER = 20;

    /**
     * 用户访问最小安全时间，在该时间内如果访问次数大于阀值，则记录为恶意IP，否则视为正常访问
     */
    private static final int MIN_SAFE_TIME = 5000;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String clientip = request.getRemoteAddr();
        if (!isRobot(request, clientip)){
            //intercept this request
            return false;
        }
        return true;
    }

    private boolean isRobot(HttpServletRequest request, String ip){
        boolean robot = false;
        Map<String, Long> robotIpMap = (Map<String, Long>) context.getAttribute("robotIpMap");
        filterRobotIpMap(robotIpMap);
        if (isLimitedIP(robotIpMap, ip)){
            long rejectedTime = robotIpMap.get(ip)-System.currentTimeMillis();
            //remaining time
            request.setAttribute("remainingTime", ((rejectedTime / 1000) + (rejectedTime % 1000 > 0 ? 1 : 0)));
            return false;
        }
        Map<String, Long[]> ipMap = (Map<String, Long[]>) context.getAttribute("ipMap");
        if (ipMap.containsKey(ip)) {
            Long[] ipInfo = ipMap.get(ip);
            ipInfo[0] = ipInfo[0] + 1;
            if (ipInfo[0] > LIMIT_NUMBER) {
                Long ipAccessTime = ipInfo[1];
                Long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ipAccessTime <= MIN_SAFE_TIME) {
                    robotIpMap.put(ip, currentTimeMillis + LIMITED_TIME_MILLIS);
                    request.setAttribute("remainingTime", LIMITED_TIME_MILLIS);
                    return false;
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
     * @param robotIpMap
     * @param ip
     * @return
     */
    private boolean isLimitedIP(Map<String, Long> robotIpMap, String ip) {
        if (robotIpMap == null || ip == null) {
            // not limited
            return false;
        }
        Set<String> keys = robotIpMap.keySet();
        Iterator<String> keyIt = keys.iterator();
        while (keyIt.hasNext()) {
            String key = keyIt.next();
            if (key.equals(ip)) {
                // limited
                return true;
            }
        }
        return false;
    }

    /**
     * get rid of out-dated robot
     * @param robotIpMap
     */
    private void filterRobotIpMap(Map<String, Long> robotIpMap) {
        if (robotIpMap == null){
            return;
        }
        Set<String> keys = robotIpMap.keySet();
        Iterator<String> keyIt = keys.iterator();
        long currentTimeMillis = System.currentTimeMillis();
        while (keyIt.hasNext()) {
            long expireTimeMillis = robotIpMap.get(keyIt.next());
            if (expireTimeMillis <= currentTimeMillis) {
                keyIt.remove();
            }
        }
    }
}
