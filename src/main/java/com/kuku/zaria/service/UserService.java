package com.kuku.zaria.service;

import com.kuku.zaria.bean.dto.UserDTO;

/**
 * @author kuku713
 * @description
 * @date 2019-05-13
 */
public interface UserService {

    /**
     * 根据userId查询用户信息
     * @param userId
     * @return
     */
    UserDTO getByUserId(String userId);

    /**
     * 根据登录名查询用户信息
     * @param loginName
     * @return
     */
    UserDTO getByLoginName(String loginName);

    /**
     * 记录用户登录信息
     * @param userDTO
     * @param remark
     * @return
     */
    void saveUserLogin(UserDTO userDTO, String remark);
}
