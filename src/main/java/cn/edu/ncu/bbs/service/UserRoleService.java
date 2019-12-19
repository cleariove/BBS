package cn.edu.ncu.bbs.service;

import cn.edu.ncu.bbs.domain.User;

import java.util.List;

public interface UserRoleService {
    void iniPower(Long userId);//用户注册时初始化权限
    void downPower(Long userId);//降低权限
    void upPower(Long userId);//提高权限
    Long getHighPower(Long userId);//获得用户拥有的最高权限
    List<User> findAllManage();//获得manage用户(权限为2)
}
