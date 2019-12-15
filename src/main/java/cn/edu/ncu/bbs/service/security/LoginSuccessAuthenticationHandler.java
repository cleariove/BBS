package cn.edu.ncu.bbs.service.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginSuccessAuthenticationHandler implements AuthenticationSuccessHandler
{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException
    {
        response.setContentType("application/json;charset=utf-8");
        request.getRequestDispatcher("/index").forward(request,response);
        PrintWriter writer = response.getWriter();
        System.out.println("LoginSuccessAuthenticationHandler登录成功");
        writer.print("LoginSuccessAuthenticationHandler登录成功");
        writer.flush();
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException
    {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletRequest.getRequestDispatcher("/index").forward(httpServletRequest,httpServletResponse);
        PrintWriter writer = httpServletResponse.getWriter();
        System.out.println("LoginSuccessAuthenticationHandler登录成功");
        writer.print("LoginSuccessAuthenticationHandler登录成功");
        writer.flush();
    }

}
