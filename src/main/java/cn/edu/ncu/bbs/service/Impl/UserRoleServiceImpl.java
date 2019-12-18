package cn.edu.ncu.bbs.service.Impl;

import cn.edu.ncu.bbs.domain.UserRole;
import cn.edu.ncu.bbs.domain.UserRoleExample;
import cn.edu.ncu.bbs.mapper.UserRoleMapper;
import cn.edu.ncu.bbs.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class UserRoleServiceImpl implements UserRoleService {


    @Autowired
    private UserRoleMapper userRoleMapper;

    public List<UserRole> getPowerByUserId(Long userId){
        UserRoleExample userRoleExample=new UserRoleExample();
        UserRoleExample.Criteria criteria =userRoleExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return   userRoleMapper.selectByExample(userRoleExample);
    }

    public void iniPower(Long userId){//注册用户初始化权限
        UserRole userRole = new UserRole();
        userRole.setRoleId((long) 1);
        userRole.setUserId(userId);
        userRoleMapper.insert(userRole);
    }


    public void downPower(Long userId){//降低权限
        if(getHighPower(userId)==2) {
            UserRoleExample userRoleExample=new UserRoleExample();
            UserRoleExample.Criteria criteria =userRoleExample.createCriteria();
            criteria.andUserIdEqualTo(userId).andRoleIdEqualTo((long)2);
            userRoleMapper.deleteByExample(userRoleExample);
        }
    }


    public void upPower(Long userId){//提高权限
        if(getHighPower(userId)==1){
            UserRole userRole = new UserRole();
            userRole.setRoleId((long) 2);
            userRole.setUserId(userId);
            userRoleMapper.insert(userRole);
        }
    }






    public Long getHighPower(Long userId) {//获得用户拥有的最高权限
        List<UserRole> userRoleList = getPowerByUserId(userId);
        List<Long> powers = new ArrayList<>();
        for (int i = 0; i < userRoleList.size(); i++) {
            powers.add(userRoleList.get(i).getRoleId());
        }
        Long highPoweer = Collections.max(powers);
        return highPoweer;
    }
}