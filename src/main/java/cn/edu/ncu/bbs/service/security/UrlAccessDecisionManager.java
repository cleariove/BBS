package cn.edu.ncu.bbs.service.security;


import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class UrlAccessDecisionManager implements AccessDecisionManager
{

    /**
     *
     * @param authentication 当前用户信息，和当前用户的拥有权限信息，
     *                       来自于实现UserDetailService的MyUserDetailService
     * @param o 即FilterInvocation对象，可以获取httpServletRequest请求对象
     * @param collection  本次访问所需要的权限来自实现
     *                    FilterInvocationSecurityMetadataSource接口
     *                    的UrlPathFilterInvocationSecurityMetadataSource
     */
    //只要用户角色与url所需角色有交集即可访问
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException
    {
        for(ConfigAttribute cfgA : collection)
        {
            String needRole = cfgA.getAttribute();
            //如果当前页面只需要登录就能访问
            if("ROLE_LOGIN".equals(needRole))
            {
                //这里判断当前返回的用户信息是否表明登录了
                // 在MyUserDetailService中未登录或登录失败返回AnonymousAuthenticationToken对象
                if(authentication instanceof AnonymousAuthenticationToken)
                {
                    throw new BadCredentialsException("请登录后在进行访问");
                }
                //如果登录就直接放行
                else
                {
                    break;
                }

            }
            //这里遍历用户的角色
            for (GrantedAuthority grantedAuthority:authentication.getAuthorities())
            {
                //用户角色如果与url所需角色有交集，则放行
                if(grantedAuthority.getAuthority().equals(needRole))
                {
                    return;
                }
            }
        }
        //遍历完url所需所有角色，与用户所拥有角色无交集
        throw new AccessDeniedException("权限不足!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute)
    {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass)
    {
        return true;
    }
}
