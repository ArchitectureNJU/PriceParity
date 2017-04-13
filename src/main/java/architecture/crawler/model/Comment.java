package architecture.crawler.model;

/**
 * Created by raychen on 2017/4/12.
 */
public class Comment {
    private String user;
    private String content;
    private String avatar;
    private String time;
    private String source;

    public void setUser(String user) {
        this.user = user;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getTime() {
        return time;
    }

    public String getSource() {
        return source;
    }
}
