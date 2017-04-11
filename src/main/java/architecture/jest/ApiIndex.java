package architecture.jest;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Api index param
 * @author cuihao
 */
@Data
@AllArgsConstructor
public class ApiIndex {
    private String _index;
    private String _type;
    private String _id;
    private String json;
}
