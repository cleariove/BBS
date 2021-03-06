package cn.edu.ncu.bbs.controller;

import cn.edu.ncu.bbs.domain.Item;
import cn.edu.ncu.bbs.domain.User;
import cn.edu.ncu.bbs.domain.UserRole;
import cn.edu.ncu.bbs.service.Impl.ItemServiceImpl;
import cn.edu.ncu.bbs.service.Impl.SubItemServiceImpl;
import cn.edu.ncu.bbs.service.Impl.UserRoleServiceImpl;
import cn.edu.ncu.bbs.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/userRole")
public class UserRoleController {
    @Autowired
    private UserRoleServiceImpl userRoleService;
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ItemServiceImpl itemService;

    @RequestMapping(value = "/updateUserRole",method = RequestMethod.GET)
    public String  changePower(@RequestParam("type") String type, @RequestParam("opUserId") Integer opUserId, @RequestParam("userId") Long userId,Model model){
        if(type.equals("up")){
            userRoleService.upPower(userId);
        }
        if(type.equals("down")){
            userRoleService.downPower(userId);
            itemService.removePermissionByUserId(Math.toIntExact(userId));
        }
        List<User> users=userService.selectALLExceptSelf(opUserId);
        model.addAttribute("usersExceptSelf", users);
        return "adminManageUser";
    }

    @RequestMapping(value = "/getHighRole",method = RequestMethod.POST)
    @ResponseBody
    public String getHighPower(@RequestParam("userId") Long userId){
        if(userRoleService.getHighPower(userId)==1)
            return "用户";
        else
            return "管理员";
    }


    @RequestMapping(value = "/findAllManage",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAllManage(){
    return   userRoleService.findAllManage();
    }
}
