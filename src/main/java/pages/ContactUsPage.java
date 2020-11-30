package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="FullName")
	WebElement fullNameTxtBox ;
	
	@FindBy(id="Email")
	WebElement emailTxtBox;
	
	@FindBy(id="Enquiry")
	WebElement enquiryTxtBox ;
	
	@FindBy(css="input.button-1.contact-us-button")
	WebElement submitBtn ;
	
	@FindBy(css="div.result")
	public WebElement successResult ;
	
	public void userCanContactUs(String fullName , String email , String enquiry) {
		setText(fullNameTxtBox, fullName);
		setText(emailTxtBox, email);
		setText(enquiryTxtBox, enquiry);
		clickButton(submitBtn);
	}
	
	

}
