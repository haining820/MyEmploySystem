package com.haining820.service;

import com.haining820.dao.EmjobMapper;
import com.haining820.pojo.Emjob;

import java.util.List;
import java.util.Map;

public class EmjobServiceImpl implements EmjobService{

    private EmjobMapper emjobMapper;

    public void setEmjobMapper(EmjobMapper emjobMapper) {
        this.emjobMapper = emjobMapper;
    }

    public List<Emjob> queryEmjobByLimit(Map<String, Object> map) {
        return emjobMapper.queryEmjobByLimit(map);
    }

    public List<Emjob> queryEmjobByCom(Map<String, Object> map) {
        return emjobMapper.queryEmjobByCom(map);
    }

    public List<Emjob> queryEmjobByEm(Map<String, Object> map) {
        return emjobMapper.queryEmjobByEm(map);
    }

    public int addEmjob(Emjob emjob) {
        return emjobMapper.addEmjob(emjob);
    }

    public String queryByComjobIdEmId(int comjobId, int emId) {
        return emjobMapper.queryByComjobIdEmId(comjobId,emId);
    }

    public int handle(int res, int emjobId) {
        return emjobMapper.handle(res,emjobId);
    }

    public int queryComjobById(int emjobId) {
        return emjobMapper.queryComjobById(emjobId);
    }

    public int queryReplyById(int emjobId) {
        return emjobMapper.queryReplyById(emjobId);
    }

    public int queryEmIdById(int emjobId) {
        return emjobMapper.queryEmIdById(emjobId);
    }
}
