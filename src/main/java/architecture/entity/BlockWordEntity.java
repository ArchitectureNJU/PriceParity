package architecture.entity;

import architecture.bean.BlockWordBean;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

/**
 * block word
 */
@Data
public class BlockWordEntity {
    private String keyWord;
    private long endTime;

    public BlockWordEntity(BlockWordBean bean) {
        this.keyWord = bean.getKeyWord();
        this.endTime = new Date(bean.getEndTime()).getTime();
    }

    public BlockWordEntity(){
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.YEAR,1);
        endTime=calendar.getTimeInMillis();
    }

}
