package com.zjj.fe.First;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;  
import org.testng.Assert;  
import org.testng.annotations.AfterClass;  
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;  
public class NewTest {  
	
    private  AndroidDriver<WebElement> driver;

    AppiumStartStop appiumServer;
    @BeforeClass
    public void setUp() throws Exception {
        // set up appium
        /*File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "../../../apps/ABC");
        File app = new File(appDir, "ABC.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Samsung Galaxy S6");
        capabilities.setCapability("platformVersion", "5.0.0");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.tiejing.fe");
        capabilities.setCapability("appActivity", ".business.view.login.LoginActivity_");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);*/
    	appiumServer = new AppiumStartStop();
        //appiumServer.startAppium();

    	DesiredCapabilities capabilities = new DesiredCapabilities();  
        capabilities.setCapability("deviceName","Samsung Galaxy S6");  
        capabilities.setCapability("automationName","Appium");  
        capabilities.setCapability("platformName","Android");  
        capabilities.setCapability("platformVersion",5);  
          
       //配置测试apk  
        capabilities.setCapability("appPackage", "com.tiejing.fe");  
        capabilities.setCapability("appActivity", ".business.view.login.LoginActivity_");  
        capabilities.setCapability("sessionOverride", true);    //每次启动时覆盖session，否则第二次后运行会报错不能新建session  
        capabilities.setCapability("unicodeKeyboard", true);    //设置键盘  
        capabilities.setCapability("resetKeyboard", false);     //设置默认键盘为appium的键盘  
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);  
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    
    @Test
    public void addContact() throws InterruptedException{
    	
    	WebElement username = driver.findElement(By
                .id("com.tiejing.fe:id/user_name"));
        WebElement password = driver.findElement(By
                .id("com.tiejing.fe:id/user_pwd"));

        username.sendKeys("18221981214");
        password.sendKeys("123456");

        //微信登录
        //driver.findElement(By.id("com.tiejing.fe:id/connect_with_wechat")).click();
        String s = driver.findElement(By.id("com.tiejing.fe:id/user_login")).getText() ;
        System.out.println(s+"lalala");
        //点击登录
        driver.findElement(By.id("com.tiejing.fe:id/user_login")).click();
        
        Thread.sleep(5000);
       
        //关闭签到
        driver.findElement(By.id("com.tiejing.fe:id/activities_close")).click();
        
        Thread.sleep(3000);
        
        driver.findElement(By.id("com.tiejing.fe:id/activities_close")).click();
        
        Thread.sleep(3000);
        
        driver.findElement(By.id("com.tiejing.fe:id/tv_cancel")).click();
        
        Thread.sleep(3000);
        
        //点击头像
        driver.findElement(By.id("com.tiejing.fe:id/userAvatar")).click();
        
        Thread.sleep(5000);
        
        String a = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView")).getText() ;
        System.out.println(a+"嘟嘟噜");
        Thread.sleep(3000);
    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView")).click();
    	Thread.sleep(3000);
        /*//点击天梯排行
        driver.findElement(By.id("com.tiejing.fe:id/my_info_rank")).click();
        
        Thread.sleep(5000);
        
        swipeToDown(driver);
        
        //返回
        driver.findElement(By.id("com.tiejing.fe:id/back")).click();
        
        //兑换记录
        driver.findElement(By.id("com.tiejing.fe:id/user_duihuan_lin")).click();
        
        //返回
        driver.findElement(By.id("com.tiejing.fe:id/back")).click();
        
        //收支记录
        driver.findElement(By.id("com.tiejing.fe:id/user_jiaoyi_lin")).click();
        
        //返回
        driver.findElement(By.id("com.tiejing.fe:id/back")).click();
        
        //常见问题
        driver.findElement(By.id("com.tiejing.fe:id/user_question_lin")).click();
        
        //返回
        driver.findElement(By.id("com.tiejing.fe:id/back")).click();
        
        //规则评分
        driver.findElement(By.id("com.tiejing.fe:id/user_rule_lin")).click();
        
        //返回
        driver.findElement(By.id("com.tiejing.fe:id/back")).click();
        
        //返回
        driver.findElement(By.id("com.tiejing.fe:id/back")).click();
        
        //猜输赢
        driver.findElement(By.id("com.tiejing.fe:id/btn_guess")).click();
        
        //猜输赢记录
        driver.findElement(By.id("com.tiejing.fe:id/btn_history")).click();
        
        driver.findElement(By.name("待开奖")).click();
        
        driver.findElement(By.name("中奖")).click();
        
        //返回
        driver.findElement(By.id("com.tiejing.fe:id/back")).click();
        
        //返回
        driver.findElement(By.id("com.tiejing.fe:id/back")).click();
        
        //范特西电竞
        driver.findElement(By.id("com.tiejing.fe:id/game_home_manager")).click();
        
        driver.findElement(By.id("com.tiejing.fe:id/guide_btn1")).click();
        
        Thread.sleep(5000);
        
        driver.findElement(By.id("com.tiejing.fe:id/guide_btn2")).click();
        
        driver.findElement(By.name("我的竞赛")).click();
        
        driver.findElement(By.name("进行中")).click();
        
        driver.findElement(By.name("已结束")).click();*/

    }
    @Test
    public void addContact1() throws InterruptedException{
    	
    	/*String a = driver.findElement(By.name("收支记录")).getText() ;
        System.out.println(a+"嘟嘟噜");
        Thread.sleep(3000);
    	driver.findElement(By.name("收支记录")).click();
    	Thread.sleep(3000);*/
    }
    //下拉加载
    public static void swipeToDown(AndroidDriver<WebElement> driver) throws InterruptedException {  
        int width = driver.manage().window().getSize().width;  
        int height = driver.manage().window().getSize().height;  
       
        for (int i = 0; i < 22; i++) {  
        	driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, 500); 
        	Thread.sleep(1000);
        }  
    }

}  
