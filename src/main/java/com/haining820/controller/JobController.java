package com.haining820.controller;

import com.alibaba.fastjson.JSONObject;
import com.haining820.utils.MapUtil;
import com.haining820.pojo.Job;
import com.haining820.service.JobService;
import com.haining820.service.JobtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class JobController {
    @Autowired
    @Qualifier("jobServiceImpl")
    private JobService jobService;

    @Autowired
    @Qualifier("jobtypeServiceImpl")
    private JobtypeService jobtypeService;

    @RequestMapping("/admin/queryJobByLimit")
    @ResponseBody
    public String queryJobByLimit(HttpServletRequest request,
                                  @RequestParam(value = "jobName", required = false, defaultValue = "") String jobName) {
        if ("".equals(jobName)) {
            jobName = null;
        }
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer limit = Integer.parseInt(request.getParameter("limit"));  //将String强转为int

        HashMap<String, Object> map = new HashMap<String, Object>();  //用于分页查询和搜索的map
        map.put("startIndex", (page - 1) * limit);
        map.put("pageSize", limit);
        map.put("jobName", jobName);

        List<Job> limitComList = jobService.queryJobByLimit(map);
        for (Job job : limitComList) {
            String jobtypeName = jobtypeService.queryJobtypeNameById(Integer.parseInt(job.getJobtypeId()));
            job.setJobtypeId(jobtypeName);
        }

        System.out.println("==========================");
        System.out.println(map);
        System.out.println("job名单:" + limitComList.toString());
        System.out.println("==========================");

        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "success");
        obj.put("count", jobService.countJobNum(map));
        obj.put("data", limitComList);
        return obj.toString();
    }

    @RequestMapping("/admin/deleteJobById/{jobId}")
    @ResponseBody
    public Map<String, Object> deleteJobById(@PathVariable("jobId") int jobId) {
        int res = jobService.deleteJobById(jobId);
        Map<String, Object> map = MapUtil.returnMap(res);
        return map;
    }

    @RequestMapping("/admin/addJob")
    @ResponseBody
    public Map<String, Object> addJob(@RequestBody Job job) {
        System.out.println("前端传回来的数据:");
        System.out.println(job.toString());
        int res = jobService.addJob(job);
        Map<String, Object> map = MapUtil.returnMap(res);
        return map;
    }

    @RequestMapping("/admin/updateJob")
    @ResponseBody
    public Map<String, Object> updateJob(@RequestBody Job job) {
        System.out.println("updateJob前端传回来的数据:");
        System.out.println(job.toString());
        int res = jobService.updateJob(job);
        Map<String, Object> map = MapUtil.returnMap(res);
        return map;
    }

}
