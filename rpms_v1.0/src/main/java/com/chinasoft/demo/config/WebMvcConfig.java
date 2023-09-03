package com.chinasoft.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//图片绝对地址与虚拟地址映射
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("file:/g:/Mid_training/static/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("file:/g:/Mid_training/static/js/");
        registry.addResourceHandler("/images/**").addResourceLocations("file:/g:/Mid_training/static/images/");
        registry.addResourceHandler("/backup/**").addResourceLocations("file:/g:/Mid_training/static/backup/");//images
        registry.addResourceHandler("/build/**").addResourceLocations("file:/g:/Mid_training/static/build/");//images
        registry.addResourceHandler("/charge/**").addResourceLocations("file:/g:/Mid_training/static/charge/");//images
        registry.addResourceHandler("/material/**").addResourceLocations("file:/g:/Mid_training/static/material/");//images
        registry.addResourceHandler("/member/**").addResourceLocations("file:/g:/Mid_training/static/member/");//images
        registry.addResourceHandler("/owner/**").addResourceLocations("file:/g:/Mid_training/static/owner/");//images
        registry.addResourceHandler("/pay/**").addResourceLocations("file:/g:/Mid_training/static/pay/");//images
        registry.addResourceHandler("/power/**").addResourceLocations("file:/g:/Mid_training/static/power/");//images
        registry.addResourceHandler("/role/**").addResourceLocations("file:/g:/Mid_training/static/role/");//images
        registry.addResourceHandler("/room/**").addResourceLocations("file:/g:/Mid_training/static/room/");//images
        registry.addResourceHandler("/rp/**").addResourceLocations("file:/g:/Mid_training/static/rp/");//images
        registry.addResourceHandler("/type/**").addResourceLocations("file:/g:/Mid_training/static/type/");//images
        registry.addResourceHandler("/user/**").addResourceLocations("file:/g:/Mid_training/static/user/");//images
        super.addResourceHandlers(registry);
    }
}