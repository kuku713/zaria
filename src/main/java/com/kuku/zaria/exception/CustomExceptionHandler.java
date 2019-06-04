package com.kuku.zaria.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.kuku.zaria.common.ErrorCodeConsts;
import com.kuku.zaria.common.UserConsts;
import com.kuku.zaria.common.UserStatusEnum;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luzh21574
 * @description 全局异常处理
 * @date 2019-05-22
 */
public class CustomExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, String> attributes = new HashMap<>(2);
        if (ex instanceof UnknownAccountException) {
            attributes.put("returnCode", ErrorCodeConsts.USER_UNKNOWN_ERR);
            attributes.put("returnMsg", "用户不存在");
        } else if (ex instanceof AuthenticationException) {
            if (ex.getCause() instanceof CustomShiroException) {
                switch (ex.getCause().getMessage()) {
                    case UserConsts.USER_STATUS_INACTIVE:
                        attributes.put("returnCode", ErrorCodeConsts.USER_STATUS_INACTIVE_ERR);
                        attributes.put("returnMsg", UserStatusEnum.INACTIVE.getErrMsg());
                        break;
                    case UserConsts.USER_STATUS_LOCK:
                        attributes.put("returnCode", ErrorCodeConsts.USER_STATUS_LOCK_ERR);
                        attributes.put("returnMsg", UserStatusEnum.LOCK.getErrMsg());
                        break;
                    case UserConsts.USER_STATUS_BLACK_LIST:
                        attributes.put("returnCode", ErrorCodeConsts.USER_STATUS_BLACK_LIST_ERR);
                        attributes.put("returnMsg", UserStatusEnum.BLACK_LIST.getErrMsg());
                        break;
                    case UserConsts.USER_STATUS_DELETE:
                        attributes.put("returnCode", ErrorCodeConsts.USER_STATUS_DELETE_ERR);
                        attributes.put("returnMsg", UserStatusEnum.DELETE.getErrMsg());
                        break;
                    default:
                        attributes.put("returnCode", ErrorCodeConsts.RETURN_CODE_FAIL);
                        attributes.put("returnMsg", ex.getCause().getMessage());
                        break;
                }
            } else {
                attributes.put("returnCode", ErrorCodeConsts.USER_PWD_ERR);
                attributes.put("returnMsg", "密码错误");
            }
        } else if (ex instanceof UnauthenticatedException) {
            attributes.put("returnCode", ErrorCodeConsts.USER_UNAUTHENTICATED_ERR);
            attributes.put("returnMsg", "用户未认证");
        } else if (ex instanceof UnauthorizedException) {
            attributes.put("returnCode", ErrorCodeConsts.USER_UNAUTHORIZED_ERR);
            attributes.put("returnMsg", "用户无权限");
        } else {
            attributes.put("returnCode", ErrorCodeConsts.RETURN_CODE_FAIL);
            attributes.put("returnMsg", ex.getMessage());
        }
        view.setAttributesMap(attributes);
        modelAndView.setView(view);
        return modelAndView;
    }
}
