package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get(" https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("abco");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("abco");
		driver.findElement(By.xpath("//div[contains(text(),'Mobile')]/following-sibling::input")).sendKeys("7397409123");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Abc@12345");
		
		WebElement day = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select sle = new Select(day);
		sle.selectByValue("29");
		
		WebElement month = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select mm = new Select(month);
		mm.selectByValue("8");
		
		WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select yr = new Select(year);
		yr.selectByValue("1992");
		
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		
		
		
	}

}
