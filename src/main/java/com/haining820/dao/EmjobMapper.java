package com.haining820.dao;

import com.haining820.pojo.Emjob;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface EmjobMapper {

    List<Emjob> queryEmjobByLimit(Map<String,Object> map);

    List<Emjob> queryEmjobByCom(Map<String,Object> map);

    @Select("select * from employsys.emjob where emId=#{emId} limit #{startIndex},#{pageSize}")
    List<Emjob> queryEmjobByEm(Map<String,Object> map);

    @Insert("insert into employsys.emjob (comjobId,emId,reply,res,emjobCreateTime) " +
            "values (#{comjobId},#{emId},#{reply},#{res},#{emjobCreateTime})")
    int addEmjob(Emjob emjob);

    @Select("select emjobId from employsys.emjob where comjobId=#{comjobId} and emId=#{emId}")
    String queryByComjobIdEmId(@Param("comjobId") int comjobId, @Param("emId") int emId);

    @Update("update employsys.emjob set reply=1,res=#{res} where emjobId=#{emjobId}")
    int handle(@Param("res") int res,@Param("emjobId") int emjobId);

    @Select("select comjobId from employsys.emjob where emjobId=#{emjobId}")
    int queryComjobById(@Param("emjobId") int emjobId);

    @Select("select reply from employsys.emjob where emjobId=#{emjobId}")
    int queryReplyById(@Param("emjobId") int emjobId);

    @Select("select emId from employsys.emjob where emjobId=#{emjobId}")
    int queryEmIdById(@Param("emjobId") int emjobId);
}
