package architecture.entity;

import architecture.bean.CommodityBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * commodity entity
 * @author cuihao
 */
@Data
@NoArgsConstructor
public class CommodityEntity {

    private String name;
    private double price;
    private String summary;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updated_at;
    private String url;
    private String source;
    private String avatar;
    private List<CommentEntity> comments;

    public CommodityEntity(CommodityBean bean) {
        BeanUtils.copyProperties(bean,this,"updated_at","comments");
        this.updated_at = new Date(bean.getUpdated_at());
        comments = new ArrayList<>(bean.getComments());
    }


}
