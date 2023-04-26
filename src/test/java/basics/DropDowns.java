package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDowns {
	
	@Test
	
	public void dropdown() {
		
		System.setProperty("webdriver.edge.driver","C:\\javaproject\\selenium\\selenium1\\Practice2\\Driver\\msedgedriver.exe");
		EdgeOptions e=new EdgeOptions();
		e.addArguments("--remote-allow-origins=*");
		WebDriver driver=new EdgeDriver(e);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		
		List<WebElement> dd=driver.findElements(By.id("course"));
		

		for (WebElement webElement : dd) {
			
		 
			System.out.println(webElement.getText());
		}
		//Select s=new Select(dd);
		
		
	}

}
