package cn.edu.ncu.bbs.service.Impl;


import cn.edu.ncu.bbs.domain.Role;
import cn.edu.ncu.bbs.mapper.RoleMapper;
import cn.edu.ncu.bbs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService
{
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRoleByUserId(Integer userId)
    {
        return roleMapper.findRoleByUserId(userId);
    }

    @Override
    public List<Role> findRoleByPermissionId(Long permissionId)
    {
        return roleMapper.findRoleByPermissionId(permissionId);
    }
}
