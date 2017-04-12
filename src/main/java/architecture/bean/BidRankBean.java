package architecture.bean;

import architecture.entity.BidRankEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * Data for display including id
 */
@Data
public class BidRankBean {
    private long id;
    private long commodityId;
    private double money;

    public BidRankBean(long id, BidRankEntity entity) {
        this.id = id;
        BeanUtils.copyProperties(entity,this);
    }
}
