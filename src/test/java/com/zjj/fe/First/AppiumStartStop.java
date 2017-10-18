package com.zjj.fe.First;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumStartStop {
 Process p;
 // Set path of your node.exe file.
 // Progra~1 represents Program Files folder.
 String nodePath = "";
 // Set path of your appium.js file.
 String appiumJSPath = "/Users/JE/AppData/Local/Programs/appium-desktop/resources/app/node_modules/appium/build/lib/main.js";
 String cmd = appiumJSPath;
 AndroidDriver<WebElement> driver;

 // This method Is responsible for starting appium server.
public void appiumStart() throws IOException, InterruptedException {
        // Execute command string to start appium server.
	System.out.println("1");
	System.out.println(cmd) ;
        p = Runtime.getRuntime().exec(cmd);

        System.out.println("2");
        // Provide wait time of 10 mins to start appium server properly.
        // If face any eÏrror(Could not start a new session...) then Increase
        // this time to 15 or 20 mins.
        Thread.sleep(10000);
        if (p != null) {
            System.out.println("Appium server Is started now.");
        }
    }
//This method Is responsible for stopping appium server.
public void appiumStop() throws IOException {
    System.out.println(p);
    if (p != null) {
        p.destroy();
    }
    System.out.println("Appium server Is stopped now.");
}


public void startAppium() throws IOException, InterruptedException{
	// TODO Auto-generated method stub
	System.out.println("come here");
    appiumStop();
    appiumStart();
	
}



}
