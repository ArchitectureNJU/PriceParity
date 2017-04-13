package architecture.controller;

import architecture.bean.BidRankBean;
import architecture.bean.BlockRecordBean;
import architecture.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;

/**
 * Created by cxworks on 17-4-13.
 */
@Controller("/root/bidrank/")
public class RootBidRank {

    @Autowired
    ManageService manageService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String getBidRank(
            @RequestParam(name = "offset",defaultValue = "0",required = false)int offset,
            @RequestParam(name = "size",defaultValue = "10",required = false)int size,
            Model model
    ){
       common(model, offset, size);
        return "";
    }


    private void common(Model model,int offset,int size){
        Iterator<BidRankBean> it=manageService.getBidRank(offset,size);
        model.addAttribute("bidRank",it);
    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(
            @ModelAttribute(name = "BidRankBean")BidRankBean bean,
            Model model){
        manageService.save(bean);
        common(model,0,10);
        return "";
    }
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(
            @ModelAttribute(name = "BidRankBean")BidRankBean bean,
            Model model
    ){
        manageService.save(bean);
        common(model,0,10);
        return "";
    }
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public String delete(@RequestParam(name = "id")String id,Model model){
        manageService.deleteBidRank(id);
        common(model,0,10);
        return "";
    }
}
