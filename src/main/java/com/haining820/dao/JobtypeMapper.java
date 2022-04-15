package com.haining820.dao;

import com.haining820.pojo.Jobtype;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface JobtypeMapper {

    List<Jobtype> queryJobtypeByLimit(Map<String, Object> map);
    int countJobtypeNum(Map<String, Object> map);

    @Delete("delete from employsys.jobtype " +
            "where jobtypeId=#{jobtypeId};")
    int deleteJobtypeById(@Param("jobtypeId") int jobtypeId);

    @Update("update employsys.jobtype set jobtypeName=#{jobtypeName} " +
            "where jobtypeId=#{jobtypeId};")
    int updateJobtype(Jobtype jobtype);

    @Insert("insert into employsys.jobtype (jobtypeName, jobtypeCreateTime) values (#{jobtypeName},#{jobtypeCreateTime});")
    int addJobtype(Jobtype jobtype);

    @Select("select jobtypeName from employsys.jobtype " +
            "where jobtypeId=#{jobtypeId};")
    String queryJobtypeNameById(@Param("jobtypeId") int jobtypeId);

    @Select("select * from employsys.jobtype;")
    List<Jobtype> queryAllJobtype();

}
