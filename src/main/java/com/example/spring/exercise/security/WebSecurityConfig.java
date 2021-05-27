package com.example.spring.exercise.security;



import com.example.spring.exercise.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import javax.swing.*;


/*
WebSecurityConfig类说明：
WebSecurityConfig类使用@EnableWebSecurity注解来启用Spring Security的web安全支持，并提供Spring MVC集成。
它还继承了WebSecurityConfigurerAdapter，并重写了它的一些方法，以设置web安全配置的一些细节。
configure(HttpSecurity)方法定义了哪些URL路径应该被保护，哪些不被保护。具体来说，/和/home路径被配置为不需要任何身份验证。所有其他路径都必须经过身份验证。
当用户成功登录时，他们会被重定向到之前请求的需要身份验证的页面。有一个自定义/login页面(由loginPage()指定)，每个人都可以查看它。
userDetailsService()方法使用单个用户设置内存中的用户存储。该用户被赋予用户名“user”、密码“p”和角色“USER”。
*/


@Configuration //@Configuration声明当前类是一个配置类，相当于 Spring 中的一个 XML 文件
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final static Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.info("enter configure");
        http
                .authorizeRequests()
                    //无需登录的url
                    .antMatchers("/config/*", "/home/*", "/user/*","/user/testLogin/*").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login").permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

    @Bean //@Bean作用在方法上，声明当前方法的返回值是一个 Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        LOGGER.info("enter userDetailsService");
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("p")
                        .roles("USER")
                        .build();
        UserDetails user2 =
                User.withDefaultPasswordEncoder()
                        .username("user2")
                        .password("p")
                        .roles("USER2")
                        .build();
        return new InMemoryUserDetailsManager(user, user2);
    }
}
