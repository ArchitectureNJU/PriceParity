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
    private List<String> words;

    public SynonymBean(String id, SynonymEntity entity) {
        this.id = id;
        this.words = new ArrayList<>(entity.getWords());
    }

    public boolean has(String str){return words.contains(str);}
    public String getZero(){return words==null||words.isEmpty()?"":words.get(0);}

}
