package com.haining820.service;

import com.haining820.pojo.Emjob;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmjobService {
    List<Emjob> queryEmjobByLimit(Map<String,Object> map);
    List<Emjob> queryEmjobByCom(Map<String,Object> map);
    List<Emjob> queryEmjobByEm(Map<String,Object> map);
    int addEmjob(Emjob emjob);
    String queryByComjobIdEmId(int comjobId,int emId);
    int handle(int res,int emjobId);
    int queryComjobById(int emjobId);
    int queryReplyById(int emjobId);
    int queryEmIdById(int emjobId);
}
