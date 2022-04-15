package com.haining820.service;

import com.haining820.pojo.Em;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

public interface EmService {
    // 分页查询,搜索
    List<Em> queryEmByLimit(Map<String, Object> map);

    // 查询结果(搜索结果)条数
    int countEmNum(Map<String, Object> map);

    // 通过emId查询普通用户昵称
    String queryEmUsernameById(int emId);

    // 通过emId查询普通用户姓名
    String queryEmNameById(int emId);

    // 根据emId查询全部普通用户
    Em queryEmById(int emId);

    // 添加用户
    int addEm(Em em);

    // 删除用户
    int deleteEmById(int emId);

    // 更新用户
    int updateEm(Em em);

    // 添加简历文件夹名
    int addEmFile(String emFile, int emId);

    String queryEmFileById(int emId);
}
