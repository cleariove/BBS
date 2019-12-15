package cn.edu.ncu.bbs.controller;

import cn.edu.ncu.bbs.domain.Item;
import cn.edu.ncu.bbs.domain.SubItem;
import cn.edu.ncu.bbs.service.Impl.ItemServiceImpl;
import cn.edu.ncu.bbs.service.Impl.SubItemServiceImpl;
import cn.edu.ncu.bbs.until.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping(value = "/subItem")
public class SubItemController
{
    @Autowired
    private SubItemServiceImpl subItemService;

    @Autowired
    private ItemServiceImpl itemService;

    @RequestMapping("/show")
    public String showSubItemByItemId(Model model, @RequestParam("itemId")String id)
    {
        List<SubItem> subItems = subItemService.selectByExample(id);
        model.addAttribute("allSubItem",subItems);
        return "subItem";
    }

    @RequestMapping("/showAll")
    public String showAll(Model model)
    {
        List<SubItem> subItems = subItemService.selectAll();
        model.addAttribute("allSubItem",subItems);
        return "subItem";
    }

    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestParam("subItemFile") MultipartFile file,
                         @RequestParam("subItemId") String id)
    {
        String path = FileUtil.uploadFile(file,"subItem"+id);
        subItemService.setIconPath(id,path);
        return "/subItem/manage?subItemId="+id;
    }

    @RequestMapping("/manage")
    public String manageSubItem(Model model,@RequestParam("subItemId")String subItemId)
    {
        SubItem subItem = null;
        if(!subItemId.equals("0"))
            subItem = subItemService.selectByPrimaryKey(subItemId);
        List<Item> items =  itemService.findAll();
        model.addAttribute("allItem",items);
        model.addAttribute("subItem",subItem);
        return "manageSubItem";
    }

    @ResponseBody
    @RequestMapping("/insert")
    public String insertSubItem(@RequestParam("subItemName")String name,
                                @RequestParam("subItemDescription")String description,
                                @RequestParam(value = "manager",defaultValue = "") String manager,
                                @RequestParam(value = "itemId",defaultValue = "")String itemId)
    {
        subItemService.insert(name, description, manager, itemId);
        return "/subItem/show?itemId="+itemId;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public String deleteSubItem(@RequestParam("subItemId")String id)
    {
        Integer itemId = subItemService.selectByPrimaryKey(id).getItemId();
        subItemService.delete(id);
        return "/subItem/show?itemId="+itemId;
    }

    @ResponseBody
    @RequestMapping("/update")
    public String update(@RequestParam("subItemId")String id,
                       @RequestParam("subItemName")String name,
                       @RequestParam("subItemDescription")String description,
                       @RequestParam(value = "manager",defaultValue = "") String manager,
                       @RequestParam(value = "itemId",defaultValue = "")String itemId)
    {
        subItemService.update(id, name, description, manager, itemId);
        return "/subItem/manage?subItemId="+id;
    }

    @ResponseBody
    @RequestMapping("/getItem")
    public String getItem(Model model,@RequestParam("itemId")String id)
    {
        model.addAttribute("belongItem",itemService.selectByPrimaryKey(id));
        return null;
    }
}
