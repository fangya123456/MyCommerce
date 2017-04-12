package com.fy.commerce.controller;

import com.fy.commerce.model.Product;
import com.fy.commerce.service.api.IProductService;
import com.fy.commerce.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ya.fang on 2017/1/16.
 */
@Controller
@RequestMapping("/product")
@Api(value = "商品信息", description = "商品信息控制")
public class productController {

    private  static Logger log = LogManager.getLogger(productController.class);
    @Autowired
    private IProductService productService;


    @ResponseBody
    @RequestMapping(value = "/queryAllCategoryInfo", method = RequestMethod.GET)
    @ApiOperation(value = "获取商品分类信息", notes = "获取商品分类接口")
    public Result queryAllCategoryInfo(Model model){
        return new Result(200, productService.getCategoryAndCategorySecondInfo());
    }

    @ResponseBody
    @RequestMapping(value ="/queryHotProductInfo", method = RequestMethod.GET)
    @ApiOperation(value = "获取热门商品信息", notes = "获取热门商品信息接口")
    public Result queryHotProductInfo(Model model, HttpServletRequest request){
        log.info("获取热么们商品信息");
        List<Product> list = productService.getHotProductInfoByPage(1,10);
        return new Result(200, list);
    }

    @ResponseBody
    @RequestMapping(value ="/queryProductInfoByPage", method = RequestMethod.GET)
    @ApiOperation(value = "获取商品分页信息", notes = "获取商品分页信息接口")
    public Result queryAllProductInfo(Model model, HttpServletRequest request){

        return new Result(200, productService.getCategoryAndCategorySecondInfo());
    }

}
