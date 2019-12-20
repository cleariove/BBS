package cn.edu.ncu.bbs.service.Impl;

import cn.edu.ncu.bbs.domain.Permission;
import cn.edu.ncu.bbs.domain.PermissionExample;
import cn.edu.ncu.bbs.mapper.PermissionMapper;
import cn.edu.ncu.bbs.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService
{
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findAll()
    {
        PermissionExample permissionExample = new PermissionExample();
        return permissionMapper.selectByExample(permissionExample);
    }
}
