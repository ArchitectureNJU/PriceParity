package architecture.controller;

import architecture.bean.BlockWordBean;
import architecture.bean.SynonymBean;
import architecture.entity.SynonymEntity;
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
public class RootSynonym {


    @Autowired
    ManageService manageService;

    private void common(Model model,int offset,int size){
        List<SynonymBean> it=manageService.getSynonym(offset,size);
        model.addAttribute("synList",it);
    }

    @RequestMapping(value = "/root/synonym",method = RequestMethod.GET)
    public String getSynonym(
            @RequestParam(name = "offset",defaultValue = "-1",required = false)int offset,
            @RequestParam(name = "size",defaultValue = "-1",required = false)int size,
            Model model
    ){
        common(model, offset, size);
        return "syn-manage";
    }

    @RequestMapping(value = "/root/synonym/update",method = RequestMethod.POST)
    public String update(
            @RequestParam(name = "id")String id,
            @RequestParam(name = "syn")String syn,
            Model model){
                SynonymEntity entity=new SynonymEntity(syn);
                SynonymBean bean=new SynonymBean(id,entity);
        manageService.save(bean);
//        common(model,0,10);
        return "redirect:/root/synonym";
    }

    @RequestMapping(value = "/root/synonym/update",method = RequestMethod.GET)
    public String updatePage(@RequestParam String id,Model model){
        model.addAttribute("syn",manageService.findSynonymByid(id));
        return "syn-update";
    }

    @RequestMapping(value = "/root/synonym/add",method = RequestMethod.POST)
    public String add(
            @RequestParam(name = "syn")String blockWord,
            Model model
    ){
        manageService.create(new SynonymEntity(blockWord));
        return "redirect:/root/synonym";
    }

    @RequestMapping(value = "/root/synonym/add",method = RequestMethod.GET)
    public String addPage(){
        return "syn-add";
    }

    @RequestMapping(value = "/root/synonym/delete",method = RequestMethod.POST)
    public String delete(@RequestParam(name = "id")String id,Model model){
        manageService.deleteSynonym(id);
//        common(model,0,10);
        return "redirect:/root/synonym";
    }
}
