package architecture.entity;

import architecture.bean.SynonymBean;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

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

    public SynonymEntity() {
    }
    public SynonymEntity(String word){
        if (word==null||word.length()==0){
            words=new ArrayList<>();
        }else {
            String[] strs = word.split(",");
            words= Arrays.asList(strs);
        }
    }
}
