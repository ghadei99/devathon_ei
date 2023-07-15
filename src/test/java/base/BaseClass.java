package base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import reusableComponents.TechnicalComponent;


public class BaseClass extends TechnicalComponent {
	public static String teacherUserName = "demo1.1500", teacherPassword = "12345", studentUser = "jissa.varghese",
			worksheetName = "automationdemo";
	public static int numberOfQuestion = 6;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports report = new ExtentReports();
	private static final Logger log = LogManager.getLogger();
	public static int count = 0;
	public static ExtentTest logger;
	
}
