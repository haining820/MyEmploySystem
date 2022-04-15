package com.haining820.controller;

import com.alibaba.fastjson.JSONObject;
import com.haining820.pojo.Jobtype;
import com.haining820.service.JobtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class JobtypeController {

    @Autowired
    @Qualifier("jobtypeServiceImpl")
    private JobtypeService jobtypeService;

    @RequestMapping("/admin/queryJobtypeByLimit")
    @ResponseBody
    public String queryJobtypeByLimit(HttpServletRequest request,
                                      @RequestParam(value = "jobtypeName", required = false, defaultValue = "") String jobtypeName) {
        if ("".equals(jobtypeName)) {
            jobtypeName = null;
        }
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer limit = Integer.parseInt(request.getParameter("limit"));  //将String强转为int

        HashMap<String, Object> map = new HashMap<String, Object>();  //用于分页查询和搜索的map
        map.put("startIndex", (page - 1) * limit);
        map.put("pageSize", limit);
        map.put("jobtypeName", jobtypeName);
        System.out.println(map);
        System.out.println("==========================");

        List<Jobtype> limitComList = jobtypeService.queryJobtypeByLimit(map);

        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "success");
        obj.put("count", jobtypeService.countJobtypeNum(map));
        obj.put("data", limitComList);
        // System.out.println("所有公司的数量: " + comService.countComNum());
        return obj.toString();
    }

    @RequestMapping("/admin/addJobtype")
    @ResponseBody
    public Map<String, Object> addJobtype(@RequestBody Jobtype jobtype) {
        SimpleDateFormat sdf = new SimpleDateFormat();  // 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");  // a为am/pm的标记
        Date date = new Date();  // 获取当前时间
        jobtype.setJobtypeCreateTime(sdf.format(date));  // 设置创建时间

        System.out.println("==========================");
        System.out.println(jobtype);
        int res = jobtypeService.addJobtype(jobtype);
        Map<String, Object> map = new HashMap<String, Object>();
        if (res > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping("/edit/updateJobtype")
    @ResponseBody
    public Map<String,Object> updateJobtype(@RequestBody Jobtype jobtype){
        int res = jobtypeService.updateJobtype(jobtype);
        Map<String, Object> map = new HashMap<String, Object>();
        if (res > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping("/admin/deleteJobtypeById/{jobtypeId}")
    @ResponseBody
    public Map<String,Object> deleteJobTypeById(@PathVariable("jobtypeId") int jobtypeId){
        int res = jobtypeService.deleteJobtypeById(jobtypeId);
        Map<String, Object> map = new HashMap<String, Object>();
        if (res > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        System.out.println(map.toString());
        return map;
    }


    @RequestMapping("/admin/queryAllJobtype")
    @ResponseBody
    public String queryAllJobtype(){
        List<Jobtype> jobtypeList = jobtypeService.queryAllJobtype();
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "success");
        obj.put("count", jobtypeList.size());
        obj.put("data", jobtypeList);
        return obj.toString();
    }

}
