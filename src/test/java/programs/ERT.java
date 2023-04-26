package programs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ERT {
	@Test
	public void ExtReports() {

		ExtentSparkReporter htmlReporter=new ExtentSparkReporter("C:\\Users\\QA-1\\Desktop\\extentReport.html");

		ExtentReports reports=new ExtentReports();
		reports.attachReporter(htmlReporter);

		ExtentTest test1=reports.createTest("Google Search Test One","Test To Validate Google Search");

		//String projPath=System.getProperty("user.dir");
		//System.setProperty("webdriver.edge.driver", projPath+ "C:\\javaproject\\selenium\\selenium1\\Practice2\\Driver\\msedgedriver.exe");
		/*ChromeOptions e=new ChromeOptions();
		e.addArguments("--remote-allows-origins=*");
		*/WebDriver driver=new FirefoxDriver();

		test1.log(Status.INFO,"Starting TestCases ");
		driver.get("https://www.google.com/");
		test1.pass("Naviagted to Google Page");

		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.pass("Entered in Search Button");

		driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN);
		test1.pass("clicked On Enter");

		driver.quit();
		test1.pass("closed the browser");

		test1.info("Test Completed");

		reports.flush();
	}

}
