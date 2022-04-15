package com.haining820.dao;

import com.haining820.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminMapper {
    @Select("select adminName from employsys.admin where adminId=#{adminId};")
    String queryAdminNameById(@Param("adminId") int adminId);
}
