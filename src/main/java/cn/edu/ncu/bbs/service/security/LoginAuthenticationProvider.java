package cn.edu.ncu.bbs.service.security;

import cn.edu.ncu.bbs.domain.User;
import cn.edu.ncu.bbs.domain.security.MyToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Objects;



@Component
public class LoginAuthenticationProvider implements AuthenticationProvider
{
    @Autowired
    private MyUserDetailService myUserDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {

        //获取用户名
        String username = (String) authentication.getPrincipal();
        //获取密码
        String password = (String) authentication.getCredentials();
        //根据用户名通过userDetailService获取数据库中对应数据
        User user = (User) myUserDetailService.loadUserByUsername(username);
//        UserDetails userDetails = myUserDetailService.loadUserByUsername(username);
        String password1 = user.getPassword();
        if(!Objects.equals(password,password1))
        {
            System.out.println("用户名或密码不正确");
            throw new BadCredentialsException("用户名或密码不正确");
        }
        //这个返回对象标志着用户登录成功，分别保存用户名，密码，用户的权限
        MyToken myToken = new MyToken(username,password,user.getAuthorities());
        myToken.setName(user.getName());
        myToken.setGender(user.getGender());
        myToken.setAge(user.getAge());
        myToken.setUserIcon(user.getUserIcon());
        myToken.setIntegral(user.getIntegral());
        myToken.setJob(user.getJob());
        return myToken;
//        return new UsernamePasswordAuthenticationToken(username,password,userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass)
    {
        return true;
    }
}
