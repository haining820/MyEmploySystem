package com.haining820.service;

import com.haining820.pojo.Job;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface JobService {
    List<Job> queryJobByLimit(Map<String, Object> map);
    int countJobNum(Map<String, Object> map);
    int deleteJobById(int jobId);
    int addJob(Job job);
    int updateJob(Job job);
    String queryJobNameById(int jobId);

}
