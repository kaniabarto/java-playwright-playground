package ovh.kania.common;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {

	private static Playwright playwright;
	private static Browser browser;
	private BrowserContext context;
	protected Page page;

	@BeforeAll
	static void beforeAll(){
		playwright = Playwright.create();
		browser = playwright.firefox().launch();
	}

	@BeforeEach
	void beforeEach(){
		context = browser.newContext();
		page = context.newPage();
	}

	@AfterEach
	void afterEach(){
		page.close(); // FYI - context.close() close automatically page.
		context.close();
	}

	@AfterAll
	static void afterAll(){
		browser.close(); //FYI - playwright.cloe() also close automatically browser
		playwright.close();
	}

}
