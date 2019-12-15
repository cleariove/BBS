package cn.edu.ncu.bbs.service.Impl;

import cn.edu.ncu.bbs.domain.Permission;
import cn.edu.ncu.bbs.domain.PermissionExample;
import cn.edu.ncu.bbs.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl
{
    @Autowired
    private PermissionMapper permissionMapper;

    public List<Permission> findAll()
    {
        PermissionExample permissionExample = new PermissionExample();
        return permissionMapper.selectByExample(permissionExample);
    }

    public List<Permission> findByAdminUserId(int userId)
    {
        return permissionMapper.findByAdminUserId(userId);
    }
}
