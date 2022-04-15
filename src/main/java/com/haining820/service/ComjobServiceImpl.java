package com.haining820.service;

import com.haining820.dao.ComjobMapper;
import com.haining820.pojo.Analysis;
import com.haining820.pojo.Comjob;

import java.util.List;
import java.util.Map;

public class ComjobServiceImpl implements ComjobService{

    private ComjobMapper comjobMapper;

    public void setComjobMapper(ComjobMapper comjobMapper) {
        this.comjobMapper = comjobMapper;
    }

    public List<Comjob> queryComjobByLimit(Map<String, Object> map) {
        return comjobMapper.queryComjobByLimit(map);
    }

    public int countComjobNum() {
        return comjobMapper.countComjobNum();
    }

    public List<Comjob> queryComjobByCom(Map<String, Object> map) {
        return comjobMapper.queryComjobByCom(map);
    }

    public Comjob queryComjobById(int comjobId) {
        return comjobMapper.queryComjobById(comjobId);
    }

    public int queryJobIdByComjobId(int comjobId) {
        return comjobMapper.queryJobIdByComjobId(comjobId);
    }

    public int addHiredNum(int comjobId) {
        return comjobMapper.addHiredNum(comjobId);
    }

    public List<Analysis> queryAll() {
        return comjobMapper.queryAll();
    }
}
