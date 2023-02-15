package com.lhj.shixun1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
@AutoConfigureAfter(WebMvcConfigurer.class)
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private ResourceBean resourceBean;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            registry.addResourceHandler("/static/**")
                    .addResourceLocations(ResourceUtils.FILE_URL_PREFIX +
                            resourceBean.getWindowLocation());
        }else {
            registry.addResourceHandler("/static/**")
                    .addResourceLocations(ResourceUtils.FILE_URL_PREFIX +
                            resourceBean.getLinuxLocation());
        }
    }
}
