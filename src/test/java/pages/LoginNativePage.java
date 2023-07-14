package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginNativePage {

	public AppiumDriver<MobileElement> driver;

	public LoginNativePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(xpath = "//android.widget.Button[@content-desc='onBoardingFooterBtn']")
	public MobileElement btn_onboardingNext;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc='CustomTextInputLoginInput']")
	public MobileElement inp_userName;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc='InputWithRightIconTextInput']")
	public MobileElement inp_password;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='LargeButtonContentWorkSheetBtnText']/android.view.ViewGroup/android.view.ViewGroup[2]")
	public MobileElement btn_worksheet;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc='SearchInputInput']")
	public MobileElement inp_worksheetSearchBar;
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc='SearchInputIcon']")
	public MobileElement btn_searchSearchBar;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='CustomModal']/android.view.ViewGroup[2]/android.view.ViewGroup[1]")
	public MobileElement btn_firstWorksheet;
	
	
	
	
}
