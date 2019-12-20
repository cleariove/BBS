package cn.edu.ncu.bbs.service.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler
{

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException
    {
        //设置响应码
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpServletRequest.getRequestDispatcher("/page/403").forward(httpServletRequest,httpServletResponse);
    }
}
