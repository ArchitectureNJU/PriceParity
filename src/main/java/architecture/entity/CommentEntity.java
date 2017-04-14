package architecture.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Comment entity
 * @author cuihao
 */
@Data
public class CommentEntity {
    private String user;
    private String content;
    private String url;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created_at;
    private String source;
    private int status;

    public CommentEntity() {
    }
}
