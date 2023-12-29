package com.cao.pms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMVCconfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/emp/Elist.html").setViewName("/emp/Elist");
        registry.addViewController("/common/commons.html").setViewName("/common/commons");
        registry.addViewController("/emp/addPage.html").setViewName("/emp/addPage");
        registry.addViewController("/emp/updatePage.html").setViewName("/emp/updatePage");
        registry.addViewController("/performance/data.html").setViewName("/performance/data");
        registry.addViewController("/performance/Plist.html").setViewName("/performance/Plist");
        registry.addViewController("/department/Dlist.html").setViewName("/department/Dlist");
        registry.addViewController("/department/DupdatePage.html").setViewName("/department/DupdatePage");
        registry.addViewController("/department/DaddPage.html").setViewName("/department/DaddPage");
        registry.addViewController("/exemp/addPage.html").setViewName("/exemp/addPage");
        registry.addViewController("/exemp/ExempList.html").setViewName("/exemp/ExempList");
        registry.addViewController("/exemp/updatePage.html").setViewName("/exemp/updatePage");
        registry.addViewController("/user/updateUser.html").setViewName("/user/updateUser");

    }

    //自定义的国际化组件
    @Bean
    public LocaleResolver localeResolver(){
        return new localeResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/index.html","/","/user/login","/asserts/css/*","/asserts/js/*","/asserts/img/*");
    }
}
