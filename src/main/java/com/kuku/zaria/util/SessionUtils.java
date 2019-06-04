package com.kuku.zaria.util;

import com.kuku.zaria.common.UserConsts;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @author luzh21574
 * @description
 * @date 2019-05-13
 */
@Slf4j
public class SessionUtils {

    public static final String UNKNOWN_IP = "unknown";

    public static final String LOCAL_HOST_IP = "0:0:0:0:0:0:0:1";

    public static String getUserId(HttpServletRequest request) {
        return request.getSession() != null ? (String) request.getSession().getAttribute(UserConsts.SESSION_USER_ID_KEY) : "";
    }

    public static String getIpAddress(HttpServletRequest request) {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
        String ip = request.getHeader("X-Forwarded-For");
        if (log.isDebugEnabled()) {
            log.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);
        }

        if (ip == null || ip.length() == 0 || UNKNOWN_IP.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            if (log.isDebugEnabled()) {
                log.info("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);
            }
        }
        if (ip == null || ip.length() == 0 || UNKNOWN_IP.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            if (log.isDebugEnabled()) {
                log.info("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);
            }
        }
        if (ip == null || ip.length() == 0 || UNKNOWN_IP.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            if (log.isDebugEnabled()) {
                log.info("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);
            }
        }
        if (ip == null || ip.length() == 0 || UNKNOWN_IP.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            if (log.isDebugEnabled()) {
                log.info("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);
            }
        }
        if (ip == null || ip.length() == 0 || UNKNOWN_IP.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (LOCAL_HOST_IP.equals(ip)) {
                ip = "localhost";
            }
            if (log.isDebugEnabled()) {
                log.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = ips[index];
                if (!(UNKNOWN_IP.equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }

}
