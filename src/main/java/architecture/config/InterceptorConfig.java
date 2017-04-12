package architecture.config;

import architecture.Interceptor.IPInterceptor;
import architecture.Interceptor.RobotInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by chentiange on 2017/4/12.
 */
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new IPInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new RobotInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
