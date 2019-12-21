package cn.edu.ncu.bbs.controller;

import cn.edu.ncu.bbs.domain.User;
import cn.edu.ncu.bbs.service.Impl.ItemServiceImpl;
import cn.edu.ncu.bbs.service.Impl.SubItemServiceImpl;
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

    @Autowired
    private ItemServiceImpl itemService;

    @Autowired
    private SubItemServiceImpl subItemService;

    @RequestMapping("")
    public void returnLogin(HttpServletResponse response) {
        try {
            response.sendRedirect("/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/register")
    public String showRegister() { return "signUp"; }

    @RequestMapping("/showUserMesUpdate")
    public String showUserMesUpdate() {
        return "myCenter";
    }


     @RequestMapping(value = "/register",method = RequestMethod.POST)
     public String register(User user, Model model){
         userService.userRegister(user);
         model.addAttribute("userId", user.getUserId());
         return "showId";
     }

     @ResponseBody
     @RequestMapping(value = "/upload",method = RequestMethod.POST)
     public String upload(@RequestParam("userId")String userId,@RequestParam("userFile") MultipartFile file)
     {
         String base64 = FileUtil.ChangeToBase64(file);// its maximum permitted size of 1048576 bytes.
         User user=new User();
         user.setUserId(Integer.valueOf( userId));
         user.setUserIcon(base64);
         userService.userChange(user);
         return null;
     }

    @RequestMapping(value = "/change",method = RequestMethod.POST)
    public String changeUser(User user){
//        String path = FileUtil.uploadFile(file, "user" + user.getUserId());
        userService.userChange(user);

        return "myCenter";
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public String deleteUserByUserId(@RequestParam("userId")Integer userId,@RequestParam("opUserId")Integer opUserId,Model model){
        itemService.removePermissionByUserId(userId);
        subItemService.removePermissionByUserId(userId);
        userService.deleteUser(userId);
        List<User> users=userService.selectALLExceptSelf(opUserId);
        model.addAttribute("usersExceptSelf", users);
        return "adminManageUser";
    }

    @RequestMapping(value = "/showAdminManageUser",method = RequestMethod.GET)
    public String showAllUser(@RequestParam("userId")Integer userId, Model model){
        List<User> users=userService.selectALLExceptSelf(userId);
        model.addAttribute("usersExceptSelf", users);
        return  "adminManageUser";
    }

}

