package cn.edu.ncu.bbs.service.security;


import cn.edu.ncu.bbs.domain.Permission;
import cn.edu.ncu.bbs.domain.Role;
import cn.edu.ncu.bbs.service.Impl.PermissionServiceImpl;
import cn.edu.ncu.bbs.service.Impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.*;


@Component
public class UrlPathFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource
{
    @Autowired
    private PermissionServiceImpl permissionService;

    @Autowired
    private RoleServiceImpl roleService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException
    {
        //下两行代码获得用户请求的url
        FilterInvocation filterInvocation = (FilterInvocation) o;
        String requestUrl = filterInvocation.getRequestUrl();
        //这里取出了数据库中所有的url
        List<Permission> permissions = permissionService.findAll();
        //这是一个url比较类
        AntPathMatcher matcher = new AntPathMatcher();
        for(Permission p:permissions)
        {
            //从数据库中获取与用户请求一致的url
            if(matcher.match(p.getUrl(),requestUrl))
            {
                //得到可以访问该url的所有角色
                List<Role> roles = roleService.findRoleByPermissionId(p.getId());
                if(roles.size() != 0)
                {
                    int size = roles.size();
                    //将这些角色的name取出保存
                    String[] needRole = new String[size];
                    for(int i = 0;i < size;i++)
                    {
                        needRole[i] = roles.get(i).getName();
                    }
                    //返回用户请求的url所需的角色名
                    return SecurityConfig.createList(needRole);
                }
            }
        }
        //到这一步表明数据库资源表不包括该url，那么就默认设置该url任何情况下都可访问
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes()
    {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass)
    {
        return true;
    }
}
