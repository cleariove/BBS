 package cn.edu.ncu.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController
{
    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }
}