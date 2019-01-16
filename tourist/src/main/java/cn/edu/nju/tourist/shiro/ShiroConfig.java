package cn.edu.nju.tourist.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro的配置类
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        /**
         * Shiro 内置过滤器：可以实现权限相关的拦截器
         *  常用过滤器：
         *      anon：无需认证（登录）
         *      authc：必须认证
         *      user：如果使用rememberMe可以直接访问
         *      perms：该资源必须得到资源权限才可以访问
         *      role：必须得到角色权限才可以访问
         */
        // 利用路径和过滤器，设置资源拦截
        Map<String, String> filterMap = new LinkedHashMap<>();  // 使用LinkedHashMap来保证顺序

        filterMap.put("/user/info", "authc");
        // 授权过滤器
        // 授权拦截后，shiro自动跳转到未授权的页面
        filterMap.put("/user/getAll", "perms[user:all]");
        filterMap.put("/user/*", "authc");


        // 修改被拦截后跳转到的界面（默认login.jsp）
        shiroFilterFactoryBean.setLoginUrl("/authority/authcFail");

        // 设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/authority/noAuthc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);


        return shiroFilterFactoryBean;
    }


    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }
}
