package programs;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Prog1 {

	WebDriver driver;

	@Test
	public void amazon() {
		System.setProperty("webdriver.edge.driver","D:\\msedgedriver.exe");

		EdgeOptions e=new EdgeOptions();
		e.addArguments("--remote-allow-origins=*");
		WebDriver driver=new EdgeDriver(e);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");

		driver.findElement(By.xpath("//*[@class='_2KpZ6l _2doB4z']")).click();

		String parent=driver.getWindowHandle();

		driver.findElement(By.xpath("//a[@class='_3-PJz-']")).click();

		//driver.findElement(By.xpath("//div[@class='xtXmba'])")).click();
		Set<String> s=driver.getWindowHandles();

		Set<String> NumOfWindows=driver.getWindowHandles();

		System.out.println("windowsNum;"+NumOfWindows.size());

		Iterator<String> i=s.iterator();

		while(i.hasNext())
		{
			String childWindow=i.next();

			if (!parent.equals(childWindow))
			{

				driver.switchTo().window(childWindow);

				System.out.println(driver.switchTo().window(childWindow).getTitle());

				driver.quit();


			}
		}

	}





	@Test

	public void windowCount() {

		System.setProperty("webdriver.edge.driver","D:\\msedgedriver.exe");

		EdgeOptions e=new EdgeOptions();
		e.addArguments("--remote-allow-origins=*");
		WebDriver driver=new EdgeDriver(e);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("");


	}


}
