package ovh.kania.m3.exercise;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class BaseTest {

	private static Playwright playwright;
	private static Browser browser;
	private BrowserContext context;
	protected Page page;

	@BeforeAll
	static void beforeAll(){
		playwright = Playwright.create();
		browser = playwright.firefox().launch(new LaunchOptions().setSlowMo(1000).setHeadless(false));
	}

	@BeforeEach
	void beforeEach(){
		context = browser.newContext();
		page = context.newPage();
	}

	@AfterEach
	void afterEach(){
		context.close();
	}

	@AfterAll
	static void afterAll(){
		playwright.close();
	}
}
