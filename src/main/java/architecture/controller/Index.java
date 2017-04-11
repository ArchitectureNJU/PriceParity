package architecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cxworks on 17-4-10.
 */
@Controller("/")
public class Index {
    @RequestMapping("")
    public String index(){
        return "redirect:http://software.nju.edu.cn";
    }
}