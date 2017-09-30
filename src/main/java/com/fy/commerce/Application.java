package com.fy.commerce;

import com.fy.commerce.config.MyHttpSessionListener;
import com.fy.commerce.config.MyInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.SessionEventHttpSessionListenerAdapter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ya.fang on 2017/1/9.
 */

@SpringBootApplication
@ServletComponentScan(basePackageClasses = {MyHttpSessionListener.class})
@EnableRedisHttpSession
public class Application extends WebMvcConfigurerAdapter{
    private static Logger logger = LogManager.getLogger(Application.class);
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
        logger.info("====SpringBoot Start Success====");
    }


    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(Application.class);
    }

    /**
     * 配置拦截器
     * @author lance
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("addInterceptor");
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/*");
        super.addInterceptors(registry);
    }

    @Bean
    public SessionEventHttpSessionListenerAdapter sessionEventHttpSessionListenerAdapter(){

        List<HttpSessionListener> list = new ArrayList<>();
        list.add(new MyHttpSessionListener());
        return new SessionEventHttpSessionListenerAdapter(list);
    }

    @Autowired
    private RestTemplateBuilder builder;

    // 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }
}

/*
public class Application extends SpringBootServletInitializer{

    private static Logger logger = LogManager.getLogger(Application.class);

    */
/*

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
        logger.info("====SpringBoot Start Success====");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(Application.class);
    }
    @Bean
    public SessionEventHttpSessionListenerAdapter sessionEventHttpSessionListenerAdapter(){

        List<HttpSessionListener> list = new ArrayList<>();
        list.add(new MyHttpSessionListener());
        return new SessionEventHttpSessionListenerAdapter(list);
    }
}

*/
