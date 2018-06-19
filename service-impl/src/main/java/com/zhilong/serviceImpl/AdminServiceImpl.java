package com.zhilong.serviceImpl;

import com.zhilong.entity.Admin;
import com.zhilong.example.AdminExample;
import com.zhilong.mapper.AdminMapper;
import com.zhilong.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin getAccount(String name) {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andNameEqualTo(name);
        Admin admin = null;
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (admins != null && !admins.isEmpty()){
            admin = admins.get(0);
        }
        return admin;
    }
}
