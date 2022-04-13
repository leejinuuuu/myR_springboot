package com.test.test.config;

import com.test.test.security.security_test.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class JavaConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MemberService memberService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 비밀번호 암/복호화
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // FilterChainProxy 생성
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and()
                .csrf().disable();

        http.authorizeRequests()
                .antMatchers("/member/**").authenticated()
                // 요청 URL 경로 패턴 지정, 인증된 유저만 접근 허용
                .antMatchers("/admin/**").authenticated()
                .antMatchers("/**").permitAll();
        // 모든 유저 접근 허용

        http.formLogin()
                .loginPage("/login")
                // 로그인 인증 경로 등록
                .defaultSuccessUrl("/")
                // 로그인 인증 성공시 이동하는 페이지 등록
                .permitAll();

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                // 로그아웃 경로 지정
                .logoutSuccessUrl("/login")
                // 로그아웃 성공시 이동 경로 등록
                .invalidateHttpSession(true);
        // 로그아웃 성공시 세션 제거

        http.exceptionHandling()
                .accessDeniedPage("/denied");
        // 권한이 없는 사용자가 접근했을 때의 이동 경로 등록
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 사용자 인증 담당
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }
}
