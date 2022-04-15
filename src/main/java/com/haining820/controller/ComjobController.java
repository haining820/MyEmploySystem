package com.haining820.controller;

import com.alibaba.fastjson.JSONObject;
import com.haining820.pojo.Com;
import com.haining820.pojo.Comjob;
import com.haining820.service.ComService;
import com.haining820.service.ComjobService;
import com.haining820.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ComjobController {

    @Autowired
    @Qualifier("comjobServiceImpl")
    ComjobService comjobService;

    @Autowired
    @Qualifier("comServiceImpl")
    ComService comService;

    @Autowired
    @Qualifier("jobServiceImpl")
    JobService jobService;

    @RequestMapping("/admin/queryComjobByLimit")
    @ResponseBody
    public String queryComjobByLimit(HttpServletRequest request){
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer limit = Integer.parseInt(request.getParameter("limit"));  //将String强转为int

        HashMap<String, Object> map = new HashMap<String, Object>();  //用于分页查询和搜索的map
        map.put("startIndex", (page - 1) * limit);
        map.put("pageSize", limit);
        System.out.println(map);
        System.out.println("==========================");

        List<Comjob> limitComList = comjobService.queryComjobByLimit(map);
        for(Comjob comjob:limitComList){
            comjob.setComId(comService.queryComNameById(Integer.parseInt(comjob.getComId())));
            comjob.setJobId(jobService.queryJobNameById(Integer.parseInt(comjob.getJobId())));
        }

        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "success");
        obj.put("count",comjobService.countComjobNum());
        obj.put("data", limitComList);
        // System.out.println("所有公司的数量: " + comService.countComNum());
        return obj.toString();
    }

    @RequestMapping("/user/showComjobDetail/{comjobId}")
    @ResponseBody
    public String showComjobDetail(@PathVariable("comjobId") int comjobId){
        Comjob curComjob = comjobService.queryComjobById(comjobId);
        curComjob.setComId(comService.queryComNameById(Integer.parseInt(curComjob.getComId())));
        curComjob.setJobId(jobService.queryJobNameById(Integer.parseInt(curComjob.getJobId())));
        JSONObject json = new JSONObject();
        json.put("data", curComjob);
        return json.toString();
    }

    @RequestMapping("/user/queryComjobByCom")
    @ResponseBody
    public String queryComjobByCom(HttpServletRequest request){
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer limit = Integer.parseInt(request.getParameter("limit"));  //将String强转为int
        int comId = Integer.parseInt(request.getSession().getAttribute("userLoginId").toString());
        HashMap<String, Object> map = new HashMap<String, Object>();  //用于分页查询和搜索的map
        map.put("startIndex", (page - 1) * limit);
        map.put("pageSize", limit);
        map.put("comId", comId);
        List<Comjob> comList = comjobService.queryComjobByCom(map);
        for(Comjob comjob:comList){
            comjob.setComId(comService.queryComNameById(Integer.parseInt(comjob.getComId())));
            comjob.setJobId(jobService.queryJobNameById(Integer.parseInt(comjob.getJobId())));
        }
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "success");
        obj.put("count",comList.size());
        obj.put("data", comList);
        // System.out.println("所有公司的数量: " + comService.countComNum());
        return obj.toString();
    }
}
