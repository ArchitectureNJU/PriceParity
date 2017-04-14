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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
