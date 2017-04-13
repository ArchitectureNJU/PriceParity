package architecture.jest;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Used for query match
 */
@Data
@AllArgsConstructor
public class MatchObj {
    private String title;
    private String content;
}
