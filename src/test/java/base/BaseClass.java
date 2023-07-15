package base;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import reusableComponents.TechnicalComponent;


public class BaseClass extends TechnicalComponent {
	public static String teacherUserName = "demo1.1500", teacherPassword = "12345", studentUser = "jissa.varghese",
			worksheetName = "browserstack";
	public static int numberOfQuestion = 6;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports report = new ExtentReports();
	private static final Logger log = LogManager.getLogger();
	public static int count = 0;
	public static ExtentTest logger;
	
	
	static {
		report.setSystemInfo("Operating System", System.getProperty("os.name"));
		report.setSystemInfo("Java Version", System.getProperty("java.version"));
		report.setSystemInfo("Host Name", System.getenv("USER"));
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		String filePath = "Reports/sessionReport.html";
		sparkReporter = new ExtentSparkReporter(filePath);
		sparkReporter.loadXMLConfig("C:\\Users\\Chgha\\Desktop\\EI\\ExtentHtmlReporter.xmll");
		report.attachReporter(sparkReporter);
	}
	
	@AfterTest
	public void after() {
			log.info("Scenario {} is failed! ");
			logger.fail("Scenario  is failed! ",MediaEntityBuilder.createScreenCaptureFromPath(createScreenshot()).build());
			count++;
		report.flush();
	}
}
