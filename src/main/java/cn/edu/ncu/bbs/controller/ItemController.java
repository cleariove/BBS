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
@RequestMapping(value = "/item")
public class ItemController
{
    @Autowired
    private ItemServiceImpl itemService;

    @Autowired
    private SubItemServiceImpl subItemService;

    @RequestMapping("/show")
    public String showItem(Model model)
    {
        List<Item> items = itemService.findAll();
        model.addAttribute("items",items);
        List<SubItem> subItems = subItemService.selectAll();
        model.addAttribute("showSubItemInItem",subItems);
        return "item";
    }

    @RequestMapping("/manage")
    public String manageItem()
    {
        return "createItem";
    }

    @ResponseBody
    @RequestMapping(value = "/manage/delete")
    public String delete(@RequestParam("itemId")String id)
    {
        itemService.deleteByPrimaryKey(id);
        return "/item/show";
    }

    @ResponseBody
    @RequestMapping(value = "/manage/insert",method = RequestMethod.POST)
    public String insert(@RequestParam("itemName")String name,
                             @RequestParam("itemDescription")String description,
                             @RequestParam(value = "manager",defaultValue = "") String manager)
    {
        itemService.insert(name, description, manager);
        return "/item/show";
    }

    @ResponseBody
    @RequestMapping(value = "/manage/upload",method = RequestMethod.POST)
    public String insertIcon(@RequestParam("itemId")String id,
                             @RequestParam("itemFile")MultipartFile file)
    {
//        String path = FileUtil.uploadFile(file,"item"+id);
        String base64 = FileUtil.ChangeToBase64(file);
        itemService.setIconPath(id, base64);
        return "/item/manage?itemId="+id;
    }

    @ResponseBody
    @RequestMapping(value = "/manage/update",method = RequestMethod.POST)
    public String update(@RequestParam("itemId")String id,
                         @RequestParam(value = "itemName",defaultValue = "")String name,
                         @RequestParam(value = "itemDescription",defaultValue = "")String description,
                         @RequestParam(value = "manager",defaultValue = "") String manager)
    {
        itemService.updateByPrimaryKey(id, name, description, manager);
        return "/subItem/show?itemId="+id;
    }
}
