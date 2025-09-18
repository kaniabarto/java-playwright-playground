package ovh.kania.m3.exercise;

import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;

public class SauceBrowserTest extends BaseTest{
	
	@Test
	void should_open_browser_and_make_screenshot(){
		for (BrowserType browserType : browsersList){
			page.navigate("https://www.saucedemo.com/");
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/exercise/"+browserType.name()+System.currentTimeMillis()+".png")));	}

		}

			
}
