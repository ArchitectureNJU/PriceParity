package architecture.bean;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cxworks on 17-4-13.
 */
public class ServerInfo {

    String ip;
    int availableProcessors;
    long freeMemory;
    long totalMemory;
    long maxMemory;


    public ServerInfo(){
        Runtime runtime=Runtime.getRuntime();
        availableProcessors=runtime.availableProcessors();
        freeMemory=runtime.freeMemory();
        totalMemory=runtime.totalMemory();
        maxMemory=runtime.maxMemory();
        try {
            String ip=Inet4Address.getLocalHost().getHostAddress();
            this.ip=ip;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            this.ip="0.0.0.0";
        }
    }

    public Map getInfo(){
        Map req_payload = new HashMap();
        req_payload.put("ip", ip);
        req_payload.put("freeMemory",freeMemory);
        req_payload.put("totalMemory",totalMemory);
        req_payload.put("maxMemory",maxMemory);
        req_payload.put("avaliableProcessors",availableProcessors);
        return req_payload;
    }

    @Override
    public String toString() {
        return "ServerInfo{" +
                "ip='" + ip + '\'' +
                ", availableProcessors=" + availableProcessors +
                ", freeMemory=" + freeMemory +
                ", totalMemory=" + totalMemory +
                ", maxMemory=" + maxMemory +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getAvailableProcessors() {
        return availableProcessors;
    }

    public void setAvailableProcessors(int availableProcessors) {
        this.availableProcessors = availableProcessors;
    }

    public long getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(long freeMemory) {
        this.freeMemory = freeMemory;
    }

    public long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public long getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(long maxMemory) {
        this.maxMemory = maxMemory;
    }
}
