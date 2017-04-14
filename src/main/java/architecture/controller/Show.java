package architecture.controller;

import architecture.bean.CommodityBean;
import architecture.dao.CommodityDao;
import architecture.entity.CommodityEntity;
import architecture.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cxworks on 17-4-12.
 */
@Controller("/commodity")
public class Show {
    @Autowired
    CommodityService commodityService;


    @RequestMapping(value = "info",method = RequestMethod.GET)
    public String info(@RequestParam(value = "id")String id, Model model){
        CommodityBean ce=commodityService.find(id);
        model.addAttribute("goods",ce);
        return "details";
    }


    public Map<String,Object> add(@ModelAttribute("CommodityEntity")CommodityEntity entity){
        commodityService.add(entity);
        Map<String,Object> map=new HashMap<>();
        map.put("status","ok");
        return map;
    }


}
