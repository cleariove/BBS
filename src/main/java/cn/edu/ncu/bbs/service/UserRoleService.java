package cn.edu.ncu.bbs.service;

public interface UserRoleService {
    void iniPower(Long userId);
    void downPower(Long userId);
    void upPower(Long userId);
    Long getHighPower(Long userId);
}
