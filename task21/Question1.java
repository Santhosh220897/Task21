package task21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {

	public static void main(String[] args) {
		
		//open the chrome browser using the webdriver
		
		WebDriver driver = new ChromeDriver();

		//Maximize the window
		
		driver.manage().window().maximize();
		
		//navigate to the url
		
		driver.get("https://the-internet.herokuapp.com/iframe");
		
		//locating the iframe element
		
		WebElement iframe = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
		
		//switch to iframe
		
		driver.switchTo().frame(iframe);
		
		//locating the p tag and sending keys as Hello people
		
		WebElement content = driver.findElement(By.xpath("//p[text()=\"Your content goes here.\"]"));
		
		content.clear();
		
		content.sendKeys("Hello People");
		
		//Close & quit the browser
		
		driver.close();
		
		driver.quit();
		

	}

}

