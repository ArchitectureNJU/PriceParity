package architecture.entity;

import architecture.bean.BlockWordBean;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * block word
 */
@Data
@NoArgsConstructor
public class BlockWordEntity {
    private String keyWord;
    private long endTime;

    public BlockWordEntity(BlockWordBean bean) {
        this.keyWord = bean.getKeyWord();
        this.endTime = new Date(bean.getEndTime()).getTime();
    }
}
