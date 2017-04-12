package architecture.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chentiange on 2017/4/12.
 */
public class RobotListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        //store ip
        Map<String, Long[]> ipmap = new HashMap<>();
        context.setAttribute("ipmap", ipmap);
        //robot ip
        Map<String, Long> robotIpMap = new HashMap<String, Long>();
        context.setAttribute("robotIpMap", robotIpMap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
