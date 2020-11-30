package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver ;
	}
	@FindBy(linkText="Register")
	WebElement registerBtn ;
	
	@FindBy(linkText="Log in")
	WebElement loginBtn ;
	
	@FindBy(linkText="Contact us")
	WebElement contactusBtn;
	
	
	public void clickRegestraionBtn() {
		clickButton(registerBtn);
	}
	public void clickLoginBtn() {
		clickButton(loginBtn);
	}
	public void openContactUsPage() {
		scrollToBottom();
		clickButton(contactusBtn);
	}

}
