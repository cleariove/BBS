package cn.edu.ncu.bbs.service.Impl;


import cn.edu.ncu.bbs.domain.User;
import cn.edu.ncu.bbs.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl
{
    @Autowired
    private UserMapper userMapper;

    public User findById(String id)
    {
        return userMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

//    public User findByUsername(String)
}
