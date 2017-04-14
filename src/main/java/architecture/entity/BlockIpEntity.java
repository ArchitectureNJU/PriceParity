package architecture.entity;

import architecture.bean.BlockIpBean;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * BlockIp entity
 * @author cuihao
 */
@Data
@NoArgsConstructor
public class BlockIpEntity {
    private String ip;
    private long endTime;

    public BlockIpEntity(BlockIpBean bean) {
        this.ip = bean.getIp();
        this.endTime = new Date(bean.getEndTime()).getTime();
    }


}
