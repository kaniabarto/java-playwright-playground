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


}
