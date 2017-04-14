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
    private String id;
    private Set<String> words;


    public SynonymBean() {
    }

    public SynonymBean(String id, SynonymEntity entity) {
        this.id = id;
        this.words = new HashSet<>(entity.getWords());
    }
}
