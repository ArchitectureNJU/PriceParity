package architecture.controller.task;

import architecture.bean.ServerInfo;
import architecture.config.SystemConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cxworks on 17-4-13.
 */
@Component
public class HeartBeat {


    @Autowired
    SystemConfig systemConfig;
    private static Logger logger=Logger.getLogger(HeartBeat.class);


    @Scheduled(fixedRate = 60000)
    public void beat(){
//
    }

}
