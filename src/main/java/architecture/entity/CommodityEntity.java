package architecture.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * commodity entity
 * @author cuihao
 */
@Data
public class CommodityEntity {
<<<<<<<

=======
//    @NotNull
    private int id;
//    @NotEmpty
>>>>>>>
    private String name;

    private double price;
    private String summary;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updated_at;
    private String url;
    private String source;
    private List<CommentEntity> comments;
}
