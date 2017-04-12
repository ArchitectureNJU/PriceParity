package architecture.controller;

import architecture.dao.CommodityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by cxworks on 17-4-12.
 */
@Controller("/")
public class Search {

    @Autowired
    CommodityDao commodityDao;
    @RequestMapping(value = "search",method = RequestMethod.GET)
    public String search(
            @RequestParam(name = "key")String key,
            @RequestParam(name = "page",defaultValue = "1")int page,
            @RequestParam(name = "split",defaultValue = "10")int split
    ){
        //List<CommodityEntity> results= commodityDao.findByKeyWord(key, (page-1)*split, split);
        return "";
    }
}
