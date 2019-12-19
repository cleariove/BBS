package cn.edu.ncu.bbs.controller;

import cn.edu.ncu.bbs.domain.User;
import cn.edu.ncu.bbs.domain.UserRole;
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

    @RequestMapping(value = "/updateUserRole",method = RequestMethod.GET)
    public String  changePower(@RequestParam("type") String type, @RequestParam("opUserId") Integer opUserId, @RequestParam("userId") Long userId,Model model){
        if(type.equals("up")){
            userRoleService.upPower(userId);
        }
        if(type.equals("down")){
            userRoleService.downPower(userId);
        }
        List<User> users=userService.selectALLExceptSelf(opUserId);
        model.addAttribute("usersExceptSelf", users);
        return "adminManageUser";
    }

    @RequestMapping(value = "/getHighRole",method = RequestMethod.GET)
    @ResponseBody
    public Long  getHighPower(@RequestParam("userId") Long userId){
        return userRoleService.getHighPower(userId);
    }


    @RequestMapping(value = "/findAllManage",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAllManage(){
    return   userRoleService.findAllManage();
    }
}
