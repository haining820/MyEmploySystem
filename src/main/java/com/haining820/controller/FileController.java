package com.haining820.controller;

import com.alibaba.fastjson.JSONObject;
import com.haining820.service.EmService;
import com.haining820.service.EmjobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.UUID;

@Controller
public class FileController {

    @Autowired
    @Qualifier("emServiceImpl")
    EmService emService;

    @Autowired
    @Qualifier("emjobServiceImpl")
    EmjobService emjobService;

    @RequestMapping("/user/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        String uploadFileName = file.getOriginalFilename();
        System.out.println("上传文件名: " + uploadFileName);
        // 获取当前用户登录Id
        int loginId = Integer.parseInt(request.getSession().getAttribute("userLoginId").toString());
        // 储存路径
        String path = request.getServletContext().getRealPath("/upload/" + loginId);
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        //上传文件地址
        System.out.println("上传文件保存地址：" + realPath);
        //通过CommonsMultipartFile的方法直接写文件
        String uuid = UUID.randomUUID().toString();  // 设置随机的 uuid
        String uuidName = uuid + "_" + file.getOriginalFilename();  // 防止重名设置 uuidName
        file.transferTo(new File(realPath + "/" + uuidName));
        emService.addEmFile(uuidName, loginId);
        JSONObject json = new JSONObject();
        json.put("code", "1");
        // json.put("msg", "success");
        return json.toString();
    }


    @RequestMapping(value = "/user/fileDownload/{emjobId}/{type}")
    public String fileDownload(HttpServletResponse response, HttpServletRequest request,
                               @PathVariable("emjobId") int emjobId, @PathVariable("type") int type) throws Exception {
        int loginId;
        if (type == 0) {
            // 应聘者下载自己的简历文件
            loginId = Integer.parseInt(request.getSession().getAttribute("userLoginId").toString());
        }else{
            // 招聘者统一下载应聘者文件
            loginId = emjobService.queryEmIdById(emjobId);
        }
        // 下载文件的位置
        String path = request.getServletContext().getRealPath("/upload/" + loginId);
        // 下载文件的文件名
        String fileName = emService.queryEmFileById(loginId);
        System.out.println("path:" + path);
        System.out.println("fileName:" + fileName);
        //设置response 响应头
        response.reset(); //设置页面不缓存,清空buffer
        response.setCharacterEncoding("UTF-8"); //字符编码
        response.setContentType("multipart/form-data"); //二进制传输数据
        //设置响应头
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
        File file = new File(path, fileName);
        //2、 读取文件--输入流
        InputStream input = new FileInputStream(file);
        //3、 写出文件--输出流
        OutputStream out = response.getOutputStream();
        byte[] buff = new byte[1024];
        int index = 0;
        //4、执行 写出操作
        while ((index = input.read(buff)) != -1) {
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();
        return null;
    }


}
