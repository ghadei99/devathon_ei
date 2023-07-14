package reusableComponents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TechnicalComponent {
//	public static AppiumDriver<MobileElement> driver;
	public static AndroidDriver<MobileElement> driver;
	public static Actions action;
	public static WebDriverWait wait;
	protected static List<String> answers = new ArrayList<String>();

	public static void addAnswer() {
		answers.add("optionIndex0");
		answers.add("optionIndex1");
		answers.add("optionIndex1");
	}

	public static MobileElement getXpath(String val) {
		return driver.findElement(By.xpath(val));
	}

	public static void scrolldown(int n) {
		for(int i=0;i<n;i++) {
			driver.findElement(
					MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
			System.out.println("Scrolling down!");	
		}
	}
	
	public static String getCorrentOptions(int i) {
		return driver.findElement(By.xpath("//div[@class='slNo' and text()='" + i
				+ "']//following-sibling::div//div[contains(@class,'correctAnswer')]")).getAttribute("id");
	}
}
