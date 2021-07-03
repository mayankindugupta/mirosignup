package com.miro.hometest;

/*This test class validates all the 
 * successful use case to signup
 * createdBy Mak Test*/

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import com.miro.utility.MiroUtility;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MiroSuccessfulSignup extends MiroUtility {

	private static String tcName, tcEmail, tcPassword;
	private String miroTermCheckboxPath = "//label[@for='signup-terms']";
	private String miroUpdateCheckboxPath = "//label[@for='signup-subscribe']";
	private static final String random = new SimpleDateFormat("ddMMyyHHmmss").format(Calendar.getInstance().getTime());

	@Before
	public void setUp() {
		// create a webdriver
		openDriver();

		// navigate to miro signup page
		navigateToMiro();
	}

	@After
	public void tearDown() {
		// close the driver
		quitDriver();
	}

	@Test // set name, email, password & both checks without selecting how did u hear
	public void testCase01_SuccessfulSignup() {

		tcName = "Mak Test" + random;
		tcEmail = "mak.test" + random + "@gmail.co.in";
		tcPassword = "MiroTest@" + random;

		// enter all the required fields without selecting how did u hear
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the check your email screen text
		String confirmScreen = checkYourEmail();

		// get the registered email
		String email = getRegisteredEmail();

		// validate the check your email msg
		Assert.assertEquals("Check your email", confirmScreen);
		Assert.assertEquals(tcEmail, email);
	}

	@Test // set name,email,password, both checks with selection of how did u hear
	public void testCase02_SuccessfulSignup() {

		tcName = "Mak Test" + random;
		tcEmail = "mak.test" + random + "@gmail.com";
		tcPassword = "MiroTest@" + random;

		// enter name,email,password, both checks with selection of how did u hear
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Podcast");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the check your email screen text
		String confirmScreen = checkYourEmail();

		// get the registered email
		String email = getRegisteredEmail();

		// validate the check your email msg
		Assert.assertEquals("Check your email", confirmScreen);
		Assert.assertEquals(tcEmail, email);
	}

	@Test // set name field with leading & trailing spaces
	public void testCase03_SuccessfulSignup() {

		tcName = "    Mak Test    ";
		tcEmail = "mak.test" + random + "@yahoo.com";
		tcPassword = "MiroTest" + random;

		// enter name field with leading & trailing spaces
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Podcast");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the check your email screen text
		String confirmScreen = checkYourEmail();

		// get the registered email
		String email = getRegisteredEmail();

		// validate the check your email msg
		Assert.assertEquals("Check your email", confirmScreen);
		Assert.assertEquals(tcEmail, email);
	}

	@Test // set email domain miro.com
	public void testCase04_SuccessfulSignup() {

		tcName = "Mak Test" + random;
		tcEmail = "mak.test" + random + "@miro.com";
		tcPassword = "MiroTest" + random;

		// enter email domain miro.com
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Podcast");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the check your email screen
		String confirmScreen = checkYourEmail();

		// get the registered email
		String email = getRegisteredEmail();

		// validate the check your email msg
		Assert.assertEquals("Check your email", confirmScreen);
		Assert.assertEquals(tcEmail, email);
	}

	@Test // set email domain hotmail.com & only alphabetic password
	public void testCase05_SuccessfulSignup() {

		tcName = "Mak Test" + random;
		tcEmail = "mak.test" + random + "@hotmail.com";
		tcPassword = "MiroTest";

		// enter email domain hotmail.com & only alphabetic password
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Podcast");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the check your email screen
		String confirmScreen = checkYourEmail();

		// get the registered email
		String email = getRegisteredEmail();

		// validate the check your email msg
		Assert.assertEquals("Check your email", confirmScreen);
		Assert.assertEquals(tcEmail, email);
	}

	@Test // set email domain microsoft.com & only numeric password
	public void testCase06_SuccessfulSignup() {

		tcName = "Mak Test" + random;
		tcEmail = "mak.test" + random + "@microsoft.com";
		tcPassword = "12345678";

		// enter email domain microsoft.com & only numeric password
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Podcast");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the check your email screen
		String confirmScreen = checkYourEmail();

		// get the registered email
		String email = getRegisteredEmail();

		// validate the check your email msg
		Assert.assertEquals("Check your email", confirmScreen);
		Assert.assertEquals(tcEmail, email);
	}

	@Test // set email domain mail.com & only specialCharacters password
	public void testCase07_SuccessfulSignup() {

		tcName = "Mak Test" + random;
		tcEmail = "mak.test" + random + "@mail.com";
		tcPassword = "@#!$%^&*";

		// enter email domain mail.com & only specialCharacters password
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Podcast");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the check your email screen
		String confirmScreen = checkYourEmail();

		// get the registered email
		String email = getRegisteredEmail();

		// validate the check your email msg
		Assert.assertEquals("Check your email", confirmScreen);
		Assert.assertEquals(tcEmail, email);
	}

	@Test // set name, email & password as numeric value
	public void testCase08_SuccessfulSignup() {

		tcName = random;
		tcEmail = tcName + "@zoho.com";
		tcPassword = "12345678";

		// enter name, email & password as numeric value
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Search Engine (Google, Bing)");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the check your email screen
		String confirmScreen = checkYourEmail();

		// get the registered email
		String email = getRegisteredEmail();

		// validate the check your email msg
		Assert.assertEquals("Check your email", confirmScreen);
		Assert.assertEquals(tcEmail, email);
	}

	@Test // dont select Miro updates checkbox
	public void testCase09_SuccessfulSignup() {

		tcName = "Mak Test" + random;
		tcEmail = "mak.test" + random + "@Outlook.com";
		tcPassword = "MiroTest@" + random;

		// enter all the fields, but dont select Miro updates checkbox
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Not Sure / Don’t Remember");
		click(miroTermCheckboxPath);

		// click signup button
		submit();

		// get the check your email screen
		String confirmScreen = checkYourEmail();

		// get the registered email
		String email = getRegisteredEmail();

		// validate the signup can be done even without selecting Miro updates checkbox
		Assert.assertEquals("Check your email", confirmScreen);
		Assert.assertEquals(tcEmail, email);
	}

	@Test // name as single character
	public void testCase10_SuccessfulSignup() {

		tcName = "a";
		tcEmail = "mak.test" + random + "@iCloud.com";
		tcPassword = "MiroTest@" + random;

		// enter name as single character
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Not Sure / Don’t Remember");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the check your email screen
		String confirmScreen = checkYourEmail();

		// get the registered email
		String email = getRegisteredEmail();

		// validate the check your email msg
		Assert.assertEquals("Check your email", confirmScreen);
		Assert.assertEquals(tcEmail, email);
	}

	@Test // email domain as gmail.co.in
	public void testCase11_SuccessfulSignup() {

		tcName = "Mak Test" + random;
		tcEmail = "mak1.test1" + random + "@gmail.co.in";
		tcPassword = "MiroTest@" + random;

		// enter email domain as gmail.in
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Not Sure / Don’t Remember");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the check your email screen
		String confirmScreen = checkYourEmail();

		// get the registered email
		String email = getRegisteredEmail();

		// validate the check your email msg
		Assert.assertEquals("Check your email", confirmScreen);
		Assert.assertEquals(tcEmail, email);
	}

	@Test // set email domain as @google.uk
	public void testCase12_SuccessfulSignup() {

		tcName = "Mak Test" + random;
		tcEmail = "mak.test" + random + "@google.uk";
		tcPassword = "MiroTest@" + random;

		// enter email domain as @google.uk
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Other");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the check your email screen
		String confirmScreen = checkYourEmail();

		// get the registered email
		String email = getRegisteredEmail();

		// validate that emailId with @google.uk domain is valid email
		Assert.assertEquals("Check your email", confirmScreen);
		Assert.assertEquals(tcEmail, email);
	}

	@Test // set email domain as some organization domain like @accenture.com
	public void testCase13_SuccessfulSignup() {

		tcName = "Mak Test" + random;
		tcEmail = "mak.test" + random + "@accenture.com";
		tcPassword = "MiroTest@" + random;

		// enter email domain as some organization domain like @accenture.com
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("TV");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the check your email screen
		String confirmScreen = checkYourEmail();

		// get the registered email
		String email = getRegisteredEmail();

		// validate that email domain as some organization domain like @accenture.com is
		// valid
		Assert.assertEquals("Check your email", confirmScreen);
		Assert.assertEquals(tcEmail, email);
	}

	@Test // set password with inbetween blank spaces
	public void testCase14_SuccessfulSignup() {

		tcName = "Mak Test" + random;
		tcEmail = "mak.test" + random + "@wipro.com";
		tcPassword = "Miro   Test";

		// enter password with inbetween blank spaces
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Other");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the check your email screen
		String confirmScreen = checkYourEmail();

		// get the registered email
		String email = getRegisteredEmail();

		// validate that user is able to signup with password with spaces
		Assert.assertEquals("Check your email", confirmScreen);
		Assert.assertEquals(tcEmail, email);
	}

}
