package ovh.kania.m3;

import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AllBrowserTest {

	@Test
	void should_open_supported_browser_firefox(){
		//Run browser
		Playwright playwright = Playwright.create();
		Browser browser = playwright.firefox().launch();
		Page page = browser.newPage();
		//Navigate to page
		page.navigate("https://whatismybrowser.com/");
		//Make screenshot
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/firefox.png")));
	}

	@Test
	void should_open_supported_browser_chromium(){
		//Run browser
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch();
		Page page = browser.newPage();
		//Navigate to page
		page.navigate("https://whatismybrowser.com/");
		//Make screenshot
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/chromium.png")));
	}
	
	// playwright-webkit is only supported on debian and ubuntu. On other distributions it doesn't work and test below always fail.
	@Test
	void should_open_supported_browser_webkt(){
		//Run browser
		Playwright playwright = Playwright.create();
		Browser browser = playwright.webkit().launch();
		Page page = browser.newPage();
		//Navigate to page
		page.navigate("https://whatismybrowser.com/");
		//Make screenshot
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/webkit.png")));
	}
	
	/* In theory:
	Object Playwright -> BrowserType -> Browser -> Page. Example:
	1. Playwright pw = Playwright.create();
	2. BrowserType bt = pw.chromium();
	3. Browser browser = bt.launch();  // !!! state of Browser object is shared between all tests. 
	4. Page page = browser.newPage();

	ALWAYS: our tests should be:
	1. Fast
	2. Independent / Isolation

	To avoid share state of Browser object, playwright developed BrowserContext.

	BrowserContext is like "browser in incognito mode" /
	and it's fast /
	and it's isolated.
	
	So, we should create:
	Object Playwright -> BrowserType -> Browser -> BrowserContext.
	1. Playwright pw = Playwright.create();
	2. BrowserType bt = pw.chromium();
	3. Browser browser = bt.launch();
	4. BrowserContext context = browser.newContext();
	5. context.newPage();
 
	*/



	

}
