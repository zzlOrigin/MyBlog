package com.zhilong.auth;

import com.zhilong.entity.Admin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroUtil {

    public static Admin getCurrentAdmin(){
        return (Admin) getSubject().getPrincipal();
    }

    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

}
