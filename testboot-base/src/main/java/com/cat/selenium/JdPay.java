package com.cat.selenium;

import com.cat.SeleniumUtil;
import com.cat.constant.Constant;
import com.cat.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author wangxiaoqiang
 * @create 2017/10/26
 **/
@Slf4j
public class JdPay {

    public  static void  search(WebDriver driver) {
        String id = "index_newkeyword";

        WebElement input = SeleniumUtil.findElementById("index_newkeyword");
        input.sendKeys("乐视电视");

        WebElement btn = SeleniumUtil.findElementById("index_search_submit");
        btn.click();
    }

    public  static void  login(String uname){
        String pwd = "wang2317289";
        SeleniumUtil.waitSecond(10);

        WebElement loginLink = SeleniumUtil.findElementById("index_searchLogin");
        loginLink.click();

        SeleniumUtil.waitSecond(5);

        WebElement username = SeleniumUtil.findElementById("username");
        username.clear();
        WebElement password = SeleniumUtil.findElementById("password");
        password.clear();
        username.sendKeys(uname);
        password.sendKeys(pwd);

        SeleniumUtil.waitSecond(2);

        WebElement submit = SeleniumUtil.findElementById("loginBtn");

        submit.click();
    }

    public static void scanCart() {
        SeleniumUtil.waitSecond(10);
        List<WebElement> carts = SeleniumUtil.findListByClassName("bar-img");
        System.out.println("元素个数：" + carts.size());
        if (!CollectionUtils.isEmpty(carts)) {
            WebElement cart = carts.get(3);

            cart.click();
        }
    }

    public static void closePopUp() {
        SeleniumUtil.waitSecond(10);
        WebElement visit = SeleniumUtil.findElementById("pcprompt-viewpc");
        visit.click();
    }

    public static void closePopUp3() {
        log.info("关闭结算页图层，1，时间："+ DateUtil.now());

        SeleniumUtil.waitSecond(10);
        try {
            log.info("关闭结算页图层，2，时间："+ DateUtil.now());
            Thread.sleep(95);
        }catch (Exception e) {

        }
        log.info("关闭结算页图层，4，时间："+ DateUtil.now());
        WebElement visit = SeleniumUtil.findElementById("pcprompt-viewpc");
        log.info("关闭结算页图层，5，时间："+ DateUtil.now());
        visit.click();
        log.info("关闭结算页图层，6，时间："+ DateUtil.now());
    }

    public static void toPay() {

        SeleniumUtil.waitSecond(10);
        WebElement payBtn = SeleniumUtil.findElementById("totalNum");
        payBtn.click();
    }


    public static void pay() {
        SeleniumUtil.waitSecond(10);
        WebElement payBtn = SeleniumUtil.findElementById("btnPayOnLine");

        payBtn.click();
    }
    public static void refreshPage() {
        SeleniumUtil.refresh();
    }

    public static void waitTimeUp(String timeStr){

        long beginTime = DateUtil.parse(timeStr, DateUtil.DEFAULT_DATE_TIME).getTime();

        while (!DateUtil.isExceedTargetByMillSec(beginTime ,900)) {
            ;
        }

        log.info("活动开始，刷新页面时间："+ DateUtil.format(new Date(System.currentTimeMillis()), DateUtil.DEFAULT_DATE_TIME));
        log.info("活动开始时间："+ timeStr);
    }

    public static void waitTimeUpNoRefresh(String timeStr){

        long beginTime = DateUtil.parse(timeStr, DateUtil.DEFAULT_DATE_TIME).getTime();

        while (!DateUtil.isExceedTargetByMillSec(beginTime ,10)) {
            ;
        }

        log.info("活动开始");
    }


    public static void funcPay(String beginTime, boolean isTest) {

        String uname = Constant.TEST1;
        String url = Constant.JD_URL;


        SeleniumUtil.goWeb(url);
        login(uname);
        scanCart();
        log.info("进入购物车，时间："+ DateUtil.now());
        closePopUp();
        log.info("关闭购物车图层，时间："+ DateUtil.now());

        waitTimeUp(beginTime);
        log.info("等待时间结束，最后一次刷新页面，时间："+ DateUtil.now());
        refreshPage();
        log.info("页面刷新成功，时间："+ DateUtil.now());
        closePopUp();
        log.info("最后一次关闭购物车图层，时间："+ DateUtil.now());
        toPay();
        log.info("点击结算，进入结算页面，时间："+ DateUtil.now());
        closePopUp3();
        log.info("关闭结算页图层，时间："+ DateUtil.now());
        if (!isTest) {
            pay();
        }
        close();

    }

    public static void funcPayNoRefresh(String beginTime, boolean isTest) {

        String uname = Constant.TEST1;
        String url = Constant.JD_URL;


        SeleniumUtil.goWeb(url);
        login(uname);
        scanCart();
        log.info("进入购物车，时间："+ DateUtil.now());
        closePopUp();
        log.info("关闭购物车图层，时间："+ DateUtil.now());

        waitTimeUpNoRefresh(beginTime);
        toPay();
        log.info("点击结算，进入结算页面，时间："+ DateUtil.now());
        closePopUp3();
        log.info("关闭结算页图层，时间："+ DateUtil.now());
        if (!isTest) {
            pay();
            log.info("在线支付成功,时间");
        }
        close();

    }

    public static void close(){
        SeleniumUtil.closeWindow();
    }

    public static void main(String[] args) {
        String begin = "2017-10-29 14:12:00";
        funcPayNoRefresh(begin, true);
//        funcPay(begin, true);
    }

}
