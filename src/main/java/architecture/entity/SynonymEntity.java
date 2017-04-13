package architecture.entity;

import architecture.bean.SynonymBean;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * synonym entity
 * @author cuihao
 */
@Data
@NoArgsConstructor
public class SynonymEntity {
    private List<String> words;
    public SynonymEntity(SynonymBean bean) {
        words = new ArrayList<>(bean.getWords());
    }
}
