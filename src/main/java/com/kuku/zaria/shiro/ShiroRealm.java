package com.kuku.zaria.shiro;

import com.kuku.zaria.bean.dto.UserDTO;
import com.kuku.zaria.bean.dto.MenuDTO;
import com.kuku.zaria.bean.dto.RoleDTO;
import com.kuku.zaria.common.UserStatusEnum;
import com.kuku.zaria.domain.entity.Menu;
import com.kuku.zaria.domain.entity.Role;
import com.kuku.zaria.exception.CustomShiroException;
import com.kuku.zaria.service.MenuService;
import com.kuku.zaria.service.RoleService;
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
 * @author kuku713
 * @description
 * @date 2019-05-19
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

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
            RoleDTO roleDTO = roleService.listUserRolesByUserId(userId);
            simpleAuthInfo.addRoles(roleDTO.getRoleList().stream().map(Role::getRoleCode).collect(Collectors.toList()));
            // 用户所有权限（菜单URL）
            MenuDTO menuDTO = menuService.listUserMenusByUserId(userId);
            simpleAuthInfo.addStringPermissions(menuDTO.getMenuList().stream().map(Menu::getMenuUrl).collect(Collectors.toList()));
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
