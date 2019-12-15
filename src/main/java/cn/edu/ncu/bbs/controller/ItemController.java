package cn.edu.ncu.bbs.controller;

import cn.edu.ncu.bbs.domain.Item;
import cn.edu.ncu.bbs.service.Impl.ItemServiceImpl;
import cn.edu.ncu.bbs.until.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping(value = "/item")
public class ItemController
{
    @Autowired
    private ItemServiceImpl itemService;

    @RequestMapping("/show")
    public String showItem(Model model)
    {
        List<Item> items = itemService.findAll();
        model.addAttribute("items",items);
        return "item";
    }

    @RequestMapping("/manage")
    public String manageItem(Model model, @RequestParam("itemId") String itemId)
    {
        Item item = null;
        if(!itemId.equals("0"))
            item = itemService.selectByPrimaryKey(itemId);
        model.addAttribute("selectItem",item);
        return "manageItem";
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("itemId")String id)
    {
        itemService.deleteByPrimaryKey(id);
        return "/item/show";
    }

    @ResponseBody
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insert(@RequestParam("itemName")String name,
                             @RequestParam("itemDescription")String description,
                             @RequestParam(value = "manager",defaultValue = "") String manager)
    {
        itemService.insert(name, description, manager);
        return "/item/show";
    }

    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String insertIcon(@RequestParam("itemId")String id,
                             @RequestParam("file")MultipartFile file)
    {
        String path = FileUtil.uploadFile(file,"item"+id);
        itemService.updateItemPath(id, path);
        return "/item/manage?itemId="+id;
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestParam("itemId")String id,
                         @RequestParam("itemName")String name,
                         @RequestParam("itemDescription")String description,
                         @RequestParam(value = "manager",defaultValue = "") String manager)
    {
        itemService.updateByPrimaryKey(id, name, description, manager);
        return "/item/manage?itemId="+id;
    }
}