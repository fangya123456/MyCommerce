package com.fy.commerce;

import com.fy.commerce.config.MyHttpSessionListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.SessionEventHttpSessionListenerAdapter;

import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ya.fang on 2017/1/9.
 */

@SpringBootApplication
@ServletComponentScan(basePackageClasses = {MyHttpSessionListener.class})
@EnableRedisHttpSession
public class Application extends SpringBootServletInitializer {

    private static Logger logger = LogManager.getLogger(Application.class);

    /**
     * Start
     */
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

