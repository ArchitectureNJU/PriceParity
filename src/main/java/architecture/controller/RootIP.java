package architecture.controller;

import architecture.bean.BidRankBean;
import architecture.bean.BlockIpBean;
import architecture.bean.BlockWordBean;
import architecture.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;

/**
 * Created by cxworks on 17-4-12.
 */
@Controller("/root")
public class RootIP {
    @Autowired
    ManageService manageService;




    public String getBlockIP(
            @RequestParam(name = "offset",defaultValue = "0")int offset,
            @RequestParam(name = "size",defaultValue = "10")int size,
            Model model
    ){
        Iterator<BlockIpBean> it=manageService.getBlockIP(offset,size);
        model.addAttribute("blockIp",it);
        return "";
    }


    public String getBlockWord(
            @RequestParam(name = "offset",defaultValue = "0")int offset,
            @RequestParam(name = "size",defaultValue = "10")int size,
            Model model
    ){
        Iterator<BlockWordBean> it=manageService.getBlockWord(offset,size);
        model.addAttribute("blockWord",it);
        return "";
    }

    public String getBidRank(
            @RequestParam(name = "offset",defaultValue = "0")int offset,
            @RequestParam(name = "size",defaultValue = "10")int size,
            Model model
    ){
        Iterator<BidRankBean> it=manageService.getBidRank(offset,size);
        model.addAttribute("bidRank",it);
        return "";
    }

    public String getBlockRecord(
            @RequestParam(name = "offset",defaultValue = "0")int offset,
            @RequestParam(name = "size",defaultValue = "10")int size,
            Model model
    ){
        Iterator<BlockWordBean> it=manageService.getBlockWord(offset,size);
        model.addAttribute("blockWord",it);
        return "";
    }
}
