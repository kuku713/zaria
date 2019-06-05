package com.kuku.zaria.service.impl;

import com.kuku.zaria.bean.dto.BaseDTO;
import com.kuku.zaria.bean.dto.UserDTO;
import com.kuku.zaria.bean.dto.UserMenuDTO;
import com.kuku.zaria.bean.dto.UserRoleDTO;
import com.kuku.zaria.common.UserConsts;
import com.kuku.zaria.domain.entity.UserLogin;
import com.kuku.zaria.domain.mapper.UserMapper;
import com.kuku.zaria.domain.mapper.UserLoginMapper;
import com.kuku.zaria.domain.mapper.UserRoleMapper;
import com.kuku.zaria.service.UserService;
import com.kuku.zaria.util.DTOUtils;
import com.kuku.zaria.util.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.Date;

/**
 * @author kuku713
 * @description
 * @date 2019-05-13
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private UserLoginMapper userLoginMapper;

    @Override
    public UserDTO getByUserId(String userId) {
        return DTOUtils.genSuccessUserDTO(userMapper.getByUserId(userId));
    }

    @Override
    public UserDTO getByLoginName(String loginName) {
        UserDTO userDTO = DTOUtils.genEmptyUserDTO();
        userDTO.setLoginName(loginName);
        if (ValidatorUtils.isMobile(loginName)) {
            userDTO.setUser(userMapper.getByMobile(loginName));
            userDTO.setLoginType(UserConsts.LOGIN_TYPE_MOBILE);
        } else if (ValidatorUtils.isEmail(loginName)) {
            userDTO.setUser(userMapper.getByEmail(loginName));
            userDTO.setLoginType(UserConsts.LOGIN_TYPE_EMAIL);
        } else {
            userDTO.setUser(userMapper.getByUserId(loginName));
            userDTO.setLoginType(UserConsts.LOGIN_TYPE_USER_ID);
        }
        return userDTO;
    }

    @Override
    public UserRoleDTO listUserRolesByUserId(String userId) {
        return DTOUtils.genSuccessUserRoleDTO(userRoleMapper.listRolesByUserId(userId));
    }

    @Override
    public UserMenuDTO listUserMenusByUserId(String userId) {
        return DTOUtils.genSuccessUserMenuDTO(userRoleMapper.listMenusByUserId(userId));
    }

    @Override
    public void saveUserLogin(UserDTO userDTO, String remark) {
        if (null == userDTO.getUser()) {
            return;
        }
        UserLogin login = new UserLogin();
        login.setUserId(userDTO.getUser().getUserId());
        login.setLoginIp(userDTO.getLoginIp());
        login.setLoginName(userDTO.getLoginName());
        login.setLoginType(userDTO.getLoginType());
        login.setLoginTime(Date.from(Instant.now()));
        login.setRemark(remark);
        userLoginMapper.insert(login);
    }
}
