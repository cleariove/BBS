package cn.edu.ncu.bbs.config;

import cn.edu.ncu.bbs.service.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    //用户id，用户密码，用户拥有的角色
    @Autowired
    private MyUserDetailService myUserDetailService;

    //处理登录成功后的页面
    @Autowired
    private LoginSuccessAuthenticationHandler successAuthenticationHandler;

    //处理登录失败后的页面
    @Autowired
    private LoginFailureAuthenticationHandler failureAuthenticationHandler;

    //处理权限不足的页面
    @Autowired
    private AuthenticationAccessDeniedHandler accessDeniedHandler;

    //查找访问url所需的角色
    @Autowired
    private UrlAccessDecisionManager decisionManager;

    //比较访问url所需的角色和用户拥有的角色
    @Autowired
    private UrlPathFilterInvocationSecurityMetadataSource urlPathFilterInvocationSecurityMetadataSource;

    //处理前端获得的数据
    @Autowired
    private LoginAuthenticationProvider loginAuthenticationProvider;

    @Autowired
    private MyPasswordEncoder passwordEncoder;

    //处理用户登录部分
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder);
        auth.authenticationProvider(loginAuthenticationProvider);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(  );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(decisionManager);
                        o.setSecurityMetadataSource(urlPathFilterInvocationSecurityMetadataSource);
                        return o;
                    }
                })

                .anyRequest()
                .authenticated()// 其他 url 需要身份认证

                .and()
                .formLogin()
                .successHandler(successAuthenticationHandler)
                .failureHandler(failureAuthenticationHandler)
                .permitAll()

                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)

                .and()
                .rememberMe()

                .and()
                .logout()
                .logoutUrl("/logout")

                .and()
                .httpBasic();

    }
}
