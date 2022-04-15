package com.haining820.service;

import com.haining820.pojo.Com;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ComService {
    List<Com> queryAllCom();
    List<Com> queryComByLimit(Map<String,Object> map);
    int countComNum(Map<String,Object> map);
    Com queryComById(int comId);
    String queryComNameById(int comId);
    int deleteComById(int comId);
    int queryUserByComId(int comId);
    int updateCom(Com com);
    int addCom(Com com);
    String queryComUserNameById(int comId);
}
