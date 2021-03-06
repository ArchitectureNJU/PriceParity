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
    private String heartURL;

    public String getHeartURL() {
        return heartURL;
    }

    public void setHeartURL(String heartURL) {
        this.heartURL = heartURL;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
