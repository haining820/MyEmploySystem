package com.haining820.dao;

import com.haining820.pojo.Analysis;
import com.haining820.pojo.Comjob;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface ComjobMapper {
    List<Comjob> queryComjobByLimit(Map<String,Object> map);

    @Select("select count(*) from employsys.comjob;")
    int countComjobNum();

    @Select("select * from employsys.comjob where comId=#{comId} limit #{startIndex},#{pageSize}")
    List<Comjob> queryComjobByCom(Map<String,Object> map);

    @Select("select * from employsys.comjob where comjobId=#{comjobId}")
    Comjob queryComjobById(@Param("comjobId") int comjobId);

    @Select("select jobId from employsys.comjob where comjobId=#{comjobId}")
    int queryJobIdByComjobId(@Param("comjobId") int comjobId);

    @Update("update employsys.comjob set hiredNum=hiredNum+1 where comjobId=#{comjobId}")
    int addHiredNum(@Param("comjobId") int comjobId);

    @Select("select comjobId,hireMaxNum,hiredNum from employsys.comjob")
    List<Analysis> queryAll();



}
