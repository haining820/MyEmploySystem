package com.haining820.controller;


import com.alibaba.fastjson.JSONObject;
import com.haining820.pojo.Emjob;
import com.haining820.service.ComjobService;
import com.haining820.service.EmService;
import com.haining820.service.EmjobService;
import com.haining820.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.haining820.utils.TimeUtil;
import com.haining820.utils.MapUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmjobController {

    @Autowired
    @Qualifier("emjobServiceImpl")
    EmjobService emjobService;

    @Autowired
    @Qualifier("emServiceImpl")
    EmService emService;

    @Autowired
    @Qualifier("comjobServiceImpl")
    ComjobService comjobService;

    @Autowired
    @Qualifier("jobServiceImpl")
    JobService jobService;


    //公司端查看投递自己岗位的应聘者
    @RequestMapping("/user/queryEmjobByCom")
    @ResponseBody
    public String queryEmjobByCom(HttpServletRequest request,
                                  @RequestParam(value = "emId", required = false, defaultValue = "") String emId) {
        if ("".equals(emId)) {
            emId = null;
        }
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer limit = Integer.parseInt(request.getParameter("limit"));  //将String强转为int
        int comId = Integer.parseInt(request.getSession().getAttribute("userLoginId").toString());
        HashMap<String, Object> map = new HashMap<String, Object>();  //用于分页查询和搜索的map
        map.put("startIndex", (page - 1) * limit);
        map.put("pageSize", limit);
        map.put("emId", emId);
        map.put("comId", comId);

        List<Emjob> limitEmjobList = emjobService.queryEmjobByCom(map);

        for (Emjob emjob : limitEmjobList) {
            emjob.setEmId(emService.queryEmNameById(Integer.parseInt(emjob.getEmId())));
            int jobId = comjobService.queryJobIdByComjobId(Integer.parseInt(emjob.getComjobId()));
            emjob.setComjobId(jobService.queryJobNameById(jobId));
            if (emjob.getRes().equals("0")) {
                emjob.setRes("拒绝");
            } else {
                emjob.setRes("通过");
            }
            if (emjob.getReply().equals("0")) {
                emjob.setReply("否");
            } else {
                emjob.setReply("是");
            }
        }
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "success");
        obj.put("count", limitEmjobList.size());
        obj.put("data", limitEmjobList);
        return obj.toString();
    }

    //公司端查看投递自己岗位的应聘者
    @RequestMapping("/user/queryEmjobByEm")
    @ResponseBody
    public String queryEmjobByEm(HttpServletRequest request) {
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer limit = Integer.parseInt(request.getParameter("limit"));  //将String强转为int
        int emId = Integer.parseInt(request.getSession().getAttribute("userLoginId").toString());
        HashMap<String, Object> map = new HashMap<String, Object>();  //用于分页查询和搜索的map
        map.put("startIndex", (page - 1) * limit);
        map.put("pageSize", limit);
        map.put("emId", emId);

        List<Emjob> limitEmjobList = emjobService.queryEmjobByEm(map);

        for (Emjob emjob : limitEmjobList) {
            emjob.setEmId(emService.queryEmNameById(Integer.parseInt(emjob.getEmId())));
            int jobId = comjobService.queryJobIdByComjobId(Integer.parseInt(emjob.getComjobId()));
            emjob.setComjobId(jobService.queryJobNameById(jobId));
            if (emjob.getRes().equals("0")) {
                emjob.setRes("拒绝");
            } else {
                emjob.setRes("通过");
            }
            if (emjob.getReply().equals("0")) {
                emjob.setReply("否");
            } else {
                emjob.setReply("是");
            }
        }
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "success");
        obj.put("count", limitEmjobList.size());
        obj.put("data", limitEmjobList);
        return obj.toString();
    }


    @RequestMapping("/user/delivery/{comjobId}/{loginId}")
    @ResponseBody
    public Map<String, Object> delivery(@PathVariable("comjobId") int comjobId, @PathVariable("loginId") int loginId) {
        String emjobId = emjobService.queryByComjobIdEmId(comjobId, loginId);
        System.out.println("emjobId: " + emjobId);
        if (emjobId != null) {  // 之前投递过
            return MapUtil.returnMap(-1);  //查找结果不为空,无法重复投递,返回-1
        }
        String comjobId_s = String.valueOf(comjobId);
        String loginId_s = String.valueOf(loginId);
        Emjob emjob = new Emjob(comjobId_s, loginId_s, "0", "0", TimeUtil.getCurrTime());
        System.out.println("emjob: " + emjob.toString());
        int res = emjobService.addEmjob(emjob);
        return MapUtil.returnMap(res);
    }

    // 获取当前职位的投递状态
    @RequestMapping("/user/getCurrStatus/{comjobId}/{loginId}")
    @ResponseBody
    public int getCurrStatus(@PathVariable("comjobId") int comjobId, @PathVariable("loginId") int loginId) {
        String emjobId = emjobService.queryByComjobIdEmId(comjobId, loginId);
        System.out.println("getCurrStatus,emjobId: " + emjobId);
        if (emjobId != null) {
            return -1;
        } else {
            return 1;
        }
    }

    // 获取当前职位的投递状态
    @RequestMapping("/user/handle/{emjobId}/{res}")
    @ResponseBody
    public Map<String, Object> handle(@PathVariable("emjobId") int emjobId, @PathVariable("res") int res) {
        // System.out.println("前端传送回来的emjobId:" + emjobId);
        // System.out.println("前端传送回来的res:" + res);
        Map<String, Object> map = MapUtil.returnMap(-1);
        int reply = emjobService.queryReplyById(emjobId);
        if (reply == 1) {
            return map;
        }
        int handle = emjobService.handle(res, emjobId);
        System.out.println("录取处理结果: " + handle);
        if (res == 1) {
            int add = comjobService.addHiredNum(emjobService.queryComjobById(emjobId));
            if (add == 1 && handle == 1) {
                map = MapUtil.returnMap(1);
            }
        }
        if (res == 0) {
            if (handle == 1) {
                map = MapUtil.returnMap(1);
            }
        }
        return map;
    }

}
