package cn.edu.ncu.bbs.controller;

import cn.edu.ncu.bbs.domain.Item;
import cn.edu.ncu.bbs.domain.SubItem;
import cn.edu.ncu.bbs.domain.Topic;
import cn.edu.ncu.bbs.domain.User;
import cn.edu.ncu.bbs.domain.security.MyToken;
import cn.edu.ncu.bbs.service.Impl.ItemServiceImpl;
import cn.edu.ncu.bbs.service.Impl.SubItemServiceImpl;
import cn.edu.ncu.bbs.service.Impl.TopicServiceImpl;
import cn.edu.ncu.bbs.service.Impl.UserRoleServiceImpl;
import cn.edu.ncu.bbs.until.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private UserRoleServiceImpl userRoleService;

    @Autowired
    private TopicServiceImpl topicService;

    @RequestMapping("/show")
    public String showSubItemByItemId(Model model, @RequestParam("itemId")String id)
    {
        List<SubItem> subItems = subItemService.selectByExample(id);
        Item item = itemService.selectByPrimaryKey(id);
        int count = subItemService.countByItemId(id);
        MyToken myToken = null;
        if(SecurityContextHolder.getContext().getAuthentication() instanceof MyToken)
            myToken = (MyToken) SecurityContextHolder.getContext().getAuthentication();
        if(myToken != null)
        {
            if(myToken.containsRole("ROLE_MANAGER") || myToken.getUserId().equals(item.getManager()))
            {
                List<User> users = userRoleService.findAllManage();
                model.addAttribute("managers",users);
            }
        }
        List<Topic> topics = topicService.findByItemId(Integer.valueOf(id));
        model.addAttribute("topics",topics);
        model.addAttribute("count",count);
        model.addAttribute("selectItem",item);
        model.addAttribute("allSubItem",subItems);
        return "subItem";
    }

    @RequestMapping("/showAll")
    public String showAllSubItem(Model model)
    {
        List<SubItem> subItems = subItemService.selectAll();
        List<Topic> topics = topicService.findAllTopic();
        model.addAttribute("topics",topics);
        model.addAttribute("subItems",subItems);
        return "allSubItem";
    }

    @ResponseBody
    @RequestMapping(value = "/manage/upload",method = RequestMethod.POST)
    public String upload(@RequestParam("subItemFile") MultipartFile file,
                         @RequestParam("subItemId") String id)
    {
//        String path = FileUtil.uploadFile(file,"subItem"+id);
        String path = FileUtil.ChangeToBase64(file);
        subItemService.setIconPath(id,path);
        return "/subItem/manage?subItemId="+id;
    }

    @RequestMapping("/manage")
    public String manageSubItem(Model model,@RequestParam("itemId")String itemId)
    {
        Item item = itemService.selectByPrimaryKey(itemId);
        List<Item> items = itemService.findAll();
        model.addAttribute("oneItem",item);
        model.addAttribute("items",items);
        return "createSubItem";
    }

    @ResponseBody
    @RequestMapping("/manage/insert")
    public String insertSubItem(@RequestParam("subItemName")String name,
                                @RequestParam("subItemDescription")String description,
                                @RequestParam(value = "manager",defaultValue = "") String manager,
                                @RequestParam(value = "itemId",defaultValue = "")String itemId)
    {
        subItemService.insert(name, description, manager, itemId);
        return "/subItem/show?itemId="+itemId;
    }

    @ResponseBody
    @RequestMapping("/manage/delete")
    public String deleteSubItem(@RequestParam("subItemId")String id)
    {
        Integer itemId = subItemService.selectByPrimaryKey(id).getItemId();
        subItemService.delete(id);
        return "/subItem/show?itemId="+itemId;
    }

    @ResponseBody
    @RequestMapping("/manage/update")
    public String update(@RequestParam("subItemId")String id,
                       @RequestParam(value = "subItemName",defaultValue = "")String name,
                       @RequestParam(value = "subItemDescription",defaultValue = "")String description,
                       @RequestParam(value = "manager",defaultValue = "") String manager,
                       @RequestParam(value = "itemId",defaultValue = "")String itemId)
    {
        subItemService.update(id, name, description, manager, itemId);
        return "/subItem/show?itemId="+itemId;
    }
}
