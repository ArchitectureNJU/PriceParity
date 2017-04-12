package architecture.bean;

import architecture.entity.SynonymEntity;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * synonym data for display
 * @author cuihao
 */
@Data
public class SynonymBean {
    private long id;
    private Set<String> words;

    public SynonymBean(long id, SynonymEntity entity) {
        this.id = id;
        this.words = new HashSet<>(entity.getWords());
    }
}
