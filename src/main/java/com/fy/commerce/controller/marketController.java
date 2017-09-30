package com.fy.commerce.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.fy.commerce.utils.JsonResult;
import com.fy.commerce.utils.RequestTemplate;
import com.fy.commerce.utils.URLConstant;
import com.fy.commerce.vo.market.MarketDetailInfoVo;
import com.fy.commerce.vo.market.MarketShowListVo;
import com.fy.commerce.vo.market.ReceiverInfoVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by ya.fang on 2017/9/14.
 */
@Controller
@RequestMapping("market")
public class marketController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RequestTemplate requestUtil;

    /**
     * 根据城市定位信息查询商场分页列表
     * @param pageNo : 页码
     * @param pageSize : 每页数量
     * @param appId : appId
     * @param bizId :业务号，唯一
     * @param location : 经纬度坐标 格式(112.34,121.43)
     * @param tags : 城市标签 格式(city_id:310100)
     *
     * */
    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public JsonResult getMarketShowListInfo(HttpServletRequest request, Model model,
                                            @Param("pageNo") Integer pageNo,
                                            @Param("pageSize") Integer pageSize,
                                            @Param("appId") String appId,
                                            @Param("bizId") String bizId,
                                            @Param("location")String location,
                                            @Param("tags") String tags)throws Exception{
        String url = URLConstant.SEARCH_MARKET_INFO_DOMAIN + "?pageNo=" + pageNo + "&pageSize=" + pageSize
                + "&appId=" + appId + "&bizId=" + bizId + "&location=" + location + "&tags=" + tags;
        List<MarketShowListVo> list = requestUtil.getForObject(url, new TypeReference<List<MarketShowListVo>>(){});
        MarketShowListVo marketShowListVo = list.get(0);
        return new JsonResult(marketShowListVo);
    }


    /**
     * 根据OMS卖场ID获取商场详情
     * @param uuid : OMS卖场Id
     * */
    @ResponseBody
    @RequestMapping(value = "/getMarketInfo/{uuid}", method = RequestMethod.GET)
    public JsonResult getMarketShowList(@PathVariable("uuid") String uuid, HttpServletRequest request, Model model)throws Exception{
        String url = URLConstant.API_LONGGUO_MARKET_INFO_DOMAIN + "/getMarketInfo/" + uuid;
        List<MarketShowListVo> list = requestUtil.getForObject(url, new TypeReference<List<MarketShowListVo>>(){});
        MarketShowListVo marketShowListVo = list.get(0);
        return new JsonResult(marketShowListVo);
    }

    /**
     * 根据OMS卖场ID以及商场经纬度获取商场详情
     * @param uuid : OMS卖场Id
     * */
    @ResponseBody
    @RequestMapping(value = "/getOmsMarketInfoORMByUuid/{uuid}/{lon}/{lat}", method = RequestMethod.GET)
    public JsonResult getOmsMarketInfoORMByUuid(HttpServletRequest request, Model model,
                                                @PathVariable("uuid") String uuid,
                                                @PathVariable("lon") String lon,
                                                @PathVariable("lat") String lat
                                                )throws Exception{
        String url = URLConstant.API_LONGGUO_MARKET_INFO_DOMAIN + "/getOmsMarketInfoORMByUuid/" + uuid + "/" + lon + "/" +lat;
        MarketDetailInfoVo marketDetailInfoVo = requestUtil.getForObject(url, new TypeReference<MarketDetailInfoVo>(){});
        return new JsonResult(marketDetailInfoVo);
    }

}
