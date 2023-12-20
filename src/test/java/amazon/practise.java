package amazon;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class practise {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sures\\OneDrive\\Desktop\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		String readDatafromsheet = readData.readDatafromsheet("prod", 0, 0);
		System.out.println(readDatafromsheet);
		Select category = new Select(driver.findElement(By.id("searchDropdownBox")));
		category.selectByVisibleText(readDatafromsheet);
		String readSuggestData = readData.readDatafromsheet("prod", 0, 1);
		System.out.println(readSuggestData);
		WebElement suggestbox = driver.findElement(By.id("twotabsearchtextbox"));
		suggestbox.sendKeys("toaster");
		Thread.sleep(10000);
		List<WebElement> text = driver.findElements(By.xpath("//div[@class=\"autocomplete-results-container\"]"));
		for (WebElement webElement : text) {
			String text2 = webElement.getText();
			if (text2.contains(readSuggestData)) {
				driver.findElement(By.id("nav-search-submit-button")).click();
			}
		}
		List<WebElement> results = driver.findElements(By.xpath(
				"//div[@class=\"s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 AdHolder sg-col s-widget-spacing-small sg-col-12-of-16\"]"));
		System.out.println(results.size());
		System.out.println(results);
		List<WebElement> moreResults = driver.findElements(By.xpath(
				"//div[@class=\"s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col s-widget-spacing-small sg-col-12-of-16\"]"));
		System.out.println(moreResults.size());
	}
}
