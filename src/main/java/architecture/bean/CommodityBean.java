package architecture.bean;

import architecture.entity.CommentEntity;
import architecture.entity.CommodityEntity;
import architecture.utils.DateUtils;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * commodity bean fot display
 * @author cuihao
 */
@Data
public class CommodityBean {
    private String id;
    private String name;
    private double price;
    private String summary;
    private String description;
    private String updated_at;
    private String url;
    private String source;
    private String avatar;
    private List<CommentEntity> comments;

    public CommodityBean(String id, CommodityEntity entity) {
        this.id = id;
        BeanUtils.copyProperties(entity,this,"updated_at","comments");
        this.updated_at = DateUtils.dateToString(entity.getUpdated_at());
        comments = new ArrayList<>(entity.getComments());
    }
}
