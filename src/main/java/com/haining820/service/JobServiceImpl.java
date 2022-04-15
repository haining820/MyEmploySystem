package com.haining820.service;

import com.haining820.dao.JobMapper;
import com.haining820.pojo.Job;

import java.util.List;
import java.util.Map;

public class JobServiceImpl implements JobService{

    private JobMapper jobMapper;

    public void setJobMapper(JobMapper jobMapper) {
        this.jobMapper = jobMapper;
    }

    public int deleteJobById(int jobId) {
        return jobMapper.deleteJobById(jobId);
    }

    public List<Job> queryJobByLimit(Map<String, Object> map) {
        return jobMapper.queryJobByLimit(map);
    }

    public int countJobNum(Map<String, Object> map) {
        return jobMapper.countJobNum(map);
    }

    public int addJob(Job job) {
        return jobMapper.addJob(job);
    }

    public int updateJob(Job job) {
        return jobMapper.updateJob(job);
    }

    public String queryJobNameById(int jobId) {
        return jobMapper.queryJobNameById(jobId);
    }
}
