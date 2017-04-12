package architecture.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by cxworks on 17-4-12.
 */
@Aspect
@Component
@Configuration
@ConfigurationProperties(prefix = "system")
public class ControllerAS {


    private static Logger logger=Logger.getLogger(ControllerAS.class);
    @NotBlank
    private boolean debug;
    @Pointcut(value = "execution(* architecture.controller..*.*(..))")
    public void anyPublicMethod(){
        if (debug){
            logger.debug("computing");
        }
    }


    @Before("anyPublicMethod()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容

        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        if (debug){
            logger.debug("IP : " + request.getRemoteAddr());
            logger.debug("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            logger.debug("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        }
    }
    @AfterReturning(returning = "ret", pointcut = "anyPublicMethod()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        if (debug) {
            logger.info("RESPONSE : " + ret);
        }
    }

}
