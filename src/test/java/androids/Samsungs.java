package androids;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import pages.LoginNativePage;
import pages.LoginScreen;
import pages.LoginWebPage;

//optionIndex0
//optionIndex1
//optionIndex1

public class Samsungs {
	public static AppiumDriver<MobileElement> driver;
	static List<String> answers = new ArrayList<String>();
	// App1 capabilities
	static String chromeAppPackageName = "com.android.chrome";
	static String chromeAppActivityName = "com.google.android.apps.chrome.Main";

	// App2 capabilities
	static String msAppPackageName = "com.mindspark.edicine";
	static String msAppActivityName = "com.mindspark.edicine.MainActivity";

	// credentials
	static String teacherUserName = "demo1.1500", teacherPassword = "12345", studentUser = "jissa.varghese",
			worksheetName = "automation5";
	static int numberOfQuestion = 6;

	public static void main(String[] args) throws Exception {
//		setup();
//		assignHomeWork(driver);
//		assing(driver);
		setNativeAgain();
		nativeApplication(driver);
//		nativeApp(driver);
	}

	public static void setNativeAgain() throws MalformedURLException {
		DesiredCapabilities des = new DesiredCapabilities();
		des.setCapability(MobileCapabilityType.DEVICE_NAME, "e850222d");
		des.setCapability(MobileCapabilityType.UDID, "e850222d");
		des.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		des.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		des.setCapability("enableMultiWindows", true);
		des.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		des.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.mindspark.edicine.MainActivity");
		des.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mindspark.edicine");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), des);
//		driver.get("https://stglearn.mindspark.in/Student/onboard/login/en");
	}

	public static void setup() throws InterruptedException, MalformedURLException {
		DesiredCapabilities des = new DesiredCapabilities();
		ChromeOptions option = new ChromeOptions();
		des.setCapability(MobileCapabilityType.DEVICE_NAME, "e850222d");
		des.setCapability(MobileCapabilityType.UDID, "e850222d");
		des.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		des.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		des.setCapability("enableMultiWindows", true);
		des.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		des.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, chromeAppActivityName);
//		des.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, chromeAppPackageName);
//		des.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");
		des.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//		des.setCapability(MobileCapabilityType.BROWSER_VERSION, "114.0.5735.130");
		des.setCapability("chromedriverExecutable", "C:\\Users\\Chgha\\Desktop\\EI\\chromedriver.exe");
		des.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), des);
	}

	public static void assignHomeWork(AppiumDriver<MobileElement> driver) throws InterruptedException {
		Actions action = new Actions(driver);
		LoginWebPage login = new LoginWebPage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.get("https://stglearn.mindspark.in/Student/onboard/login/en");
//		driver.findElement(By.id("userName")).sendKeys(teacherUserName);
//		driver.findElement(By.id("nextButton")).click();
		Thread.sleep(1000);
//		login.inp_userName().sendKeys(teacherUserName);
//		login.btn_nextButton().click();
		Thread.sleep(2000);
//		login.inp_userName().sendKeys(teacherPassword);
//		driver.findElement(By.id("textPassword")).sendKeys(teacherPassword);
		driver.findElement(By.id("loginBtn")).click();
		Thread.sleep(15000);

//		driver.findElement(By.id("headerGroupList")).click();
		Select className = new Select(driver.findElement(By.id("headerGroupList")));
		className.selectByVisibleText("CLASS 3 A");
		Thread.sleep(15000);

//		action.click(driver.findElement(By.id("worksheetTabCTA"))).build().perform();
		driver.findElement(By.id("worksheetTabCTA")).click();

		Thread.sleep(45000);
		driver.findElement(By.id("createWorksheet")).click();

		driver.findElement(By.id("fetchWorksheet")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@value='topic']")).click();

		Thread.sleep(15000);
		driver.findElement(By.id("selectWorksheet0")).click();

		Thread.sleep(15000);
		JavascriptExecutor j = (JavascriptExecutor) driver;

		for (int i = 0; i < numberOfQuestion; i++) {
			System.out.println(getCorrentOptions(i + 1));
			answers.add(getCorrentOptions(i + 1));
			j.executeScript("arguments[0].click();",
					driver.findElements(By.xpath("//button[contains(@id,'addRemovetBtn')]")).get(i));
			Thread.sleep(5000);
		}

		driver.findElement(By.id("nextBtn")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("worksheetName")).clear();
		driver.findElement(By.id("worksheetName")).sendKeys(worksheetName);
		driver.findElement(By.id("nextBtn")).click();

		System.out.println("assigned homeworks");
	}

	public static String getCorrentOptions(int i) {
		return driver.findElement(By.xpath("//div[@class='slNo' and text()='" + i
				+ "']//following-sibling::div//div[contains(@class,'correctAnswer')]")).getAttribute("id");
	}

	public static void nativeApp(AppiumDriver<MobileElement> driver) {
		TouchAction action;
		action = new TouchAction(driver);
//		LoginScreen login = new LoginNativePage(driver);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='onBoardingFooterBtn']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='onBoardingFooterBtn']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='onBoardingFooterBtn']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='onBoardingFooterBtn']")).click();
//		login.inp_userName().sendKeys(studentUser);
		action.tap(PointOption.point(500, 1200)).perform();
		
	}
	public static void nativeApplication(AppiumDriver<MobileElement> driver) throws Exception {

		try {
			TouchAction action;
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			action = new TouchAction(driver);
			driver.findElement(By.xpath("//android.widget.Button[@content-desc='onBoardingFooterBtn']")).click();
			driver.findElement(By.xpath("//android.widget.Button[@content-desc='onBoardingFooterBtn']")).click();
			driver.findElement(By.xpath("//android.widget.Button[@content-desc='onBoardingFooterBtn']")).click();
			driver.findElement(By.xpath("//android.widget.Button[@content-desc='onBoardingFooterBtn']")).click();
			driver.findElement(By.xpath("//android.widget.EditText[@content-desc='CustomTextInputLoginInput']"))
					.sendKeys(studentUser);
			action.tap(PointOption.point(500, 1200)).perform();
//			driver.findElement(By.xpath("//android.widget.TextView[@content-desc='nextTextButton']")).click();
			driver.findElement(By.xpath("//android.widget.EditText[@content-desc='InputWithRightIconTextInput']"))
					.sendKeys("12345");

			action.tap(PointOption.point(500, 2050)).perform();
//			driver.findElement(By.xpath(
//					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]"))
//					.click();

			getXpath(
					"//android.view.ViewGroup[@content-desc='LargeButtonContentWorkSheetBtnText']/android.view.ViewGroup/android.view.ViewGroup[2]")
					.click();

			Thread.sleep(2000);
			System.out.println("Done!");
			getXpath("//android.widget.EditText[@content-desc='SearchInputInput']").sendKeys(worksheetName);
			getXpath("//android.widget.TextView[@content-desc='SearchInputIcon']").click();
			Thread.sleep(1000);
			getXpath(
					"//android.widget.ScrollView[@content-desc='WorkListingCotentSectionList']/android.view.ViewGroup/android.view.ViewGroup[2]")
					.click();
			Thread.sleep(1000);

//			continue button
//			if (driver.findElements(By.xpath(
//					"//android.view.ViewGroup[@content-desc='CustomModal']/android.view.ViewGroup[2]/android.view.ViewGroup[1]"))
//					.size() > 0) {
//				getXpath(
//						"//android.view.ViewGroup[@content-desc='CustomModal']/android.view.ViewGroup[2]/android.view.ViewGroup[1]")
//						.click();
//			}
			getXpath(
					"//android.view.ViewGroup[@content-desc='CustomModal']/android.view.ViewGroup[2]/android.view.ViewGroup[1]")
					.click();
//			addAnswer();
			for (int i = 0; i < numberOfQuestion; i++) {
				scrolldown();
				scrolldown();
				scrolldown();			

				getXpath(
						"//android.view.ViewGroup[@content-desc=\"SVGImageBackgroundQnAScreen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup["
								+ (Integer.parseInt(answers.get(i).split("Index")[1]) + 1) + "]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")
						.click();
				Thread.sleep(1000);
				getXpath(
						"//android.view.ViewGroup[@content-desc='SVGImageBackgroundQnAScreen']/android.view.ViewGroup[2]/android.view.ViewGroup[2]")
						.click();

			}
			Thread.sleep(2000);
			System.out.println("answered!");

			getXpath(
					"//android.view.ViewGroup[@content-desc='SVGImageBackgroundQnAScreen']/android.view.ViewGroup[2]/android.view.ViewGroup[1]")
					.click();

			getXpath("//android.view.ViewGroup[@content-desc=\"CustomModal\"]/android.view.ViewGroup[2]").click();

//			getXpath(
//					"//android.view.ViewGroup[@content-desc='SVGImageBackgroundQnAScreen']/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]")
//					.click();
//			getXpath("//android.widget.TextView[@text='automation1']//parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup").click();

			//
//			driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc='ItemPicturePasswordImg1'])[1]")).click();
//			driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc='ItemPicturePasswordImg1'])[2]")).click();
//			driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc='ItemPicturePasswordImg1'])[3]")).click();
//			driver.findElement(By.xpath("(//*[@resource-id='aws-btn-content'])[2]")).click();
//			driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc='SVGImageBackgroundSelectedSubject'])[2]"))
//					.click();
//			Thread.sleep(1000);
//			driver.findElement(By.xpath(
//					"//android.view.ViewGroup[@content-desc='LargeButtonContentWorkSheetBtnText']/android.view.ViewGroup/android.view.ViewGroup[3]"))
//					.click();
//			driver.findElement(
//					By.xpath("(//android.view.ViewGroup[@content-desc='WorksheetListItemWorkSheetListingContent'])[1]"))
//					.click();
//			if (driver
//					.findElements(
//							By.xpath("//android.view.ViewGroup[@content-desc='CustomModal']/android.view.ViewGroup[2]"))
//					.size() > 0) {
//				driver.findElement(
//						By.xpath("//android.view.ViewGroup[@content-desc='CustomModal']/android.view.ViewGroup[2]"))
//						.click();
//			}
		} catch (Exception e) {
			throw new Exception();
		}
	}

	public static void addAnswer() {
		answers.add("optionIndex0");
		answers.add("optionIndex1");
		answers.add("optionIndex1");
	}

	public static MobileElement getXpath(String val) {
		return driver.findElement(By.xpath(val));
	}

	public static void scrolldown() {
		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
		System.out.println("Scrolling down!");
	}
}
