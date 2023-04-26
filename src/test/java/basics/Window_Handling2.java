package basics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Window_Handling2 {
WebDriver driver;
@Test

public void windowHandle() throws InterruptedException, AWTException {
	System.setProperty("webdriver.chrome.driver","C:\\javaproject\\selenium\\selenium1\\Practice2\\Driver\\chromedriver.exe");
	ChromeOptions o=new ChromeOptions();
	o.addArguments("--remote-allow-origins=*");
	WebDriver driver=new ChromeDriver(o);
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
	driver.get("https://www.amazon.in/");
	
	@SuppressWarnings("unused")
	String parentWindow=driver.getWindowHandle();
	System.out.println("ParentWindow:"+driver.getTitle());
	
	ArrayList<String> windows=new ArrayList<String>(driver.getWindowHandles());
	int Windowscount=windows.size();
	driver.switchTo().window(windows.get(0));
	System.out.println("TotalWindows:"+Windowscount);
	
	Thread.sleep(1000);
	driver.findElement(By.id("nav-logo")).click();
	String childWindow=driver.getWindowHandle();
	driver.switchTo().window(childWindow);
	System.out.println("SecondWindow:"+driver.getTitle());
	
	Thread.sleep(1000);
	//driver.switchTo().window(parentWindow);
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("books");
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(1000);
	driver.switchTo().window(windows.get(0));
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[@class='nav-a  ']")).click();
	
	
}
}
