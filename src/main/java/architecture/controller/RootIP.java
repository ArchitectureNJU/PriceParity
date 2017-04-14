package architecture.controller;

import architecture.bean.BidRankBean;
import architecture.bean.BlockIpBean;
import architecture.bean.BlockRecordBean;
import architecture.bean.BlockWordBean;
import architecture.entity.BlockIpEntity;
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
 * Created by cxworks on 17-4-12.
 */
@Controller
public class RootIP {
    @Autowired
    ManageService manageService;

    @RequestMapping(value = "/root/ip",method = RequestMethod.GET)
    public String getBlockIP(
            @RequestParam(name = "offset",defaultValue = "0",required = false)int offset,
            @RequestParam(name = "size",defaultValue = "10",required = false)int size,
            Model model
    ){
        common(model, offset, size);
        return "intercept-manage";
    }

    private void common(Model model,int offset,int size){
        List<BlockIpBean> it=manageService.getBlockIP(offset,size);
        model.addAttribute("blockip",it);
    }

//    @RequestMapping(value = "/root/ip/update",method = RequestMethod.POST)
//    public String update(
//            @ModelAttribute(name = "BlockIpBean")BlockIpBean bean,
//            Model model){
//        manageService.save(bean);
//        return "redirect:/root/ip";
//    }
//
//    @RequestMapping(value = "/root/ip/update",method = RequestMethod.GET)
//    public String updatePage(@RequestParam String id) {
//        return "intercept-update";
//    }

    @RequestMapping(value = "/root/ip/add",method = RequestMethod.POST)
    public String add(
            @ModelAttribute(name = "BlockIpEntity")BlockIpEntity entity,
            Model model
    ){
        manageService.create(entity);
//        common(model,0,10);
        return "redirect:/root/ip";
    }

    @RequestMapping(value = "/root/ip/add",method = RequestMethod.GET)
    public String addPage() {
        return "intercept-add";
    }

    @RequestMapping(value = "/root/ip/delete",method = RequestMethod.POST)
    public String delete(@RequestParam(name = "id")String id,Model model){
        manageService.deleteIP(id);
//        common(model,0,10);
        return "redirect:/root/ip";
    }




}
