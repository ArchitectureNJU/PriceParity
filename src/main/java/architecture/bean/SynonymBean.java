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


    public SynonymBean(String word){
        if (word==null||word.length()==0){
            words=new HashSet<>();
        }else {
            String[] strs = word.split(",");
            words=new HashSet<>();
            for (String s:strs)
                words.add(s);
        }
    }

    public SynonymBean() {
    }

    public SynonymBean(String id, SynonymEntity entity) {
        this.id = id;
        this.words = new HashSet<>(entity.getWords());
    }
}
