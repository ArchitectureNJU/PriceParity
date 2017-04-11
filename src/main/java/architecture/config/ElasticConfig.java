package architecture.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * elasticSearch config file
 * @author cuihao
 */
@Data
@Component
@ConfigurationProperties(prefix="elasticsearch")
public class ElasticConfig {
    private String cluster;
    private List<String> hosts;
}
