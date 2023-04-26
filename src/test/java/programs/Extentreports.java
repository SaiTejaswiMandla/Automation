package programs;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreports {
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;

	@BeforeSuite
	public void setUp() {

		ExtentSparkReporter htmlReporter=new ExtentSparkReporter("extent.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@Test
	public void test() {
		ExtentTest test=extent.createTest("MyFirstTest","sampleDescription");
		test.log(Status.INFO, "This Step shows Usage of log(status,details)");
		test.info("This steps shows Usage of info(details)");
		test.fail("details");
		test.addScreenCaptureFromPath("screenshot.png");


	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
}