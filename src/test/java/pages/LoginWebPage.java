package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginWebPage  {

	public AppiumDriver<MobileElement> driver;
//	public WebDriver driver;

	public LoginWebPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@FindBy(id = "userName")
	public MobileElement inp_userName;
	
	@FindBy(id = "nextButton")
	public MobileElement btn_nextButton;
	
	@FindBy(id = "textPassword")
	public MobileElement inp_password;

	@FindBy(id = "loginBtn")
	public MobileElement btn_login;
	
	@FindBy(id= "headerGroupList")
	public MobileElement dd_className;
	
	@FindBy(id = "worksheetTabCTA")
	public MobileElement btn_worksheetNavbar;
	
	@FindBy(id = "createWorksheet")
	public MobileElement btn_createWorksheet;
	
	@FindBy(id = "fetchWorksheet")
	public MobileElement btn_fetchWorksheet;
	
	@FindBy(xpath = "//*[@value='topic']")
	public MobileElement option_Topics;
	
	@FindBy(id = "selectWorksheet0")
	public MobileElement btn_worksheetOne;
	
	
	@FindBy(id="nextBtn")
	public MobileElement btn_next;
	
	@FindBy(id = "worksheetName")
	public MobileElement inp_worksheetName;
	
	@FindBy(xpath = "//button[contains(@id,'addRemovetBtn')]")
	public List<MobileElement> btn_add;
	
	
	
//	public MobileElement inp_userName() {
//		return driver.findElement(By.id("userName"));
//	}
//	
//	public MobileElement btn_nextButton() {
//		return driver.findElement(By.id("nextButton"));
//	}
	
	

}
