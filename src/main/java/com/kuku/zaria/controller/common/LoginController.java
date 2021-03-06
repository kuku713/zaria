package com.kuku.zaria.controller.common;

import com.kuku.zaria.bean.dto.BaseDTO;
import com.kuku.zaria.bean.dto.UserDTO;
import com.kuku.zaria.service.UserService;
import com.kuku.zaria.util.DTOUtils;
import com.kuku.zaria.util.SessionUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.cache.MapCache;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kuku713
 * @description
 * @date 2019-05-12
 */
@Slf4j
@RestController
@RequestMapping(value = "/auth")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private MapCache<String, String> localCache;

    @RequestMapping(value = "/login")
    public UserDTO login(HttpServletRequest request, String loginName, String userPwd, String captchaCode) {
        if (StringUtils.isBlank(loginName)) {
            return DTOUtils.genFailUserDTO("用户名不能为空");
        }
        if (StringUtils.isBlank(userPwd)) {
            return DTOUtils.genFailUserDTO("密码不能为空");
        }
        UserDTO dto = userService.getByLoginName(loginName);
        if (null == dto.getUser()) {
            throw new UnknownAccountException();
        }
        System.out.println(localCache.get("aaa"));
        localCache.put("aaa", "dddd");
        log.info("session中的验证码为：" + request.getSession().getAttribute("captchaCode"));
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(dto.getUser().getUserId(), userPwd));
        dto.setLoginIp(SessionUtils.getIpAddress(request));
        userService.saveUserLogin(dto, "首页登录");
        return dto;
    }

    @RequestMapping(value = "/logout")
    public BaseDTO logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return DTOUtils.genSuccessBaseDTO();
    }

}
