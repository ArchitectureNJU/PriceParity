package architecture.crawler.model;

import java.util.List;

/**
 * Created by raychen on 2017/4/12.
 */
public class Product {
    private String id;
    private String title;
    private String price;
    private String depict;
    private String detail;
    private String time;
    private String url;
    private String source;
    private String avatar;
    private List<Comment> comments;

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComments() {

        return comments;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getDepict() {
        return depict;
    }

    public String getDetail() {
        return detail;
    }

    public String getTime() {
        return time;
    }

    public String getUrl() {
        return url;
    }

    public String getSource() {
        return source;
    }

    public String getAvatar() {
        return avatar;
    }
}
