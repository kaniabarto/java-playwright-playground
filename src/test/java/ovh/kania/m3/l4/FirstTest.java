package ovh.kania.m3.l4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstTest {

	@Test
	void firstTest(){
		//Create playwright object
		Playwright playwright =	Playwright.create();
		//create browser object
		Browser browser = playwright.firefox().launch();
		//create page object
		Page page = browser.newPage();
		
		//call navigate method on page object
		page.navigate("https://playwright.dev/");
		//use assertion to compare page title
		Assertions.assertThat(page.title()).isEqualTo("Fast and reliable end-to-end testing for modern web apps | Playwright");
	}
}
