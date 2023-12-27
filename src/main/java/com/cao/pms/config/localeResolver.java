package com.cao.pms.config;

import com.mysql.cj.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//地区解析器
public class localeResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lan = request.getParameter("l");
        Locale locale = Locale.getDefault();//默认

        if(!StringUtils.isNullOrEmpty(lan)){
            //zh_CN
            String[] split = lan.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
