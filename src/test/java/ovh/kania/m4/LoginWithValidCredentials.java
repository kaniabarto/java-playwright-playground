package ovh.kania.m4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.options.AriaRole;

import ovh.kania.common.BaseTest;

public class LoginWithValidCredentials extends BaseTest{
	
	@Test
	void should_login_with_valid_credentials(){
		page.navigate("https://the-internet.herokuapp.com/login");
		page.fill("id=username", "tomsmith");
		page.fill("id=password", "SuperSecretPassword!");
		page.getByRole(AriaRole.BUTTON).click();
		Assertions.assertTrue(page.getByText("You logged into a secure area!").isVisible());
	}
	
}
