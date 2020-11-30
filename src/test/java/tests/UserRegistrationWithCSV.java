package tests;

import static org.testng.Assert.assertTrue;


import java.io.FileReader;
import java.io.IOException;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithCSV extends TestBase{
	HomePage homeObject ;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	CSVReader reader ;

	@Test(priority = 0,alwaysRun = true)
	public void userCanRegestrationSuccessfully() throws CsvValidationException, IOException {

		String CSV_file = System.getProperty("user.dir")+"/src/test/java/data/Book.csv";
		reader = new CSVReader(new FileReader(CSV_file));
		String[] csvCell;

		while((csvCell = reader.readNext()) != null) {
			String firstName = csvCell[0];
			String lastName  = csvCell[1];
			String email  = csvCell[2];
			String password = csvCell[3];
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
}
