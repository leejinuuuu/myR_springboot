package com.test.test.security.security_test.controller;

import com.test.test.security.security_test.model.TO.MemberTO;
import com.test.test.security.security_test.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/security_test")
public class HomeController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String homeView() {
        return "security_test_pages/home";
    }

    @GetMapping("/login")
    public String loginView() {
        return "security_test_pages/login";
    }

    @GetMapping("/signup")
    public String signupView() {
        return "security_test_pages/signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody MemberTO memberTO) {
        System.out.println(memberTO.getName());

        memberService.save(memberTO);
        return "redirect:/login";
    }

    @PreAuthorize("hasRole('ROLE_MEMBER')")
    @GetMapping("/member/info")
    public String userInfoView() {
        return "security_test_pages/user_info";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminView() {
        return "security_test_pages/admin";
    }

    @GetMapping("/denied")
    public String deniedView() {
        return "pages/denied";
    }
}