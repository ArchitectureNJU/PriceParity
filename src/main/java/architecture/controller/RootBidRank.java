package architecture.controller;

import architecture.bean.BidRankBean;
import architecture.bean.BlockRecordBean;
import architecture.entity.BidRankEntity;
import architecture.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.List;

/**
 * Created by cxworks on 17-4-13.
 */
@Controller
public class RootBidRank {

    @Autowired
    ManageService manageService;

    @RequestMapping(value = "/root/bidrank",method = RequestMethod.GET)
    public String getBidRank(
            @RequestParam(name = "offset",defaultValue = "-1",required = false)int offset,
            @RequestParam(name = "size",defaultValue = "-1",required = false)int size,
            Model model
    ){
        common(model, offset, size);
        return "bid-manage";
    }


    private void common(Model model,int offset,int size){
        List<BidRankBean> it=manageService.getBidRank(offset,size);
        model.addAttribute("bidList",it);
    }

    @RequestMapping(value = "/root/bidrank/update",method = RequestMethod.GET)
    public String updatePage(@RequestParam String id,Model model)
    {
        BidRankBean bidRankBean=manageService.findBidRankByid(id);
        model.addAttribute("goods",bidRankBean);
        return "bid-update";
    }

    @RequestMapping(value = "/root/bidrank/update",method = RequestMethod.POST)
    public String update(
            @ModelAttribute(name = "BidRankBean")BidRankBean bean,
            Model model){
        manageService.save(bean);
        return "redirect:/root/bidrank";
    }

    @RequestMapping(value = "/root/bidrank/add",method = RequestMethod.GET)
    public String addPage() {
        return "bid-add";
    }

    @RequestMapping(value = "/root/bidrank/add",method = RequestMethod.POST)
    public String add(
            @ModelAttribute(name = "BidRankEntity")BidRankEntity entity,
            Model model
    ){
        manageService.create(entity);
        return "redirect:/root/bidrank";
    }
    @RequestMapping(value = "/root/bidrank/delete",method = RequestMethod.POST)
    public String delete(@RequestParam(name = "id")String id,Model model){
        manageService.deleteBidRank(id);
        return "redirect:/root/bidrank";
    }
}
