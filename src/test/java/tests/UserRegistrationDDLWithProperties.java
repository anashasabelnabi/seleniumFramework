package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationDDLWithProperties extends TestBase{
	HomePage homeObject ;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String firstName = LoadProperties.userData.getProperty("firstName");
	String lastName = LoadProperties.userData.getProperty("lastName");
	String email = LoadProperties.userData.getProperty("email");
	String password =LoadProperties.userData.getProperty("password");
		  
	@Test(priority = 0,alwaysRun = true)
	public void userCanRegestrationSuccessfully() {
		homeObject = new HomePage(driver) ;
		homeObject.clickRegestraionBtn();
		registerObject = new UserRegistrationPage(driver) ;
		registerObject.userRegistration(firstName,lastName,email,password);
		assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods = ("userCanRegestrationSuccessfully"))
	public void userCanLogut() {
		registerObject.userLogout();
	}
	
	@Test (dependsOnMethods = ("userCanLogut"))
	public void userCanLogin(){
		homeObject.clickLoginBtn();
		loginObject = new LoginPage(driver);
		loginObject.userCanLogin(email, password);	
		assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
