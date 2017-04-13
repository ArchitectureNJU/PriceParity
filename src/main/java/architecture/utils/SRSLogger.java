package architecture.utils;

import architecture.config.SystemConfig;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Logger util
 * @author cuihao
 */
@Component
public class SRSLogger {
    @Resource
    private SystemConfig systemConfig;

    public void log(Class clazz, String content) {
        if (systemConfig.isDebug()) {
            org.apache.log4j.Logger logger= org.apache.log4j.Logger.getLogger(clazz);
            logger.debug(content);
        }
    }
}
