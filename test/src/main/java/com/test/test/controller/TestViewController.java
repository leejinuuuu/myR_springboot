package com.test.test.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.test.test.Global;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
@Controller
public class TestViewController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "model attribute value");
        return "content/index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(HttpServletRequest request) {
        return "content/home";
    }

    @PostMapping({ "/uploads" })
    public String uploadFile(@RequestParam("files") List<MultipartFile> files) throws Exception {
        // 파일 업로드(여러개) 처리 부분
        for (MultipartFile file : files) {
            String originalName = file.getOriginalFilename();
            String filePath = Global.basePath + "/" + originalName;
            File dest = new File(filePath);
            file.transferTo(dest);
        }
        return "content/index";
    }

    @PostMapping({ "/multi" })
    public String uploadMulti(
            @RequestParam("files") List<MultipartFile> files,
            @RequestParam("data0") String data0,
            @RequestParam("data1") String data1,
            @RequestParam("data2") String data2) throws Exception {
        // 파일 업로드(여러개) 처리 부분
        for (MultipartFile file : files) {
            String originalName = file.getOriginalFilename();
            String filePath = Global.basePath + "/" + originalName;
            String extension = originalName.substring(originalName.length() - 4, originalName.length());

            int i = 1;
            String fileName = filePath;

            while (new File(filePath).exists()) {
                filePath = fileName.substring(0, fileName.length() - 4).concat("(" + i + ")").concat(extension);
                i++;
            }

            File dest = new File(filePath);
            file.transferTo(dest);
        }

        return "content/index";
    }

}