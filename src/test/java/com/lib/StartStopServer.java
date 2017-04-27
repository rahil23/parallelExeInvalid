package com.lib;

import java.io.File;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class StartStopServer {
	
	public static AndroidDriver driver;
	public String apkPath = null;
	public String appium_node = "C:\\Program Files (x86)\\Appium\\node.exe";
	public String apppium_js = "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js";
	
	public AppiumDriverLocalService appiumService;
	
	public DesiredCapabilities cap;
	
	@Parameters({"udid","port"})
	@BeforeTest
	public void startServer(String udid , String port)  {
		
		appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(Integer.parseInt(port)).
				usingDriverExecutable(new File(appium_node)).
				withArgument(GeneralServerFlag.ROBOT_ADDRESS,udid).withAppiumJS(new File(apppium_js)).withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER,(Integer.parseInt(port)+ 10 + " ")));
		
		
		
		appiumService.start();
		
		
			}
	
	
	
	
	
	
	
	

}
