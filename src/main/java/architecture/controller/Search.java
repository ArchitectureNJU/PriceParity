package architecture.controller;

import architecture.bean.CommodityBean;
import architecture.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Iterator;
import java.util.List;

/**
 * Created by cxworks on 17-4-12.
 */
@Controller
public class Search {

    @Autowired
    SearchService searchService;
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String search(
            @RequestParam(name = "key")String key,
            @RequestParam(name = "page",defaultValue = "0")int page,
            @RequestParam(name = "split",defaultValue = "500")int split,
            Model model
    ){

        List<CommodityBean> it=searchService.search(key, page, split);
        model.addAttribute("goodsList",it);
        return "list";
    }
}
