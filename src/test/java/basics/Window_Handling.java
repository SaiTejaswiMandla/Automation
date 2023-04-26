package basics;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Window_Handling {

	WebDriver driver;

	@Test
	public void windowHandling() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\javaproject\\selenium\\selenium1\\Practice2\\Driver\\msedgedriver.exe");
		EdgeOptions o=new EdgeOptions();
		o.addArguments("--remote-allow-origins=*");
		WebDriver driver=new EdgeDriver(o);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String parentwindow=driver.getWindowHandle();
		System.out.println("ParentWindowTitle:"+driver.getTitle());
      
		 driver.findElement(By.id("newWindowBtn")).click();
        
        ArrayList<String> count=new ArrayList<String>(driver.getWindowHandles());
        int windowscount=count.size();
        System.out.println("TotalWindows:"+windowscount);
        
        for(int i=1;i<count.size();i++)
        {
            driver.switchTo().window(count.get(1));
            }
        
        Thread.sleep(2000);
        System.out.println("ChildWindowTitle:"+driver.getTitle());
        driver.findElement(By.name("fName")).sendKeys("SAI");
        Thread.sleep(2000);

        driver.switchTo().window(parentwindow);
        driver.findElement(By.className("whTextBox")).sendKeys("TEJASWI");
        
	}}

