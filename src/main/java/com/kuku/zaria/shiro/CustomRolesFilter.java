package com.kuku.zaria.shiro;

import com.alibaba.fastjson.JSONObject;
import com.kuku.zaria.bean.dto.BaseDTO;
import com.kuku.zaria.common.ErrorCodeConsts;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.springframework.http.MediaType;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author luzh21574
 * @description
 * @date 2019-06-04
 */
@Slf4j
public class CustomRolesFilter extends RolesAuthorizationFilter {

    private static final BaseDTO UNAUTHORIZED = new BaseDTO(ErrorCodeConsts.USER_UNAUTHORIZED_ERR, "用户未授权");

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        if(log.isInfoEnabled()) {
            log.info("user need roles for: {}",  ((HttpServletRequest)request).getServletPath());
        }
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(JSONObject.toJSONString(UNAUTHORIZED, true));
        response.getWriter().flush();
        response.getWriter().close();
        return false;
    }
}
