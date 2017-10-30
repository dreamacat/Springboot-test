package com.cat.controller;

import com.cat.selenium.JdPay;
import com.cat.utils.View;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wangxiaoqiang
 * @create 2017/10/28
 **/
@RequestMapping("/kill")
@View
@Api(value = "killSec", description = "jd_api")
public class JdKillSecController {

    @RequestMapping(value={"/buyGoods"}, method= RequestMethod.POST)
    @ApiOperation(value="支付 ", notes="进入结算页")
    public Object buyGoods(@ApiParam(required=true, name="beginTime", value="开始时间") @RequestParam(name = "beginTime") String beginTime,
                           @ApiParam(required=false, name="isTest", value="测试时，无需填写") @RequestParam(name = "isTest", required = false) String isTest
                          ){
        JdPay.funcPay(beginTime, StringUtils.isEmpty(isTest));
        return "loveLy cat";
    }

    @RequestMapping(value={"/buyGoodsNoRefresh"}, method= RequestMethod.POST)
    @ApiOperation(value="支付 ", notes="进入结算页")
    public Object buyGoodsNoRefresh(@ApiParam(required=true, name="beginTime", value="开始时间") @RequestParam(name = "beginTime") String beginTime,
                           @ApiParam(required=false, name="isTest", value="测试时，无需填写") @RequestParam(name = "isTest", required = false) String isTest
                          ){
        JdPay.funcPayNoRefresh(beginTime, StringUtils.isEmpty(isTest));
        return "loveLy cat";
    }
}
