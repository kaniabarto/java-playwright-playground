package ovh.kania.m3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
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

	//FIY 1 - when you run playwright on the first time, then PW will download all browsers before first test execution.
	//FIY 2 - playwright by default run in headless mode. To see browser during test use BrowserType.LaunchOptions().setHeadless(false)
	//FIY 3 - .setSlowMo() - method from LaunchOptions() to slow down the browser
	
	@Test
	void secondTest(){
		Playwright playwright = Playwright.create();
		
		//Usecase FYI 2 and 3
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		
		Page page = browser.newPage();
		page.navigate("https://playwright.dev/");
		Assertions.assertThat(page.title()).isEqualTo("Fast and reliable end-to-end testing for modern web apps | Playwright");


	}


	/* Class name - CamelCase - java convention - example, FirstTest
	 * Methid name - camelCase - java convention - example firstTest, shoudReturnCorrectPageTiltle - less readable
	 * better readability - snake_case - python convention - example should_return_correct_page_title - more readable */
	@Test
	void should_return_correct_page_title(){
		Playwright playwright = Playwright.create();
		Browser browser = playwright.firefox().launch();
		Page page = browser.newPage();
		page.navigate("https://playwright.dev/");
		Assertions.assertThat(page.title()).isEqualTo("Fast and reliable end-to-end testing for modern web apps | Playwright");


	}

}
