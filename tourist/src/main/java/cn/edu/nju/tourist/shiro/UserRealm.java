package cn.edu.nju.tourist.shiro;

import cn.edu.nju.tourist.bean.User;
import cn.edu.nju.tourist.mapper.UserMapper;
import cn.edu.nju.tourist.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 执行授权的逻辑
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        return null;
    }

    /**
     * 执行认证的逻辑
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        // 编写shiro认证逻辑，即判断用户名和密码
        // 1. 判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        System.out.println(token.getUsername());
        // 数据库中的数据
        User user = userService.findByName(token.getUsername());

        if (user == null) {
            // 用户名不存在
            // shiro底层抛出UnknownAccountException
            System.out.println("user is null");
            return null;
        }
        // 判断密码
        return new SimpleAuthenticationInfo("", user.getPassword(), "");
    }
}
