package architecture.entity;

import lombok.Data;

import java.util.List;

/**
 * synonym entity
 * @author cuihao
 */
@Data
public class SynonymEntity {
    private List<String> words;
}
