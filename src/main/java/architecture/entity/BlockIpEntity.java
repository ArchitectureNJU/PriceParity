package architecture.entity;

import lombok.Data;

/**
 * BlockIp entity
 * @author cuihao
 */
@Data
public class BlockIpEntity {
    private String ip;
    private long endTime;
}
