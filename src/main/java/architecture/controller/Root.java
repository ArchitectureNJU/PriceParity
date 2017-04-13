package architecture.controller;

import architecture.bean.BlockIpBean;
import architecture.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Iterator;

/**
 * Created by cxworks on 17-4-12.
 */
@Controller("/root")
public class Root {
    @Autowired
    ManageService manageService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(Model model){


        return "";
    }


    public String getBlockIP(){}

}
