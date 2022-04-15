package com.haining820.service;

import com.haining820.dao.AdminMapper;
import com.haining820.pojo.Admin;

import java.util.List;

public class AdminServiceImpl implements AdminService{

    private AdminMapper adminMapper;
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public String queryAdminNameById(int adminId) {
        return adminMapper.queryAdminNameById(adminId);
    }
}
