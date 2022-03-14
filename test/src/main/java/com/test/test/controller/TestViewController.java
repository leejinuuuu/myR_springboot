package com.test.test.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;

import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
@Controller
public class TestViewController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        System.out.println("index");

        model.addAttribute("title", "model attribute value");

        return "content/index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(HttpServletRequest request) {
        System.out.println("home");

        return "content/home";
    }

    // 사진을 저장할 때 프로젝트 내부에 저장하면, 프로젝트가 무거워지는 단점이 존재하기에
    // 외부에 따로 파일을 만들어서 관리한다.
    // C:\Users\jinw8\Desktop/single
    String rootPath = FileSystemView.getFileSystemView().getHomeDirectory().toString();
    String basePath = rootPath + "/" + "springboot_upload";

    // @PostMapping("/single")
    // public String uploadSingle(@RequestParam("files") MultipartFile file) throws
    // Exception {
    // String filePath = basePath + "/" + file.getOriginalFilename();
    // File dest = new File(filePath);
    // file.transferTo(dest);
    // return "@{http://localhost:8000/}";
    // }

    @PostMapping({ "/single", "/multi" })
    public String uploadMulti(@RequestParam("files") List<MultipartFile> files) throws Exception {
        // 파일 업로드(여러개) 처리 부분
        for (MultipartFile file : files) {
            String originalName = file.getOriginalFilename();
            String filePath = basePath + "/" + originalName;
            File dest = new File(filePath);
            file.transferTo(dest);
        }
        return "content/index";
    }

}