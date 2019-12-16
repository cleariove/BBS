package cn.edu.ncu.bbs.service.security;

import cn.edu.ncu.bbs.domain.Role;
import cn.edu.ncu.bbs.domain.User;
import cn.edu.ncu.bbs.service.Impl.RoleServiceImpl;
import cn.edu.ncu.bbs.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//这个类用于从数据库取出并保存用户信息的
@Component
public class MyUserDetailService implements UserDetailsService
{
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private MyPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        User user = userService.findById(s);
        if(user == null)
        {
            System.out.println("用户不存在");
            throw new UsernameNotFoundException("用户不存在");
        }
        else
        {
            String pwd = passwordEncoder.encode(user.getPassword());
            List<Role> roles = roleService.findRoleByUserId(user.getUserId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for(Role r:roles)
            {
                if(r != null && r.getName() != null)
                {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(r.getName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            System.out.println("密码"+pwd);
            user.setAuthorities(grantedAuthorities);
            return user;
//            return new org.springframework.security.core.userdetails.User(String.valueOf(user.getUserId()),pwd,grantedAuthorities);
        }
    }
}
