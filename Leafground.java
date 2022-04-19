package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafground {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();	
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("r@gmail.com");
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("hi");
		String attribute = driver.findElement(By.xpath("//input[@value='TestLeaf']")).getAttribute("value");
		System.out.println(attribute);
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
		WebElement edit = driver.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following::input"));
		boolean enabled = edit.isEnabled();
		System.out.println(enabled);
		if(!enabled) {
			
			System.out.println("text feild is disabled");
		}
		else
		{
			System.out.println("text feild is enabled");
		}
		
		driver.get("http://leafground.com/pages/Button.html");
		driver.findElement(By.xpath("//button[@id='home']")).click();
		driver.findElement(By.xpath("//img[@alt='Buttons']/parent::a")).click();
		Point location = driver.findElement(By.xpath("//button[@id='position']")).getLocation();
		int x = location.getX();
		int y = location.getY();
		System.out.println("position of x"+x+"position y"+y);
		String color = driver.findElement(By.xpath("//button[@id='color']")).getCssValue("background-color");
		System.out.println(color);
		Dimension size = driver.findElement(By.xpath("//button[@id='size']")).getSize();
		System.out.println(size);
		driver.get("http://leafground.com/pages/Link.html");
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.findElement(By.xpath("//img[@alt='Link']")).click();
		driver.findElement(By.linkText("Verify am I broken?")).click();
		WebElement error = driver.findElement(By.xpath("//h1[text()='404 Not Found']"));
		String text = error.getText();
		String title = "404 Not Found";
		System.out.println(text);
		if(text.equals(title))
		{
			System.out.println("Page is broken");
		}
		else
		{
			System.out.println("Page not broken");
		}
		driver.navigate().back();
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.findElement(By.xpath("//img[@alt='Link']")).click();
		driver.findElement(By.linkText("How many links are available in this page?")).click();
		List<WebElement> listlink = driver.findElements(By.tagName("a"));
		int size2 = listlink.size();
		System.out.println(size2);
		driver.navigate().back();
		driver.get("http://leafground.com/pages/Image.html");
		driver.findElement(By.xpath("//label[@for='home']/following::img")).click();
		driver.navigate().back();
		String atr = driver.findElement(By.xpath("//label[@for='position']/following::img")).getAttribute("onclick");
		System.out.println(atr);
		if(atr==null)
		{
			System.out.println("I am broken");
		}
		else
		{
			System.out.println("Not Broken");
		}
		driver.findElement(By.xpath("//label[contains(text(),'Click me')]/following::img")).click();
		driver.findElement(By.xpath("//img[@alt='ListBox']")).click();
		WebElement dd1 = driver.findElement(By.xpath("//select[@id='dropdown1']"));
		Select ss1 = new Select(dd1);
		ss1.selectByIndex(2);
		
		WebElement dd2 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select ss2 = new Select(dd2);
		ss2.selectByVisibleText("Appium");
		
		WebElement dd3 = driver.findElement(By.xpath("//select[@name='dropdown3']"));
		Select ss3 = new Select(dd3);
		ss3.selectByValue("2");
		
		
//		WebElement dd4 = driver.findElement(By.xpath("//select[@class='dropdown']"));
//		Select ss4 = new Select(dd4);
//		//List<WebElement> options = ss4.getOptions();
//		int size3 = ss4.getOptions().size();
//		System.out.println(size3);
//		driver.findElement(By.xpath("//option[text() = 'You can also use sendKeys to select']//parent::select")).sendKeys("Appium",Keys.ENTER);
//		
//		
//		WebElement opt = driver.findElement(By.xpath("//option[text()='Select your programs']"));
//		Select sle1 = new Select(opt);
//		sle1.selectByValue("2");
		
		
		
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.findElement(By.xpath("(//label[@for='java']/following::input)[2]")).click();
		WebElement con = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following::input"));
		boolean check = con.isSelected();
		System.out.println(check);
		if(!check)
		{
			System.out.println("not selected");
		}
		else
		{
			System.out.println("selected");
		}
		
		 WebElement elemnt = driver.findElement(By.xpath("(//label[text()=\"DeSelect only checked\"]/following::input)[2]"));
		 elemnt.click();
		List<WebElement> option = driver.findElements(By.xpath("//label[contains(text(),'Select all below checkboxes')]//following-sibling::input"));
		for(WebElement list : option)
		{
			list.click();
			
		}
		
	}
	

}
