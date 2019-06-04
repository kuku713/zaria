package com.kuku.zaria.shiro;

import com.kuku.zaria.bean.dto.UserDTO;
import com.kuku.zaria.bean.dto.UserMenuDTO;
import com.kuku.zaria.bean.dto.UserRoleDTO;
import com.kuku.zaria.common.UserStatusEnum;
import com.kuku.zaria.domain.entity.UserMenu;
import com.kuku.zaria.domain.entity.UserRole;
import com.kuku.zaria.exception.CustomShiroException;
import com.kuku.zaria.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

/**
 * @author luzh21574
 * @description
 * @date 2019-05-19
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 角色与菜单权限添加
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 用户id
        String userId = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthInfo = new SimpleAuthorizationInfo();
        if (StringUtils.isNotBlank(userId)) {
            // 用户所有角色
            UserRoleDTO userRoleDTO = userService.listUserRolesByUserId(userId);
            simpleAuthInfo.addRoles(userRoleDTO.getUserRoleList().stream().map(UserRole::getRoleCode).collect(Collectors.toList()));
            // 用户所有权限（菜单URL）
            UserMenuDTO userMenuDTO = userService.listUserMenusByUserId(userId);
            simpleAuthInfo.addStringPermissions(userMenuDTO.getUserMenuList().stream().map(UserMenu::getMenuUrl).collect(Collectors.toList()));
        }
        return simpleAuthInfo;
    }

    /**
     * 用户认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 用户id
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userId = token.getUsername();
        if (StringUtils.isBlank(userId)) {
            throw new UnknownAccountException();
        }
        UserDTO userDTO = userService.getByUserId(userId);
        if (null == userDTO.getUser()) {
            throw new UnknownAccountException();
        }
        if (UserStatusEnum.ACTIVE.getStatus() != userDTO.getUser().getUserStatus()) {
            throw new CustomShiroException(userDTO.getUser().getUserStatus() + "");
        }
        return new SimpleAuthenticationInfo(userId, userDTO.getUser().getUserPwd(), getName());
    }

}
