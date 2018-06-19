package com.zhilong.service;

import com.zhilong.entity.Admin;

public interface AdminService {

    /*
    根据用户名查询用户
     */
    Admin getAccount(String name);
}
