package architecture.bean;

import architecture.entity.BlockIpEntity;
import architecture.utils.DateUtils;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Data for display
 * block ip bean
 * @author cuihao
 */
@Data
public class BlockIpBean {
    private String id;
    private String ip;
    private String endTime;

    public BlockIpBean() {
    }

    public BlockIpBean(String id, BlockIpEntity entity) {
        this.id = id;
        this.ip = entity.getIp();
        this.endTime = DateUtils.longToStringFull(entity.getEndTime());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
