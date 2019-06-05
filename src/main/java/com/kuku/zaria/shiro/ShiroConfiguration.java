package com.kuku.zaria.shiro;

import com.kuku.zaria.exception.CustomExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.MapCache;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.SoftHashMap;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author kuku713
 * @description
 * @date 2019-05-17
 */
@Slf4j
@Configuration
public class ShiroConfiguration {

    public static final String LOGIN_URL = "/auth/login";
    /** 验证码URL */
    public static final String CAPTCHA_URL = "/captcha";

    public static final String STATIC_URL = "/static/**";

    private static Map<String, String> FILTER_CHAIN_MAP = new LinkedHashMap<>();

    static {
        FILTER_CHAIN_MAP.put(STATIC_URL, "anon");
        FILTER_CHAIN_MAP.put(LOGIN_URL, "anon");
        FILTER_CHAIN_MAP.put(CAPTCHA_URL, "anon");
        // authc用来判断用户是否已登录，所以放在最前面，不能更改顺序
        FILTER_CHAIN_MAP.put("/**", "authc");
        FILTER_CHAIN_MAP.put("/admin/**", "roles[admin]");
        FILTER_CHAIN_MAP.put("/user/**", "roles[user]");
    }

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 默认跳转到登陆页面
        shiroFilterFactoryBean.setLoginUrl("/static/login.html");
        // 自定义过滤器
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("authc", customAuthcFilter());
        filterMap.put("roles", customRolesFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        // 自定义权限控制器
        shiroFilterFactoryBean.setFilterChainDefinitionMap(FILTER_CHAIN_MAP);
        return shiroFilterFactoryBean;
    }

    @Bean
    public CustomAuthcFilter customAuthcFilter() {
        return new CustomAuthcFilter();
    }

    @Bean
    public CustomRolesFilter customRolesFilter() {
        return new CustomRolesFilter();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 自定义realm
        securityManager.setRealm(shiroRealm());
        // 自定义session管理
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean
    public SessionManager sessionManager() {
        return new ShiroSessionManager();
    }

    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm realm = new ShiroRealm();
        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        return realm;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);
        return matcher;
    }

    @Bean
    public MapCache localCache() {
        return new MapCache("zaria", new SoftHashMap());
    }

    @Bean(name = "exceptionHandler")
    public HandlerExceptionResolver handlerExceptionResolver() {
        return new CustomExceptionHandler();
    }

}
