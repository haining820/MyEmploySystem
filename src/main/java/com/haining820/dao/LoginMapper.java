package com.haining820.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface LoginMapper {

    @Select("select comId from employsys.company where comAccountNum = #{comAccountNum} and comPwd = #{comPwd};")
    String verityCom(@Param("comAccountNum") int comAccountNum, @Param("comPwd") String comPwd);

    @Select("select emId from employsys.employee where emAccountNum = #{emAccountNum} and emPwd = #{emPwd};")
    String verifyEm(@Param("emAccountNum") int emAccountNum,@Param("emPwd") String emPwd);

    @Select("select adminId from employsys.admin where adminAccountNum = #{adminAccountNum} and adminPwd = #{adminPwd};")
    String verityAdmin(@Param("adminAccountNum") int adminAccountNum, @Param("adminPwd") String adminPwd);
}
