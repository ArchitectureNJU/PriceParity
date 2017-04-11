package architecture.Interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by chentiange on 2017/4/11.
 */
public class IPInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String clientip = request.getRemoteAddr();
        IPManager manager = new IPManager();
        if (!manager.isIPVaild(clientip)){
            //intercept this request
            return false;
        }
        return true;
    }

}
