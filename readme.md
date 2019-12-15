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
**在service层中**  
1.MyUserDetailService实现UserDetailsService，该类从数据库中
取出取出一条用户记录,找到该用户拥有的所有角色，返回org.
springframework.security.core.userdetails.User对象，保存了用户名，密码，
拥有的角色。<br>
2.LoginAuthenticationProvider实现AuthenticationProvider，该类依赖第一个类
该类获得前端传来的id和密码，与第一个类返回的对象进行比较，成功则返回一个
UsernamePasswordAuthenticationToken对象，该对象保存了登录用户的用户名，密码，
角色。如果失败就返回一个AnonymousAuthenticationToken对象，这个对象表明用户未登录
该类还可以设置验证码等进行登录
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
    