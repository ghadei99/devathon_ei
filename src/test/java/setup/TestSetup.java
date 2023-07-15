package setup;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.collect.ImmutableMap;

import base.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import pages.LoginNativePage;

public class TestSetup extends BaseClass {

	// bs://b0b48ad0c0d96ee9b9d22044fb95afe881cdef29

	public static String udid = "e850222d";
	static String chromeAppPackageName = "com.android.chrome";
	static String chromeAppActivityName = "com.google.android.apps.chrome.Main";

	public static void setupChrome() throws InterruptedException, MalformedURLException {
		DesiredCapabilities des = new DesiredCapabilities();
		des.setCapability(MobileCapabilityType.DEVICE_NAME, udid);
		des.setCapability(MobileCapabilityType.UDID, udid);
		des.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		des.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		des.setCapability("enableMultiWindows", true);
		des.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		des.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, chromeAppActivityName);
		des.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		des.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		des.setCapability("chromedriverExecutable", "C:\\Users\\Chgha\\Desktop\\EI\\chromedriver.exe");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), des);
	}

	public static void setUpMindsparkNativeBS() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("device", "Oppo A96");
		capabilities.setCapability("os_version", "11.0");
		capabilities.setCapability("app", "bs://b0b48ad0c0d96ee9b9d22044fb95afe881cdef29");
		capabilities.setCapability("automationName", "UIAutomator2");
		driver = new AndroidDriver<MobileElement>(
				new URL("http://chandrakantaghad_D3y8dp:rZyLoe7udGvuwEJDAfwp@hub-cloud.browserstack.com/wd/hub"),
				capabilities);
		Thread.sleep(5000);
	}

	public static void setupChromeBS() throws InterruptedException, MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("deviceName", "Xiaomi Redmi Note 11");
		capabilities.setCapability("platformVersion", "11.0");
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("browserstack.user", "chandrakantaghad_D3y8dp");
		capabilities.setCapability("browserstack.key", "rZyLoe7udGvuwEJDAfwp");
		driver = new AndroidDriver<MobileElement>(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
	}

	public static void setUpMindsparkNative() throws MalformedURLException {
		DesiredCapabilities des = new DesiredCapabilities();
		des.setCapability(MobileCapabilityType.DEVICE_NAME, udid);
		des.setCapability(MobileCapabilityType.UDID, udid);
		des.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		des.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		des.setCapability("enableMultiWindows", true);
		des.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		des.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.mindspark.edicine.MainActivity");
		des.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mindspark.edicine");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), des);
	}
}
