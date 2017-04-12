package architecture.entity;

import lombok.Data;

/**
 * block record entity
 * @author cuihao
 */
@Data
public class BlockRecordEntity {
    private String ip;
    private long lastBlockTime;
    private long blockTime;
}
