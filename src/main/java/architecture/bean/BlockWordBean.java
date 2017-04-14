package architecture.bean;

import architecture.entity.BlockWordEntity;
import architecture.utils.DateUtils;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;

/**
 * block word data for display
 * @author cuihao
 */
@Data
public class BlockWordBean {
    private String id;
    private String keyWord;
    private String endTime;



    public BlockWordBean() {

        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.YEAR,1);
        endTime=DateUtils.dateToString(new Date(calendar.getTimeInMillis()));
    }

    public BlockWordBean(String id, BlockWordEntity entity) {
        this.id = id;
        this.keyWord = entity.getKeyWord();
        this.endTime = DateUtils.longToStringFull(entity.getEndTime());
    }
}
