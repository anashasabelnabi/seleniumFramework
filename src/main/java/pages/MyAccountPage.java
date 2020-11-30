package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText ="Change password")
	WebElement changePasswordBtn;
	
	@FindBy(id ="OldPassword234")
	WebElement oldPasswordTxtBox;
	
	@FindBy(id="NewPassword")
	WebElement newPasswordTxtBox;
	
	@FindBy(id="ConfirmNewPassword")
	WebElement confirmNewPasswordTxtBox;
	
	@FindBy(css = "input.button-1.change-password-button")
	WebElement changePasswordSubmitBtn;
	
	@FindBy(css = "div.result")
	public WebElement checkResult;
		
	public void openChangePasswordPage() {
		clickButton(changePasswordBtn);
	}
	
	public void userCanChangePassword(String oldPassword,String newPassword,String confirmNewPassword) {
		setText(oldPasswordTxtBox, oldPassword);
		setText(newPasswordTxtBox, newPassword);
		setText(confirmNewPasswordTxtBox, confirmNewPassword);
		clickButton(changePasswordSubmitBtn);
	}

}
