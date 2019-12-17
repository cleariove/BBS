package cn.edu.ncu.bbs.controller;

import cn.edu.ncu.bbs.domain.User;
import cn.edu.ncu.bbs.service.Impl.UserServiceImpl;
import cn.edu.ncu.bbs.until.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("")
    public void returnLogin(HttpServletResponse response) {
        try {
            response.sendRedirect("/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/register")
    public String showRegister() { return "register"; }

    @RequestMapping("/main")
    public String showMain() { return "main"; }

    @RequestMapping("/showUserMes")
    public String showUserMes() { return "userMes"; }

    @RequestMapping("/showUserMesUpdate")
    public String showUserMesUpdate() {
        return "userMesChange";
    }

    @RequestMapping("/showUserManage")
    public String showManageUser() {
        return "userManage";
    }

 @RequestMapping(value = "/register",method = RequestMethod.POST)
 public void register(User user, HttpServletResponse response){
     userService.userRegister(user);
     try {
         response.sendRedirect("/login");
     } catch (IOException e) {
         e.printStackTrace();
     }
 }

    @RequestMapping(value = "/change",method = RequestMethod.POST)
    public String changeUser(@RequestParam("file") MultipartFile file,User user){
//        String path = FileUtil.uploadFile(file, "user" + user.getUserId());
        userService.userChange(user,file);
        return "userManage";
    }


    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public String deleteUserByUserId(@RequestParam("userId")Integer userId,Model model){
        userService.deleteUser(userId);
        List<User> users=userService.selectALLExceptSelf(userId);
        model.addAttribute("usersExceptSelf", users);
        return "adminManageUser";
    }


    @RequestMapping(value = "/changeIntegral",method = RequestMethod.POST)
    @ResponseBody
    public User  changeIntegralByUserId(@RequestParam("type")String type,@RequestParam("userId")Integer userId,
                                        @RequestParam("changeIntegral")Integer changeIntegral){


      return   userService.changeIntegral(type,userId,changeIntegral);
    }


    @RequestMapping(value = "/showAdminManageUser",method = RequestMethod.GET)
    public String showAllUser(@RequestParam("userId")Integer userId, Model model){
        List<User> users=userService.selectALLExceptSelf(userId);
        model.addAttribute("usersExceptSelf", users);
        return  "adminManageUser";
    }

}

