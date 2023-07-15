package androids;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import base.BaseClass;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import pages.LoginNativePage;
import pages.LoginWebPage;
import setup.TestSetup;

public class Mindspark extends BaseClass {

	@Test(description = "Testing Mobile app")
	public void teacherStudentWorkhseet() throws Exception {
//		assigningWorksheet();
//		answeringWorksheet();
		TestSetup.setupChrome();
		assigningWorksheet();
		TestSetup.setUpMindsparkNative();
		answeringWorksheet();
	}
	
	public void assigningWorksheet() throws InterruptedException, MalformedURLException {
//		TestSetup.setupChrome();
		action = new Actions(driver);
		LoginWebPage login = new LoginWebPage(driver);
		wait = new WebDriverWait(driver, 30);
		
		driver.get("https://stglearn.mindspark.in/Student/onboard/login/en");
		Thread.sleep(1000);
		login.inp_userName.sendKeys(teacherUserName);
		login.btn_nextButton.click();
		Thread.sleep(2000);
		login.inp_password.sendKeys(teacherPassword);
		login.btn_login.click();
		Thread.sleep(15000);

		Select className = new Select(login.dd_className);
		className.selectByVisibleText("CLASS 3 A");
		Thread.sleep(15000);
		login.btn_worksheetNavbar.click();
		Thread.sleep(45000);
		login.btn_createWorksheet.click();
		login.btn_fetchWorksheet.click();
		Thread.sleep(15000);
		login.option_Topics.click();
		Thread.sleep(15000);
		login.btn_worksheetOne.click();
		Thread.sleep(15000);
		JavascriptExecutor j = (JavascriptExecutor) driver;

		for (int i = 0; i < numberOfQuestion; i++) {
			System.out.println(getCorrentOptions(i + 1));
			answers.add(getCorrentOptions(i + 1));
			j.executeScript("arguments[0].click();", login.btn_add.get(i));
			Thread.sleep(5000);
		}

		login.btn_next.click();
		Thread.sleep(1000);
		login.inp_worksheetName.clear();
		login.inp_worksheetName.sendKeys(worksheetName);
		login.btn_next.click();
	}

	public void answeringWorksheet() throws Exception {
		Thread.sleep(3000);
		LoginNativePage login = new LoginNativePage(driver);
		JavascriptExecutor j = (JavascriptExecutor) driver;
//		try {
			TouchAction action;
//			remoteDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
//			remoteDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			login.btn_onboardingNext.click();
			login.btn_onboardingNext.click();
			login.btn_onboardingNext.click();
			login.btn_onboardingNext.click();
			login.inp_userName.sendKeys(studentUser);
			action = new TouchAction((PerformsTouchActions) driver);
			action.tap(PointOption.point(500, 1200)).perform();
			login.inp_password.sendKeys("12345");

			action.tap(PointOption.point(500, 2050)).perform();
			Thread.sleep(1000);
			login.btn_worksheet.click();
			Thread.sleep(4000);
			login.inp_worksheetSearchBar.sendKeys(worksheetName);
			login.btn_searchSearchBar.click();
			Thread.sleep(1000);
			getXpath(
					"//android.widget.ScrollView[@content-desc='WorkListingCotentSectionList']/android.view.ViewGroup/android.view.ViewGroup[2]")
					.click();
			Thread.sleep(1000);
			login.btn_firstWorksheet.click();
			for (int i = 0; i < numberOfQuestion; i++) {
				scrolldown(3);
				getXpath(
						"//android.view.ViewGroup[@content-desc='SVGImageBackgroundQnAScreen']/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup["
								+ (Integer.parseInt(answers.get(i).split("Index")[1]) + 1) + "]")
						.click();
				Thread.sleep(1000);
				getXpath(
						"//android.view.ViewGroup[@content-desc='SVGImageBackgroundQnAScreen']/android.view.ViewGroup[2]/android.view.ViewGroup[2]")
						.click();

			}
			Thread.sleep(2000);
			getXpath(
					"//android.view.ViewGroup[@content-desc='SVGImageBackgroundQnAScreen']/android.view.ViewGroup[2]/android.view.ViewGroup[1]")
					.click();

			getXpath("//android.view.ViewGroup[@content-desc=\"CustomModal\"]/android.view.ViewGroup[2]").click();

//		} catch (Exception e) {
//			System.out.print(e.getStackTrace());
//			throw new Exception();
//		}
	}
}
