package com.haining820.controller;

import com.alibaba.fastjson.JSONObject;
import com.haining820.pojo.Com;
import com.haining820.service.ComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ComController {

    @Autowired
    @Qualifier("comServiceImpl")
    private ComService comService;

    @RequestMapping("/admin/queryComByLimit")
    @ResponseBody
    public String queryComByLimit(HttpServletRequest request,
                                  @RequestParam(value = "comName", required = false, defaultValue = "") String comName) {
        if ("".equals(comName)) {
            comName = null;
        }
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer limit = Integer.parseInt(request.getParameter("limit"));  //将String强转为int

        HashMap<String, Object> map = new HashMap<String, Object>();  //用于分页查询和搜索的map
        map.put("startIndex", (page - 1) * limit);
        map.put("pageSize", limit);
        map.put("comName", comName);
        System.out.println(map);
        System.out.println("==========================");

        List<Com> limitComList = comService.queryComByLimit(map);

        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "success");
        obj.put("count", comService.countComNum(map));
        obj.put("data", limitComList);
        // System.out.println("所有公司的数量: " + comService.countComNum());
        return obj.toString();
    }

    @RequestMapping("/edit/addCom")  //新增用户时应提前在数据库中查询新用户使用的账号, 如果重复的话则添加失败
    @ResponseBody
    public Map<String, Object> addCom(@RequestBody Com com) {
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        com.setComCreateTime(sdf.format(date));
        System.out.println("==========================");
        System.out.println(com);
        int res = comService.addCom(com);
        Map<String, Object> map = new HashMap<String, Object>();
        if (res > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping("/admin/deleteComById/{comId}")
    @ResponseBody
    public Map<String, Object> deleteComById(@PathVariable("comId") int comId) {
        int res = comService.deleteComById(comId);
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("comId=>" + comId);
        if (res == 1) {
            map.put("status", 1);
        } else if (res == 0){
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping("/edit/updateCom")
    @ResponseBody
    public Map<String, Object> updateCom(@RequestBody Com com) {
        System.out.println(com);
        int res = comService.updateCom(com);
        Map<String, Object> map = new HashMap<String, Object>();
        if (res > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

}
