package architecture.entity;

import architecture.bean.BidRankBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * Paid listing info entity
 * @author cuihao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BidRankEntity {
    private long commodityId;
    private double money;

    public BidRankEntity(BidRankBean bean) {
        BeanUtils.copyProperties(bean,this);
    }
}
