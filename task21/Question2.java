package task21;

import java.util.Set;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question2 {

	public static void main(String[] args) {

		// Open the chrome browser by Webdriver

		WebDriver driver = new ChromeDriver();

		// Maximize the window

		driver.manage().window().maximize();

		// Navigate to the url

		driver.get("https://the-internet.herokuapp.com/windows");

		// Storing the parent window in string & printing

		String parentWindow = driver.getWindowHandle();

		System.out.println("Parent Window="+parentWindow);

		// locating the click here button

		WebElement clickButton = driver.findElement(By.linkText("Click Here"));

		clickButton.click();

		// Using set for window handles

		Set<String> openWindow = driver.getWindowHandles();

		// for each loop to iterate

		for (String child : openWindow) {

			// Condtion to check the parent & child window

			if (!(child.equals(parentWindow))) {

				// switching to child window

				driver.switchTo().window(child);
				
				System.out.println("Child Window= "+child);

				// locating the New Window Text and printing

				WebElement windowText = driver.findElement(By.xpath("//h3[text()='New Window']"));

				System.out.println("Child Window is Opened and the text is= " + windowText.getText());

				// Closing the current window

				driver.close();
			}
		}

		// Switching to parentWindow

		driver.switchTo().window(parentWindow);

		// Verifying the parent Url

		if (driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/windows")) {

			System.out.println("Parent window is active and it is opened");
		} else {

			System.out.println("Parent window is closed");
		}

		// Quit the whole browser

		driver.quit();

	}

}

//Output=
/* Parent Window=62E08D9CEEEA6AFF1D11000295C7AF0B 
   Child Window=19A7195BE88492C04B2A181D1ABACF8E
   Child Window is Opened and the text is= New Window
   Parent window is active and it is opened           */
