package com.haining820.dao;

import com.haining820.pojo.Job;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface JobMapper {

    List<Job> queryJobByLimit(Map<String, Object> map);

    int countJobNum(Map<String, Object> map);

    @Delete("delete from employsys.job " +
            "where jobId=#{jobId}")
    int deleteJobById(@Param("jobId") int jobId);

    @Insert("insert into employsys.job (jobId,jobtypeId,jobName,jobCreateTime)" +
            "values(#{jobId},#{jobtypeId},#{jobName},#{jobCreateTime})")
    int addJob(Job job);

    @Update("update employsys.job " +
            "set jobtypeId=#{jobtypeId},jobName=#{jobName} " +
            "where jobId=#{jobId}")
    int updateJob(Job job);

    @Select("select jobName from employsys.job where jobId=#{jobId}")
    String queryJobNameById(@Param("jobId") int jobId);

}
