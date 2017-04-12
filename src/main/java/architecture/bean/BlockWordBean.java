package architecture.bean;

import architecture.entity.BlockWordEntity;
import architecture.utils.DateUtils;
import lombok.Data;

/**
 * block word data for display
 * @author cuihao
 */
@Data
public class BlockWordBean {
    private long id;
    private String keyWord;
    private String endTime;

    public BlockWordBean(long id, BlockWordEntity entity) {
        this.id = id;
        this.keyWord = entity.getKeyWord();
        this.endTime = DateUtils.longToStringFull(entity.getEndTime());
    }
}
