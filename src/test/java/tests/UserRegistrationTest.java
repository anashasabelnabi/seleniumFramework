package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase{
	HomePage homeObject ;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	Faker fakeData = new Faker();
	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();
		  
	@Test(priority = 0,alwaysRun = true)
	public void userCanRegestrationSuccessfully() {
		homeObject = new HomePage(driver) ;
		homeObject.clickRegestraionBtn();
		registerObject = new UserRegistrationPage(driver) ;
		registerObject.userRegistration(firstName ,lastName ,email , password);
		System.out.println(firstName+"--"+lastName+"--"+email+"--"+password);
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
