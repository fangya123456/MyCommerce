package com.fy.commerce.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
 * Created by ya.fang on 2017/9/15.
 */
@Component
public class RequestTemplate {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @param url : 请求url
     * @param type : 返回的数据类型
     * @param feature : 匹配数据格式
     * */
    public <T> T getForObject(String url, TypeReference<T> type, Feature feature)throws Exception{
        String stringResult = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = JSONObject.parseObject(stringResult);
        String code = jsonObject.get("code").toString();
        String message = jsonObject.get("message").toString();
        if (code.equals("200")){
            Object object = jsonObject.get("dataMap");
            return  object == null ? null : JSONObject.parseObject(object.toString(), type, feature);
        }else{
            throw new Exception(message);
        }
    }

    /**
     * @param url : 请求url
     * */
    public <T> T getForObject(String url, TypeReference<T> type)throws Exception{
        String stringResult = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = JSONObject.parseObject(stringResult);
        String code = jsonObject.get("code").toString();
        String message = jsonObject.get("message").toString();
        if (code.equals("200")){
            Object object = jsonObject.get("dataMap");
            return  object == null ? null : JSONObject.parseObject(object.toString(), type, Feature.InternFieldNames);
        }else{
            throw new Exception(message);
        }
    }



    /**
     * post请求
     * @param url : 请求url
     * @param request : 请求参数对象
     * @param type : 返回的数据类型
     * @param feature : 匹配数据格式
     * */
    public <T> T postForObject(String url, Object request,TypeReference<T> type, Feature feature) throws Exception{
        String result = restTemplate.postForObject(url,request,String.class);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String code = jsonObject.get("code").toString();
        if (code.equals("200")){
            Object object = jsonObject.get("dataMap");
            return  object == null ? null : JSONObject.parseObject(object.toString(), type, feature);
        }else{
            String message = jsonObject.get("message").toString();
            throw new Exception(message);
        }
    }


}
