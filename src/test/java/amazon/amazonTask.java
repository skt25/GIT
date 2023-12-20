package amazon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class amazonTask extends readData {
	static String text;

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sures\\OneDrive\\Desktop\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		List<WebElement> categ = driver.findElements(By.id("searchDropdownBox"));
		String readDatafromsheet = readData.readDatafromsheet("prod", 0, 0);
		System.out.println(readDatafromsheet);
		for (WebElement webElement : categ) {
			 text = webElement.getText();
			 if (readDatafromsheet.equals(text)) {
					System.out.println("true");
				} else {
	System.out.println("false");
				}
			
				}
		
		driver.close();

	}

}
