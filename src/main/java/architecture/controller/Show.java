package architecture.controller;

import architecture.dao.CommodityDao;
import architecture.entity.CommodityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by cxworks on 17-4-12.
 */
@Controller("/commodity")
public class Show {
    @Autowired
    CommodityDao commodityDao;


    @RequestMapping(value = "info",method = RequestMethod.GET)
    public String info(@RequestParam(value = "id")int id){
        CommodityEntity ce=commodityDao.findById(id);
        return "";
    }
}
