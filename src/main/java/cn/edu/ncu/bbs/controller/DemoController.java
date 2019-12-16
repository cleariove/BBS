 package cn.edu.ncu.bbs.controller;

import cn.edu.ncu.bbs.domain.User;
import cn.edu.ncu.bbs.domain.security.MyToken;
import cn.edu.ncu.bbs.service.security.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


 @Controller
public class DemoController
{
    @Autowired
    private MyUserDetailService myUserDetailService;

    @RequestMapping("/index")
    public String index()
    {
        SecurityContext context= SecurityContextHolder.getContext();
        System.out.println(context);
        MyToken auth=(MyToken)SecurityContextHolder.getContext().getAuthentication();

        System.out.println(auth.getIntegral());




        return "index";
    }
}