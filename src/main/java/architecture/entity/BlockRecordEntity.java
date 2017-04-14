package architecture.entity;

import architecture.bean.BlockRecordBean;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * block record entity
 * @author cuihao
 */
@Data
@NoArgsConstructor
public class BlockRecordEntity {
    private String ip;
    private long lastBlockTime;
    private long blockTime;
    private long times;

    public BlockRecordEntity(BlockRecordBean bean) {
        this.ip = bean.getIp();
        this.times = bean.getTimes();
        this.lastBlockTime = new Date(bean.getLastBlockTime()).getTime();
        this.blockTime = bean.getBlockTime();
    }
}
