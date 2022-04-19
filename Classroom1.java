package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classroom1 {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Men')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Jeans')]")).click();
		
//		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("radhakrishnan@qeagle.com");
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@123");
//		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
	}

}
