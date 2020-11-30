package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithFakeData extends TestBase{
	HomePage homeObject ;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	@Test(priority = 0,alwaysRun = true)
	public void userCanRegestrationSuccessfully() throws FileNotFoundException, IOException, ParseException {
		
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.JsonReader();
		
		homeObject = new HomePage(driver) ;
		homeObject.clickRegestraionBtn();
		registerObject = new UserRegistrationPage(driver) ;
		registerObject.userRegistration(jsonReader.firstName,jsonReader.lastName,jsonReader.email,jsonReader.password);
		assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.clickLoginBtn();
		loginObject = new LoginPage(driver);
		loginObject.userCanLogin(jsonReader.email, jsonReader.password);	
		assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}

}
