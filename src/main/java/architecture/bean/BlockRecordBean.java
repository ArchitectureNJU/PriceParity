package architecture.bean;

import architecture.entity.BlockRecordEntity;
import architecture.utils.DateUtils;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * block data for display
 * @author cuihao
 */
@Data
public class BlockRecordBean {
    private long id;
    private String ip;
    private String lastBlockTime;
    private long blockTime;

    public BlockRecordBean(long id, BlockRecordEntity entity) {
        this.id = id;
        BeanUtils.copyProperties(entity, this, "lastBlockTime");
        this.lastBlockTime = DateUtils.longToStringFull(entity.getBlockTime());
    }
}
