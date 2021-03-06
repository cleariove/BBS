# javaweb期末项目BBS论坛


# **spring security部分**
**需要5张表**  
1.user表，当前系统拥有的所有用户，保存用户信息比如年龄，名字  
2.role表，当前系统拥有的所有角色，比如管理员，超级管理员，普通用户  
3.permission表，系统的url，也即操作，比如删除，增加  
4.user-role表，保存用户拥有的角色  
5.role-permission表，保存每个url可以被哪些角色访问
比如某url可以被user和admin访问，那么该表中有两条url记录，对应权限分别为user和
admin。  
6.密码验证过程，拦截器拦截url请求，调用自身attemptAuthentication方法，该方法
从request请求中提取出authentication。具体是org.springframework.security.web
.context.SecurityContextPersistenceFilter拦截器捕获表单内容生成该authentication  
 拿到authentication对象后，过滤器会调用ProviderManager类的authenticate方法，并传入该对象
ProviderManager类的authenticate方法再调用自身的doAuthentication方法，
在doAuthentication方法中会调用类中的List providers集合中的各个
AuthenticationProvider接口实现类中的authenticate(Authentication authentication)
方法进行验证，由此可见，真正的验证逻辑是由各个各个AuthenticationProvider接口实现类来完成的,
DaoAuthenticationProvider类是默认情况下注入的一个AuthenticationProvider接口实现类
AuthenticationProvider接口通过UserDetailsService来获取用户信息  
**在service层中**  
1.MyUserDetailService实现UserDetailsService，该类从数据库中
取出取出一条用户记录,找到该用户拥有的所有角色，返回org.
springframework.security.core.userdetails.User对象，保存了用户名，密码，
拥有的角色。<br>
2.LoginAuthenticationProvider实现AuthenticationProvider，该类通过request请求
获取一个封装好了Authentication对象，Authentication对象中存有前台表单穿过来的用户名和密码
与第一个类返回的对象进行比较，成功则返回一个UsernamePasswordAuthenticationToken对象，
该对象保存了登录用户的用户名，密码，角色。如果失败就返回一个
AnonymousAuthenticationToken对象，这个对象表明用户未登录该类还可以设置验证码等进行登录
<br>
3.第一和第二个类是用来服务用户登录的，UrlPathFilterInvocationSecurityMetadataSource
实现FilterInvocationSecurityMetadataSource，该类用户判断用户请求的url需要的权限
是否与用户拥有的权限重合，getAttributes方法的Object参数包含了用户请求的request
信息，返回了这个url需要的角色，可以有多个，如果某个url没有存在资源表中，那么就默认
该url只需要登录即可访问。<br>
4.到这里已经获取了用户拥有角色，以及用户请求的url需要的角色。所以现在我们要比较
用户角色与url所需角色，通过实现AccessDecisionManager接口的UrlAccessDecisionManager
类来遍历url所需的角色，每次遍历中内层循环遍历用户拥有的角色。<br>
5.实现AccessDeniedHandler接口的AuthenticationAccessDeniedHandler用于处理
第四个类在权限不足后抛出的异常。
    