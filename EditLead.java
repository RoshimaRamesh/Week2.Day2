package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='firstName']/following::input[@class=' x-form-text x-form-field ']")).sendKeys("durga");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.xpath("//input[@name='companyName']")).sendKeys("abc");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		WebElement changedcmpname = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
		String text = changedcmpname.getText();
		if(text.equals("abc"))
		{
			System.out.println("company name updated succesfully");
		}
		
		driver.close();
	}

}
