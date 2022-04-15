package com.haining820.service;

import com.haining820.pojo.Jobtype;
import java.util.List;
import java.util.Map;

public interface JobtypeService {
    List<Jobtype> queryJobtypeByLimit(Map<String, Object> map);
    int countJobtypeNum(Map<String, Object> map);
    int deleteJobtypeById(int jobtypeId);
    int updateJobtype(Jobtype jobtype);
    int addJobtype(Jobtype jobtype);
    String queryJobtypeNameById(int jobtypeId);
    List<Jobtype> queryAllJobtype();
}
