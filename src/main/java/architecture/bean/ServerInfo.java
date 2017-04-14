package architecture.bean;

import architecture.utils.JsonMapping;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
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
    boolean running;
    Date date;


    public ServerInfo(){
        Runtime runtime=Runtime.getRuntime();
        availableProcessors=runtime.availableProcessors();
        freeMemory=runtime.freeMemory();
        totalMemory=runtime.totalMemory();
        maxMemory=runtime.maxMemory();
        try {
            String ip=Inet4Address.getLocalHost().getHostAddress();
            running=true;
            this.ip=ip;
            date=new Date(Calendar.getInstance().getTimeInMillis());
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
        req_payload.put("state",running);
        req_payload.put("date",date);
        return req_payload;
    }

    @Override
    public String toString() {
        return JsonMapping.toJson(this);
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

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
