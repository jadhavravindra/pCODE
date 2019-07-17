package pcode;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Coding {

	public WebDriver driver;
	public void setup()
	{
		try {
			System.setProperty("webdriver.chrome.driver","F:\\QA_Myfolder\\selenium\\Pcode1\\alll\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			options.addArguments("ignore-certificate-errors");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://hostingchecker.com");
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Coding multidotsObj = new Coding();
		multidotsObj.setup();
		multidotsObj.validateUrl();
	}

	public void validateUrl()
	{
		WebElement domainNameTxtBox = driver.findElement(By.xpath("//input[@name='domain']"));
		domainNameTxtBox.sendKeys("multidots.com");

		WebElement findHostingSearchBtn = driver.findElement(By.xpath("//button[text()='Find Hosting']"));
		findHostingSearchBtn.click();

		List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='find_info']/li/strong"));

		int count = elements.size();

		for(int i=1;i<=count;i++)
		{
			String hostedName = driver.findElement(By.xpath("(//ul[@class='find_info']/li/strong)["+i+"]")).getText();
			String value = driver.findElement(By.xpath("(//ul[@class='find_info']/li/span)["+i+"]")).getText();
			System.out.println(hostedName+":"+value);
		}
	}
}

	

