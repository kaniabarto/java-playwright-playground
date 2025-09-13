package ovh.kania.m3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstTest {

	@Test
	void firstTest(){
		Playwright playwright =	Playwright.create();
		Browser browser = playwright.firefox().launch();
		Page page = browser.newPage();

		page.navigate("https://playwright.dev/");
		Assertions.assertThat(page.title()).isEqualTo("Fast and reliable end-to-end testing for modern web apps | Playwright");
	}
}
