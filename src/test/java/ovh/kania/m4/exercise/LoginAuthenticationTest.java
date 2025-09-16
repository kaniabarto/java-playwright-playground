package ovh.kania.m4.exercise;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

import ovh.kania.common.BaseTest;

public class LoginAuthenticationTest extends BaseTest{

	@Test
	void should_return_error_for_empty_username_and_password(){
		page.navigate("https://the-internet.herokuapp.com/login");
		page.getByLabel("username").fill("");
		page.getByLabel("password").fill("");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		PlaywrightAssertions.assertThat(page.getByText("Your username is invalid!")).isVisible();
	}

	@Test
	void should_return_error_for_wrong_password(){
		page.navigate("https://the-internet.herokuapp.com/login");
		page.getByLabel("username").fill("tomsmith");
		page.getByLabel("password").fill("wrong_password");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		PlaywrightAssertions.assertThat(page.getByText("Your password is invalid!")).isVisible();

	}

	@Test
	void should_return_error_for_wrong_username_and_correct_password(){
		page.navigate("https://the-internet.herokuapp.com/login");
		page.getByLabel("username").fill("wrong_username");
		page.getByLabel("password").fill("SuperSecretPassword!");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		PlaywrightAssertions.assertThat(page.getByText("Your username is invalid!")).isVisible();

	}

	@Test
	void should_login_with_success(){
		page.navigate("https://the-internet.herokuapp.com/login");
		page.getByLabel("username").fill("tomsmith");
		page.getByLabel("password").fill("SuperSecretPassword!");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		PlaywrightAssertions.assertThat(page.getByText("You logged into a secure area!")).isVisible();

	}
}
