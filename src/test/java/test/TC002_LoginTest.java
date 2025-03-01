package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC002_LoginTest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		sheetName="LoginAndAdd";
		
	}
	
	@Test(dataProvider = "excelRead")
	public void loginTest(String invalidemail, String email, String password, String firstname, String lastname, String birthdate, String addemail, String phone, String streetadd1, String streetadd2, String city, String stateprovince, String postalcode, String country) {
		
		HomePage hp = new HomePage(driver);
		hp.enterInvalidEmail(invalidemail)
		.enterPassword(password)
		.clickLoginSubmitForInvalid()
		.getLoginErrorMessage()
		.enterEmail(email)
		.enterPassword(password)
		.clickLoginSubmit()
		.clickLogout();
	}

}
