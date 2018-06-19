package com.zhilong.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(String username, String password){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,new Md5Hash(password).toString());
            subject.login(usernamePasswordToken);
            map.put("message","登录成功");
        }catch (AuthenticationException ex){
            ex.printStackTrace();
            map.put("message","登录失败");
        }
        return map;
    }
}
