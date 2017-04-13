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
@Controller("/word")
public class RootWord {

    @Autowired
    ManageService manageService;



    @RequestMapping(value = "",method = RequestMethod.GET)
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
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(
            @ModelAttribute(name = "BlockWordBean")BlockWordBean bean,
            Model model){
        manageService.save(bean);
        common(model,0,10);
        return "maskword-manage";
    }
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(
            @ModelAttribute(name = "BlockWordBean")BlockWordBean bean,
            Model model
    ){
        manageService.save(bean);
        common(model,0,10);
        return "maskword-manage";
    }
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public String delete(@RequestParam(name = "id")String id,Model model){
                manageService.deleteWord(id);
                common(model,0,10);
                return "maskword-manage";
    }
}