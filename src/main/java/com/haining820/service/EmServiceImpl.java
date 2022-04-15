package com.haining820.service;

import com.haining820.dao.EmMapper;
import com.haining820.pojo.Em;

import java.util.List;
import java.util.Map;

public class EmServiceImpl implements EmService{
    private EmMapper emMapper;
    public void setEmMapper(EmMapper emMapper) {
        this.emMapper = emMapper;
    }

    public Em queryEmById(int emId) {
        return emMapper.queryEmById(emId);
    }

    public List<Em> queryEmByLimit(Map<String, Object> map) {
        return emMapper.queryEmByLimit(map);
    }

    public int countEmNum(Map<String, Object> map) {
        return emMapper.countEmNum(map);
    }

    public String queryEmUsernameById(int emId) {
        return emMapper.queryEmUsernameById(emId);
    }

    public String queryEmNameById(int emId) {
        return emMapper.queryEmNameById(emId);
    }

    public int addEm(Em em) {
        return emMapper.addEm(em);
    }

    public int deleteEmById(int emId) {
        return emMapper.deleteEmById(emId);
    }

    public int updateEm(Em em) {
        return emMapper.updateEm(em);
    }

    public int addEmFile(String emFile, int emId) {
        return emMapper.addEmFile(emFile,emId);
    }

    public String queryEmFileById(int emId) {
        return emMapper.queryEmFileById(emId);
    }
}
