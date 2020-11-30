package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilites.Helpers;

public class TestBase extends AbstractTestNGCucumberTests {
	public static WebDriver driver;
	
	@BeforeSuite
	@Parameters("browser")
	public void startDriver(@Optional("chrome")String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/browsers/chromedriver");
			driver = new ChromeDriver();		
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/browsers/geckodriver");
			driver = new FirefoxDriver();		
		}
		else if(browserName.equalsIgnoreCase("headless")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					System.getProperty("user.dir")+"/browsers/phantomjs" );
			String[] phantomJSArgs = {"--web-security=no","--ignore-ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJSArgs);
			driver = new PhantomJSDriver(caps);		
		}
		else if(browserName.equalsIgnoreCase("chrome-headless")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/browsers/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);		
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed");
			System.out.println("Taking Screenshot...");
			Helpers.captureScreenShot(driver, result.getName());
		}
		
	}
	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}

}
