package architecture.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by cxworks on 17-4-12.
 */
@Data
@Component
@ConfigurationProperties(prefix="system")
public class SystemConfig {
    private boolean debug;


    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
