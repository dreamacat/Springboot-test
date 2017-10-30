package com.cat;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wangxiaoqiang
 * @create 2017/10/26
 **/
@Slf4j
public class SeleniumUtil {

    public static WebDriver driver = null;
    static {
        if (driver == null)  {
            String path = "/Users/wangxiaoqiang/dsc/chromedriver";
            System.setProperty("webdriver.chrome.driver",path); // 此处PATH替换为你的chromedriver所在路径
            driver =  new ChromeDriver();
        }
    }

    public static WebDriver getInstance(){
        if (driver != null) {
            return driver;
        }
        String path = "/Users/wangxiaoqiang/dsc/chromedriver";
        System.setProperty("webdriver.chrome.driver",path); // 此处PATH替换为你的chromedriver所在路径
        driver =  new ChromeDriver();
        return driver;
    }
    /**
     * 等待 sec 秒
     * @param sec
     */
    public static void waitSecond(long sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    public static void refresh() {
        driver.navigate().refresh();
    }

    public static WebElement findElementById( String id) {
        return driver.findElement(By.id(id));
    }

    public static WebElement findElementByIds( String id) {
        return driver.findElement(By.id(id));
    }


    public static WebElement findByClassName(String className) {
        return driver.findElement(By.className(className));
    }

    public static List<WebElement> findListByClassName(String className) {
        return driver.findElements(By.className(className));
    }


    public static WebElement findByXPath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }
    public static WebElement findByLinkText(String linkText) {
        return driver.findElement(By.linkText(linkText));
    }

    public static void goWeb(String url) {
        driver.get(url);
        //driver.manage().window().maximize();
    }

    public static void closeWindow() {
        try {
            Thread.sleep(10*1000);
        } catch (Exception e) {

        }
        driver.quit();
    }


}
