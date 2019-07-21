package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.support.ui.*;

public class Chrome {
	public static void main (String [] args) throws InterruptedException {
		Logger logger = Logger.getLogger(""); logger.setLevel(Level.OFF);
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver");
		WebDriver driver;
		driver = new ChromeDriver(); driver.manage().window().maximize();
		
		System.out.println("Browser is: Chrome");
		driver.get("http://facebook.com");
		
		Thread.sleep(1000); // Pause in milliseconds (1000 - 1 sec)
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Title: " + driver.getTitle());
		String copyright = driver.findElement(By.xpath("")).getText();
		System.out.println("Copyright: " + copyright);
		driver.findElement(By.id("email")).sendKeys("superlulu@mail.ru");
		driver.findElement(By.id("pass")).sendKeys("***********");
		driver.findElement(By.id("u_0_a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"u_0_d\"]/div[1]/div[1]/div/a/span/span")).click();
		Thread.sleep(7000);
		String friends = driver.findElement(By.xpath("//*[@id=\"u_fetchstream_4_8\"]/li[3]/a/span[1]")).getText();
		System.out.println("You have " + friends + " friends");
		Thread.sleep(3000);
		//Click on account settings
		driver.findElement(By.id("userNavigationLabel")).click();
		// Click on log out button
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log Out")));
		logout.click();
		driver.quit();
	}
}
