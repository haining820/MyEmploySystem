package com.haining820.controller;

import com.alibaba.fastjson.JSONObject;
import com.haining820.pojo.Em;
import com.haining820.service.EmService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmController {

    @Autowired
    @Qualifier("emServiceImpl")
    private EmService emService;

    @RequestMapping("/admin/queryEmByLimit")
    @ResponseBody
    public String queryEmByLimit(HttpServletRequest request,
                                 @RequestParam(value = "emName", required = false, defaultValue = "") String emName) {
        if ("".equals(emName)) {
            emName = null;
        }
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer limit = Integer.parseInt(request.getParameter("limit"));

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex", (page - 1) * limit);
        map.put("pageSize", limit);
        map.put("emName", emName);
        System.out.println(map);
        System.out.println("==========================");

        List<Em> limitEmList = emService.queryEmByLimit(map);

        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "success");
        obj.put("count", emService.countEmNum(map));
        obj.put("data", limitEmList);
        return obj.toString();
    }

    @RequestMapping("/edit/addEm")
    @ResponseBody
    public Map<String, Object> addEm(@RequestBody Em em) {
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();// 获取当前时间
        em.setEmCreateTime(sdf.format(date));
        System.out.println("==========================");
        System.out.println(em);
        int res = emService.addEm(em);
        Map<String, Object> map = new HashMap<String, Object>();
        if (res > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping("/admin/deleteEmById/{emId}")
    @ResponseBody
    public Map<String, Object> deleteEmById(@PathVariable("emId") int emId) {
        int res = emService.deleteEmById(emId);
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("delete emId=>" + emId);
        if (res > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping("/edit/updateEm")
    @ResponseBody
    public Map<String, Object> updateEm(@RequestBody Em em) {
        int res = emService.updateEm(em);
        Map<String, Object> map = new HashMap<String, Object>();
        if (res > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }


}

