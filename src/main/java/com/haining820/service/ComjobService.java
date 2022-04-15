package com.haining820.service;

import com.haining820.pojo.Analysis;
import com.haining820.pojo.Comjob;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ComjobService {
    List<Comjob> queryComjobByLimit(Map<String,Object> map);
    int countComjobNum();
    List<Comjob> queryComjobByCom(Map<String,Object> map);
    Comjob queryComjobById(int comjobId);
    int queryJobIdByComjobId(int comjobId);
    int addHiredNum(int comjobId);
    List<Analysis> queryAll();
}
