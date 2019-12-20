package cn.edu.ncu.bbs.service;

import cn.edu.ncu.bbs.domain.Role;

import java.util.List;

public interface RoleService
{
    //查找url对应的role
    public List<Role> findRoleByPermissionId(Long permissionId);
    //查找user拥有的role
    public List<Role> findRoleByUserId(Integer userId);
}
