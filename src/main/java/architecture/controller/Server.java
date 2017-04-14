package architecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chenmuen on 2017/4/14.
 */
@Controller
@RequestMapping("/root/server")
public class Server {
    @RequestMapping("")
    public String serverPage() {
        return "server-records";
    }
}
