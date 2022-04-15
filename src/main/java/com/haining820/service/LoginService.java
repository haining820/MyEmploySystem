package com.haining820.service;


import org.apache.ibatis.annotations.Param;

public interface LoginService {
    String verityCom(int comAccountNum, String comPwd);
    String verityAdmin(int adminAccountNum, String adminPwd);
    String verifyEm(int emAccountNum, String emPwd);
}
