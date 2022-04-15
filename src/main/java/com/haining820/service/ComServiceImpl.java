package com.haining820.service;

import com.haining820.dao.ComMapper;
import com.haining820.pojo.Com;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public class ComServiceImpl implements ComService{
    private ComMapper comMapper;

    public void setComMapper(ComMapper comMapper) {
        this.comMapper = comMapper;
    }

    public List<Com> queryComByLimit(Map<String, Object> map) {
        return comMapper.queryComByLimit(map);
    }

    public int countComNum(Map<String,Object> map) {
        return comMapper.countComNum(map);
    }

    public Com queryComById(int comId) {
        return comMapper.queryComById(comId);
    }

    public String queryComNameById(int comId) {
        return comMapper.queryComNameById(comId);
    }

    public List<Com> queryAllCom() {
        return comMapper.queryAllCom();
    }

    public int deleteComById(int comId) {
        return comMapper.deleteComById(comId);
    }

    public int queryUserByComId(int comId){
        return comMapper.queryUserByComId(comId);
    }

    public int addCom(Com com) {
        return comMapper.addCom(com);
    }

    public int updateCom(Com com) {
        return comMapper.updateCom(com);
    }

    public String queryComUserNameById(int comId) {
        return comMapper.queryComUserNameById(comId);
    }
}
