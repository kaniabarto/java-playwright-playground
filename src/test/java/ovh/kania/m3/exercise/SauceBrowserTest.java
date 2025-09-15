package ovh.kania.m3.exercise;

import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;

public class SauceBrowserTest extends BaseTest{
	
	@Test
	void should_open_browser_firefox_and_make_screenshot(){
		page.navigate("https://www.saucedemo.com/");
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/exercise/firefox.png")));
	}
	
}
