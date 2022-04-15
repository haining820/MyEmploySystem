package com.haining820.controller;

import com.alibaba.fastjson.JSONObject;
import com.haining820.pojo.Analysis;
import com.haining820.pojo.Com;
import com.haining820.pojo.Comjob;
import com.haining820.pojo.Em;
import com.haining820.service.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    @Qualifier("loginServiceImpl")
    private LoginService loginService;

    @Autowired
    @Qualifier("comServiceImpl")
    private ComService comService;

    @Autowired
    @Qualifier("emServiceImpl")
    private EmService emService;

    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminService adminService;

    @Autowired
    @Qualifier("comjobServiceImpl")
    private ComjobService comjobService;

    @Autowired
    @Qualifier("jobServiceImpl")
    private JobService jobService;

    @RequestMapping("/user/login")
    @ResponseBody
    public Map<String, Object> login(HttpServletResponse response, @RequestBody Map<String, Object> paramsMap,
                                     HttpSession session) {
        response.setCharacterEncoding("utf-8");
        int accountNum = Integer.parseInt(paramsMap.get("loginAccountNum").toString());
        String password = paramsMap.get("loginPassword").toString();
        String selectedComId = loginService.verityCom(accountNum, password);
        String selectedEmId = loginService.verifyEm(accountNum, password);
        String selectedAdminId = loginService.verityAdmin(accountNum, password);
        Map<String, Object> map = new HashMap<String, Object>();
        if (selectedComId == null && selectedEmId == null && selectedAdminId == null) {
            System.out.println("登录失败!");
            map.put("code", 0);
        } else {
            if (selectedComId != null && selectedEmId == null && selectedAdminId == null) {
                System.out.println("登录成功! 身份:企业用户");
                map.put("code", 1);
                int comId = Integer.parseInt(selectedComId);
                map.put("loginId", comId);

                session.setAttribute("userType", "com");
                session.setAttribute("username", comService.queryComUserNameById(comId));
                session.setAttribute("userLoginId", selectedComId);

            } else if (selectedEmId != null && selectedAdminId == null && selectedComId == null) {
                System.out.println("登录成功! 身份:普通用户");
                map.put("code", 2);
                int emId = Integer.parseInt(selectedEmId);
                map.put("loginId", emId);

                session.setAttribute("userType", "em");
                session.setAttribute("username", emService.queryEmUsernameById(emId));
                session.setAttribute("userLoginId", selectedEmId);
                System.out.println("已向session中放入userLoginId:" + selectedEmId);


            } else if (selectedAdminId != null && selectedComId == null && selectedEmId == null) {
                System.out.println("登录成功! 身份:管理员");
                map.put("code", 3);
                int adminId = Integer.parseInt(selectedAdminId);
                map.put("loginId", adminId);

                session.setAttribute("userType", "admin");
                session.setAttribute("username", adminService.queryAdminNameById(adminId));
                session.setAttribute("userLoginId", selectedAdminId);


            } else {
                System.out.println("登录失败!");
                map.put("code", -1);
            }
        }
        System.out.println("===================");
        System.out.println("账号=>" + accountNum);
        System.out.println("密码=>" + password);
        System.out.println("===================");
        return map;
    }

    @RequestMapping("/user/getCurrUserType")
    @ResponseBody
    public String getCurrUserType(HttpServletRequest request) {
        String currUserType = (String) request.getSession().getAttribute("userType");
        System.out.println("controller中的userType:" + currUserType);
        return currUserType;
    }

    @RequestMapping("/user/getCurrUsername")
    @ResponseBody
    public String getCurrUserName(HttpServletRequest request) {
        String currUsername = (String) request.getSession().getAttribute("username");
        System.out.println("controller中的currUsername:" + currUsername);
        return currUsername;
    }

    @RequestMapping("/user/getCurrLoginId")
    @ResponseBody
    public String getCurrLoginId(HttpServletRequest request) {
        String currLoginId = (String) request.getSession().getAttribute("userLoginId");
        System.out.println("controller中的currLoginId:" + currLoginId);
        return currLoginId;
    }

    @RequestMapping("/user/getFileStatus")
    @ResponseBody
    public int getFileStatus(HttpServletRequest request) {
        int currLoginId = Integer.parseInt(request.getSession().getAttribute("userLoginId").toString());
        String emFile = emService.queryEmFileById(currLoginId);
        if (emFile == null || "".equals(emFile)) {
            return -1;
        } else {
            return 1;
        }
    }

    @RequestMapping("/user/logout")
    @ResponseBody
    public void logout(HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate();
        response.sendRedirect("/main.html");
    }

    @RequestMapping("/user/showComInfo")
    @ResponseBody
    public String showComInfo(HttpServletRequest request) {
        int comId = Integer.parseInt(request.getSession().getAttribute("userLoginId").toString());
        System.out.println("LoginController中showComInfo中的comId: " + comId);
        Com comInfo = comService.queryComById(comId);
        List<Com> comList = new ArrayList<Com>();
        comList.add(comInfo);
        System.out.println("==============");
        System.out.println(comInfo);
        JSONObject json = new JSONObject();
        json.put("data", comInfo);
        return json.toString();
    }

    @RequestMapping("/user/showEmInfo")
    @ResponseBody
    public String showEmInfo(HttpServletRequest request) {
        int emId = Integer.parseInt(request.getSession().getAttribute("userLoginId").toString());
        System.out.println("LoginController中showEmInfo中的emId: " + emId);
        Em emInfo = emService.queryEmById(emId);
        List<Em> emList = new ArrayList<Em>();
        emList.add(emInfo);
        System.out.println("==============");
        System.out.println(emInfo);
        JSONObject json = new JSONObject();
        json.put("data", emInfo);
        return json.toString();
    }

    @RequestMapping("/user/toInfoEdit")
    public String toInfoEdit(HttpServletRequest request) {
        String userType = (String) request.getSession().getAttribute("userType");
        String userName = (String) request.getSession().getAttribute("userName");
        String userLoginId = (String) request.getSession().getAttribute("userLoginId");
        System.out.println("Controller中Session储存的userType:" + userType);
        System.out.println("Controller中Session储存的userName:" + userName);
        System.out.println("Controller中Session储存的loginId:" + userLoginId);
        if ("com".equals(userType)) {
            // return "comInfoEdit";
            return "comIndex";
        }
        if ("em".equals(userType)) {
            return "emIndex";
        }
        if ("admin".equals(userType)) {
            return "adminIndex";
        }
        return "404";
    }

    @RequestMapping("/user/recommend")
    @ResponseBody
    public String recommend() {
        List<Analysis> comjobList = comjobService.queryAll();
        int max, hired;
        double tempRate, maxRate = 1;
        int maxRateId = 0;
        for (Analysis analysis : comjobList) {
            max = analysis.getHireMaxNum();
            hired = analysis.getHiredNum();
            tempRate = (double) hired / max;
            analysis.setRate(tempRate);
            maxRate = Math.min(tempRate, maxRate);
            if (maxRate == tempRate) {
                maxRateId = analysis.getComjobId();
            }
        }
        Comjob recommendComjob = comjobService.queryComjobById(maxRateId);
        recommendComjob.setComId(comService.queryComNameById(Integer.parseInt(recommendComjob.getComId())));
        recommendComjob.setJobId(jobService.queryJobNameById(Integer.parseInt(recommendComjob.getJobId())));
        System.out.println("当前最紧缺:"+recommendComjob);
        JSONObject json = new JSONObject();
        json.put("res", recommendComjob);
        return json.toString();
    }
}
