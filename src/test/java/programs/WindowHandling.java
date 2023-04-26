package programs;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class WindowHandling {
	@Test
	
	public void Windows() throws InterruptedException {
		System.setProperty("webdriver.Edge.driver","D:\\msedgedriver.exe");
		EdgeOptions o=new EdgeOptions();
		o.addArguments("--remote-allow-origins=*");
		WebDriver driver=new EdgeDriver(o);
		driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S-1258129764%3A1681986579140339&continue=https%3A%2F%2Faccounts.google.com%2F&followup=https%3A%2F%2Faccounts.google.com%2F&ifkv=AQMjQ7TzUJMZKLdrBgGQ2adUrhvKdLAl0fcAYOh_o7y_9rqnIqf8MMa9E0fAYs_RIgQAxaFg10wm&passive=1209600&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String parentWindow=driver.getWindowHandle();
		System.out.println("Before Switching title is="+driver.getTitle());
		
		
		Set<String> s1=driver.getWindowHandles();
		Iterator<String>i1=s1.iterator();
		driver.findElement(By.xpath("//li[@class='r7XTUb']")).click();
		while(i1.hasNext());
		{
			String childwindow=i1.next();
			
			if(!parentWindow.equals(childwindow));
			
			driver.switchTo().window(childwindow);
			
				
				System.out.println("After switching title is "+driver.getTitle());
			}
		//	System.out.println("After switching title is "+driver.getTitle());
			
			
			System.out.println("Back to parent window"+driver.getTitle());
			driver.close();
		}
	}


