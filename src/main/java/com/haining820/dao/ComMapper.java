package com.haining820.dao;

import com.haining820.pojo.Com;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface ComMapper {
    @Select("select * from employsys.company;")
    List<Com> queryAllCom();

    // @Select("select * from employsys.company limit #{startIndex},#{pageSize}")
    List<Com> queryComByLimit(Map<String, Object> map);  //分页

    // @Select("select count(*) as comSum from employsys.company;")
    int countComNum(Map<String, Object> map);

    @Select("select * from employsys.company where comId = #{comId};")
    Com queryComById(@Param("comId") int comId);

    @Select("select comName from employsys.company where comId = #{comId};")
    String queryComNameById(@Param("comId") int comId);

    @Select("select comUserName from employsys.company where comId = #{comId};")
    String queryComUserNameById(@Param("comId") int comId);

    @Delete("delete from employsys.company where comId = #{comId};")
    int deleteComById(@Param("comId") int comId);

    @Select("select userId from employsys.company where comId = #{comId};")
    int queryUserByComId(@Param("comId") int comId);

    @Update("update employsys.company " +
            "set comAccountNum=#{comAccountNum},comPwd = #{comPwd},comUserName = #{comUserName}," +
            "comName = #{comName},comIntro = #{comIntro},comAddress = #{comAddress}," +
            "comEmail = #{comEmail},comTel = #{comTel},comWeb = #{comWeb} " +
            "where comId = #{comId};")
    int updateCom(Com com);

    @Insert("insert into employsys.company (comAccountNum,comPwd,comUserName,comName,comIntro,comAddress,comEmail,comTel,comWeb,comCreateTime) " +
            "values (#{comAccountNum},#{comPwd},#{comUserName}," +
            "#{comName},#{comIntro},#{comAddress}," +
            "#{comEmail},#{comTel},#{comWeb},#{comCreateTime})")
    int addCom(Com com);
}
