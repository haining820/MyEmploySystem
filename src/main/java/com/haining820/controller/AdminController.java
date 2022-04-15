package com.haining820.controller;


import com.haining820.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


@Controller
public class AdminController {

    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminService adminService;


}
