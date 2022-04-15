package com.haining820.service;

import com.haining820.dao.JobtypeMapper;
import com.haining820.pojo.Jobtype;

import java.util.List;
import java.util.Map;

public class JobtypeServiceImpl implements JobtypeService{

    private JobtypeMapper jobtypeMapper;

    public String queryJobtypeNameById(int jobtypeId) {
        return jobtypeMapper.queryJobtypeNameById(jobtypeId);
    }

    public void setJobtypeMapper(JobtypeMapper jobtypeMapper) {
        this.jobtypeMapper = jobtypeMapper;
    }

    public List<Jobtype> queryJobtypeByLimit(Map<String, Object> map) {
        return jobtypeMapper.queryJobtypeByLimit(map);
    }

    public int countJobtypeNum(Map<String, Object> map) {
        return jobtypeMapper.countJobtypeNum(map);
    }

    public int deleteJobtypeById(int jobtypeId) {
        return jobtypeMapper.deleteJobtypeById(jobtypeId);
    }

    public int updateJobtype(Jobtype jobtype) {
        return jobtypeMapper.updateJobtype(jobtype);
    }

    public int addJobtype(Jobtype jobtype) {
        return jobtypeMapper.addJobtype(jobtype);
    }

    public List<Jobtype> queryAllJobtype() {
        return jobtypeMapper.queryAllJobtype();
    }
}
