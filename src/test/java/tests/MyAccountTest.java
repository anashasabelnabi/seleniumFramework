package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
	HomePage homeObject ;
	UserRegistrationPage registerObject;
	MyAccountPage myAccountObject;
	LoginPage loginObject;
	String firstName = "anas";
	String lastName = "hamza";
	String email ="anasham147@gamil.com";
	String password = "12345678";
	String newPassword = "123456789";
	 

		
	@Test(priority = 0,alwaysRun = true)
	public void userCanRegestrationSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.clickRegestraionBtn();
		registerObject = new UserRegistrationPage(driver) ;
		registerObject.userRegistration(firstName,lastName,email,password);
		assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods = "userCanRegestrationSuccessfully")
	public void userCanChangePasswordSuccessfully() {
		registerObject = new UserRegistrationPage(driver) ;
		registerObject.openMyAccountPage();
		myAccountObject = new MyAccountPage(driver);
		myAccountObject.openChangePasswordPage();
		myAccountObject.userCanChangePassword(password,newPassword,newPassword);
		assertTrue(myAccountObject.checkResult.getText().contains("Password was changed"));
	}
	@Test (dependsOnMethods = "userCanChangePasswordSuccessfully")
	public void userCanLogut() {
		registerObject.userLogout();
	}
	
	@Test (dependsOnMethods = ("userCanLogut"))
	public void userCanLogin(){
		homeObject.clickLoginBtn();
		loginObject = new LoginPage(driver);
		loginObject.userCanLogin(email, newPassword);	
		assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
