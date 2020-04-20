package com.ysg.Security;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@EnableWebSecurity
public class SecurityConfig {

    @Configuration
    public static class WebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http.cors().and()
                    .authorizeRequests().anyRequest().authenticated()
                    .and()
                    .formLogin().loginPage("/user/login")
                    .loginProcessingUrl("/user/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .permitAll()
                    .failureHandler(new AuthenticationFailureHandler() {
                        @Override
                        public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                            httpServletResponse.setContentType("application/json;charset=utf-8");
                            PrintWriter out = httpServletResponse.getWriter();
                            StringBuffer sb = new StringBuffer();
                            sb.append("{\"status\":\"error\",\"msg\":\"");
                            if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
                                sb.append("用户名或密码输入错误，登录失败!");
                            } else if (e instanceof DisabledException) {
                                sb.append("账户被禁用，登录失败，请联系管理员!");
                            } else {
                                sb.append("登录失败!");
                            }
                            sb.append("\"}");
                            out.write(sb.toString());
                            out.flush();
                            out.close();
                        }
                    }).successHandler(new AuthenticationSuccessHandler() {
                @Override
                public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                    httpServletResponse.setContentType("application/json;charset=UTF-8");
                    ObjectMapper objectMapper = new ObjectMapper();
                    httpServletResponse.getWriter().write(objectMapper.writeValueAsString(authentication));
                }
            }).and().logout().permitAll().and().csrf().disable();
        }
    }


    @Autowired
    private MyUserDetailsService userDetailsService;
    /**
     * 初始验证登录  从内存中取密码
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}
