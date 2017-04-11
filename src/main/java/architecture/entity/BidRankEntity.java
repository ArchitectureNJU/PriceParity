package architecture.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Paid listing info entity
 * @author cuihao
 */
@Data
@AllArgsConstructor
public class BidRankEntity {
    private String commodityMark;
    private double money;
}
