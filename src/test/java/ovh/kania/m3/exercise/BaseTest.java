package ovh.kania.m3.exercise;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {

	private static Playwright playwright;
	private BrowserContext context;
	protected Page page;
	protected static List<BrowserType> browsersList;
	private Browser browser;

	@BeforeAll
	static void beforeAll(){
		playwright = Playwright.create();
		browsersList = List.of(playwright.chromium(), playwright.firefox());

	}

	@BeforeEach
	void beforeEach(){
		for (BrowserType browserType: browsersList){
			browser = browserType.launch();
			page = browser.newPage();
		}	
	}

	@AfterEach
	void afterEach(){
	}

	@AfterAll
	static void afterAll(){
		playwright.close();
	}
}
