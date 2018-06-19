package com.zhilong.auth;

import com.zhilong.entity.Admin;
import com.zhilong.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class ShiroRealm extends AuthorizingRealm {

    private AdminService adminService;

    public ShiroRealm(AdminService adminService){
        this.adminService = adminService;
    }
    /*
    权限认证
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    /*
    登录认证
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String name = usernamePasswordToken.getUsername();
        Admin admin = adminService.getAccount(name);
        if (admin != null){
            return new SimpleAuthenticationInfo(admin,admin.getPassword(),getName());
        }
        return null;
    }
}
