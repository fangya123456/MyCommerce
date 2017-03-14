package com.fy.commerce.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by ya.fang on 2017/1/20.
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    private final Logger log = LogManager.getLogger(MyHttpSessionListener.class);


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("Session 被创建");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /**
        * 两种情况下会触发该事件：
         * 1.执行session.invalidate()方法时
         * 2.超过了会话最大超时时间 ，服务器就会自动销毁超时的session
         * */
        log.info("Session 被销毁");
    }

}
