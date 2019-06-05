package com.kuku.zaria.shiro;

import com.alibaba.fastjson.JSONObject;
import com.kuku.zaria.bean.dto.BaseDTO;
import com.kuku.zaria.common.ErrorCodeConsts;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.springframework.http.MediaType;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author kuku713
 * @description
 * @date 2019-06-04
 */
@Slf4j
public class CustomAuthcFilter extends UserFilter {

    private static final BaseDTO UNAUTHENTICATED = new BaseDTO(ErrorCodeConsts.USER_UNAUTHENTICATED_ERR, "用户未登录");

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        String url = ((HttpServletRequest)request).getServletPath();
        if (ShiroConfiguration.LOGIN_URL.equals(url)
                || ShiroConfiguration.CAPTCHA_URL.equals(url)) {
            return true;
        }
        if(log.isInfoEnabled()) {
            log.info("user need login for: {}",  ((HttpServletRequest)request).getServletPath());
        }
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(JSONObject.toJSONString(UNAUTHENTICATED, true));
        response.getWriter().flush();
        response.getWriter().close();
        return false;
    }
}
