package com.haining820.dao;

import com.haining820.pojo.Em;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface EmMapper {
    //分页查询,搜索
    List<Em> queryEmByLimit(Map<String, Object> map);

    //查询结果(搜索结果)条数
    int countEmNum(Map<String, Object> map);

    @Select("select emUsername from employsys.employee where emId = #{emId};")
    String queryEmUsernameById(@Param("emId") int emId);

    @Select("select emName from employsys.employee where emId = #{emId};")
    String queryEmNameById(@Param("emId") int emId);

    @Select("select * from employsys.employee where emId = #{emId};")
    Em queryEmById(@Param("emId") int emId);

    //添加用户
    @Insert("insert into employsys.employee (emAccountNum,emPwd,emUsername,emName," +
            "emSex,emBirth,emSchool,emIntro,emEmail,emTel,emGraduateTime,emCreateTime) " +
            "values (#{emAccountNum},#{emPwd},#{emUsername},#{emName}," +
            "#{emSex},#{emBirth},#{emSchool},#{emIntro},#{emEmail},#{emTel},#{emGraduateTime},#{emCreateTime})")
    int addEm(Em em);

    //删除用户
    @Delete("delete from employsys.employee " +
            "where emId=#{emId};")
    int deleteEmById(@Param("emId") int emId);

    //更新用户
    @Update("update employsys.employee " +
            "set emAccountNum = #{emAccountNum},emPwd = #{emPwd},emUsername = #{emUsername},emName = #{emName}," +
            "emSex = #{emSex},emBirth = #{emBirth},emSchool = #{emSchool},emIntro = #{emIntro}," +
            "emEmail = #{emEmail},emTel = #{emTel},emGraduateTime = #{emGraduateTime} " +
            "where emId = #{emId}")
    int updateEm(Em em);

    @Update("update employsys.employee set emFile=#{emFile} where emId=#{emId}")
    int addEmFile(@Param("emFile") String emFile,@Param("emId") int emId);

    @Select("select emFile from employsys.employee where emId=#{emId}")
    String queryEmFileById(@Param("emId") int emId);

}
