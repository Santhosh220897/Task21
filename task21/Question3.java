package task21;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question3 {

	public static void main(String[] args) {

		// open the chrome driver using the webdriver

		WebDriver driver = new ChromeDriver();

		// maximize the window

		driver.manage().window().maximize();

		// navigate to the URL

		driver.get("http://the-internet.herokuapp.com/nested_frames");

		// Locating the topframe and switching to topframe

		WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));

		driver.switchTo().frame(topFrame);

		// verifying the size of the top frame

		if (driver.findElements(By.tagName("frame")).size() == 3) {

			System.out.println("Top frame as three Frames");
		}

		// Locating the left frame and switching to left frame

		WebElement leftFrame = driver.findElement(By.xpath("//frame[@name='frame-left']"));

		driver.switchTo().frame(leftFrame);

		// Locating the left frame text and verifying the text

		WebElement leftText = driver.findElement(By.xpath("(/html/body)[1]"));

		if (leftText.getText().equals("LEFT")) {

			System.out.println("Frame is switched to LEFT");

		} else {
			System.out.println("Not Switched");
		}

		// Switching back to top frame

		driver.switchTo().parentFrame();

		// Locating the middle frame adn switching to middle frame

		WebElement middleFrame = driver.findElement(By.xpath("//frame[@name='frame-middle']"));

		driver.switchTo().frame(middleFrame);

		// locating thee middle frame text and verifying the text

		WebElement middleText = driver.findElement(By.xpath("//div[@id='content']"));

		if (middleText.getText().equals("MIDDLE")) {

			System.out.println("Frame is switched to MIDDLE");

		} else {
			System.out.println("Not Switched");
		}

		// switching back to the topframe

		driver.switchTo().parentFrame();

		// Locating the rightframe and switching to rightframe

		WebElement rightFrame = driver.findElement(By.xpath("//frame[@name='frame-right']"));

		driver.switchTo().frame(rightFrame);

		// locating the right frame text and verifying the text

		WebElement rightText = driver.findElement(By.xpath("/html/body"));

		if (rightText.getText().equals("RIGHT")) {

			System.out.println("Frame is switched to RIGHT");
		} else {
			System.out.println("Not Switched");
		}

		// switching back 

		driver.switchTo().defaultContent();

		// locating the bottom frame and switching to bottom frame

		WebElement bottomFrame = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));

		driver.switchTo().frame(bottomFrame);

		// locating the boottom frame and verifying the bottom frame text

		WebElement bottomText = driver.findElement(By.xpath("/html/body"));

		if (bottomText.getText().equals("BOTTOM")) {

			System.out.println("Frame is switched to Bottom ");
		} else {
			System.out.println("Not Switched");
		}

		// switching back to top frame

		driver.switchTo().defaultContent();

		// printing the pagesource

		System.out.println(driver.getPageSource());
		
		System.out.println(driver.getCurrentUrl());

		// verifying the the title (it will print as page title is not frames since, it
		// as no title on it.)

		/* if (driver.getTitle().equals("Frames")) {

			System.out.println("Page Title is Frames");
		} else {
			System.out.println("Page Title is not Frames");
		} */

		// close & quit the browser

		driver.close();
		driver.quit();

	}

}

//Output:

/* Top frame as three Frames
Frame is switched to LEFT
Frame is switched to MIDDLE
Frame is switched to RIGHT
Frame is switched to Bottom 
<html><head></head><frameset frameborder="1" rows="50%,50%">
  <frame src="/frame_top" scrolling="no" name="frame-top" cd_frame_id_="0639a0781c2b523356bff24792dbde6a">
  <frame src="/frame_bottom" scrolling="no" name="frame-bottom" cd_frame_id_="e2ac9541bfa12940cc5b3402300d649d">
  <noframes>
    Frames are not rendering.
  </noframes>
</frameset>
</html>
https://the-internet.herokuapp.com/nested_frames
Page Title is not Frames */
