package architecture.controller;

import architecture.dao.CommodityDao;
import architecture.entity.CommodityEntity;
import architecture.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.List;

/**
 * Created by cxworks on 17-4-12.
 */
@Controller("/search")
public class Search {

    @Autowired
    SearchService searchService;
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String search(
            @RequestParam(name = "key")String key,
            @RequestParam(name = "page",defaultValue = "1")int page,
            @RequestParam(name = "split",defaultValue = "10")int split
    ){
        Iterator<CommodityEntity> it=searchService.search(key, page, split);
        return "";
    }
}
