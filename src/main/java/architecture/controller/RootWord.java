package architecture.controller;

import architecture.bean.BlockWordBean;
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
public class RootWord {

    @Autowired
    ManageService manageService;



    @RequestMapping(value = "/root/word",method = RequestMethod.GET)
    public String getBlockWord(
            @RequestParam(name = "offset",defaultValue = "0",required = false)int offset,
            @RequestParam(name = "size",defaultValue = "10",required = false)int size,
            Model model
    ){
        common(model,offset,size);
        return "maskword-manage";
    }

    private void common(Model model,int offset,int size){
        List<BlockWordBean> it=manageService.getBlockWord(offset,size);
        model.addAttribute("maskword",it);
    }

    @RequestMapping(value = "/root/word/add",method = RequestMethod.GET)
    public String addPage() {
        return "maskword-add";
    }

    @RequestMapping(value = "/root/word/add",method = RequestMethod.POST)
    public String add(
            @ModelAttribute(name = "BlockWordBean")BlockWordBean bean,
            Model model
    ){
        manageService.save(bean);
        return "redirect:/root/word";
    }
    @RequestMapping(value = "/root/word/delete",method = RequestMethod.POST)
    public String delete(@RequestParam(name = "id")String id,Model model){
        manageService.deleteWord(id);
        return "redirect:/root/word";
    }
}
