package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "Email")
	WebElement emailTxtBox ;

	@FindBy(id = "Password")
	WebElement passwordTxtBox;

	@FindBy(css = "input.button-1.login-button")
	WebElement loginBtn;

	public void userCanLogin(String email ,String password) {
		setText(emailTxtBox, email);
		setText(passwordTxtBox, password);
		clickButton(loginBtn);		
	}
}
