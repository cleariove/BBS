 package cn.edu.ncu.bbs.controller;

import cn.edu.ncu.bbs.domain.security.MyToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class DemoController
{
    @RequestMapping("/index")
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/item/show").forward(request,response);
    }

    @RequestMapping("")
    public void nullUrl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/item/show").forward(request,response);
    }
}