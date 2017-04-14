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

    public BlockIpBean(String id, BlockIpEntity entity) {
        this.id = id;
        this.ip = entity.getIp();
        this.endTime = DateUtils.longToStringFull(entity.getEndTime());
    }
}
