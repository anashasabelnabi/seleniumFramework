package steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase{
	HomePage homeObject ;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	@Given("User in the main page of website")
	public void user_in_the_main_page_of_website() {
		homeObject = new HomePage(driver);
		homeObject.clickRegestraionBtn();
	}

	@When("I click in registartion Link")
	public void i_click_in_registartion_link() {
		assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*
	 * @When("Enter user data,") public void enter_user_data() { registerObject =
	 * new UserRegistrationPage(driver); registerObject.userRegistration("ahmed",
	 * "mohamed", "yhia@example.com", "123456"); }
	 */
	@When("Enter  {string} , {string} , {string} , {string}")
	public void enter(String firstname, String lastname, String email, String password) {
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(firstname,lastname,email,password); 
	}

	@Then("The registration page displayed succssfully")
	public void the_registration_page_displayed_succssfully() {
		registerObject = new UserRegistrationPage(driver);
		assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
	}


}
