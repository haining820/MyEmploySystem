package com.haining820.service;

import com.haining820.dao.LoginMapper;


public class LoginServiceImpl implements LoginService{
    private LoginMapper loginMapper;

    public void setLoginMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    public String verityCom(int comAccountNum, String comPwd) {
        return loginMapper.verityCom(comAccountNum,comPwd);
    }

    public String verifyEm(int emAccountNum, String emPwd) {
        return loginMapper.verifyEm(emAccountNum,emPwd);
    }

    public String verityAdmin(int adminAccountNum, String adminPwd) {
        return loginMapper.verityAdmin(adminAccountNum,adminPwd);
    }

}
