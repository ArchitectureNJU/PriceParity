package architecture.bean;

import architecture.entity.BidRankEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * Data for display including id
 */
@Data
public class BidRankBean {
    private String id;
    private String commodityId;
    private double money;

    public BidRankBean() {
    }

    public BidRankBean(String id, BidRankEntity entity) {
        this.id = id;
        BeanUtils.copyProperties(entity,this);
    }


}
