package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.EXcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithExcel extends TestBase{
	HomePage homeObject ;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name="excelData")
	public static  Object[][] userData() throws IOException {		
		EXcelReader er = new EXcelReader() ;
		return er.getExcelData();
	}

	@Test(priority = 0,alwaysRun = true ,dataProvider="excelData")
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
