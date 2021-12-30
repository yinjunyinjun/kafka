package com.mycompany.kafka.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity  //启动web安全性
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UmsAdminService bankAdminInfoService;
//    @Autowired
//    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
//    @Autowired
//    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Autowired
    private ControllerLogFilter controllerLogFilter;


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()// 由于使用的是JWT，我们这里不需要csrf
                .disable()
                .sessionManagement()// 基于token，所以不需要session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .headers().frameOptions().disable().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/**/**.jpg",
                        "/bootstrap/**",
                        "/swagger-resources/**",
                        "/v2/api-docs/**",
                        "/webjars/springfox-swagger-ui/**",
                        "/**/**.ttf",
                        "/**/**/**.woff2",
                        "/example/treeRole.json"
                )
                .permitAll()
                .antMatchers("/api/server/admin/login", "/api/server/admin/logout", "/api/server/admin/getVerify","/api/web/visit/*", "/api/server/admin/upload/*","/**")// 对登录注册要允许匿名访问
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
                .permitAll()
                .anyRequest()// 除上面外的所有请求全部需要鉴权认证
                .authenticated()
                .and()
                .headers().cacheControl().disable();
      //  httpSecurity.addFilterBefore(controllerLogFilter, UsernamePasswordAuthenticationFilter.class);
     //   httpSecurity.addFilterAfter(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        //添加自定义未授权和未登录结果返回
//        httpSecurity.exceptionHandling()
//                .accessDeniedHandler(restfulAccessDeniedHandler)
//                .authenticationEntryPoint(restAuthenticationEntryPoint);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        //获取登录用户信息
//        return username -> {
//            UmsAdminInfo umsAdminInfo = bankAdminInfoService.getBankAdminInfo(username);
//            if (umsAdminInfo != null) {
//                List<UmsPermission> permissionList = null;
//                return new AdminUserDetails(umsAdminInfo,permissionList);
//            }
//            throw new UsernameNotFoundException("用户名或密码错误");
//        };
//    }
//
//    @Bean
//    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
//        return new JwtAuthenticationTokenFilter();
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
}
