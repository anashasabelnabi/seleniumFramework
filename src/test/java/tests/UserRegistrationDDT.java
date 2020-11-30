package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationDDT extends TestBase{
	HomePage homeObject ;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name="testData")
	public static  Object[][] userData() {		
		return new Object[][] {
			{"anas","hasabelnabi","anas@test.exxxample.com","12345678"},
			{"hamza","hasabragab","hamza@test.example.com","123456"}
		};
	}

	@Test(priority = 0,alwaysRun = true ,dataProvider="testData")
	public void userCanRegestrationSuccessfully(String firstName,String lastName,String email,String password) {
		homeObject = new HomePage(driver) ;
		homeObject.clickRegestraionBtn();
		registerObject = new UserRegistrationPage(driver) ;
		registerObject.userRegistration(firstName,lastName,email,password);
		assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.clickLoginBtn();
		loginObject = new LoginPage(driver);
		loginObject.userCanLogin(email, password);	
		assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}

}
