package architecture.jest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Used for template
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeanResult<T> {
    private T data;
    private String id;
}
