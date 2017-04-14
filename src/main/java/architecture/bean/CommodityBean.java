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

    public CommodityBean() {
    }

    public CommodityBean(String id, CommodityEntity entity) {
        this.id = id;
        BeanUtils.copyProperties(entity,this,"updated_at","comments");
        this.updated_at = DateUtils.dateToString(entity.getUpdated_at());
        comments = new ArrayList<>(entity.getComments());
    }

    public boolean blocked(List<String> rules){
        for (String s:rules){
            if (summary.contains(s)||description.contains(s))
                return true;
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }
}
