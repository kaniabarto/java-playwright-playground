package ovh.kania.m6;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.KeyboardModifier;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.WaitUntilState;

import ovh.kania.common.BaseTest;

public class PageTest extends BaseTest{

	@Test
	void pageTest(){
		
		page.navigate("url");
		
		page.navigate("url", new Page.NavigateOptions().setTimeout(10000)); //default value is 30 sec
		
		//page state:
		//1. DOMCONTENTLOADED - html is loaded; css and js NOT loaded
		//2. LOAD - html, css, js are loaded. Default state.
		//3. NETWORKIDLE - no more request after 500 ms
		page.navigate("url", new Page.NavigateOptions().setWaitUntil(WaitUntilState.LOAD));

		//.setReferer - url-www will be know that, we came from google.com
		page.navigate("url-www", new Page.NavigateOptions().setReferer("https://google.com"));
		
		//page navigation
		page.reload();
		page.goBack();
		page.goForward();

		//.setClickCount(10) - if you want add 10 item to basket
		page.click("selector", new Page.ClickOptions().setClickCount(10));
		
		//click right button
		page.click("selector", new Page.ClickOptions().setButton(MouseButton.RIGHT));

		//ctrl+alt
		page.click("selector", new Page.ClickOptions().setModifiers(Arrays.asList(KeyboardModifier.CONTROL, KeyboardModifier.ALT)));

		//double click
		page.dblclick("selector");

		//checkbox
		page.check("selector"); //mark checkbox
		page.uncheck("selector"); //unmark checkbox
		
	}	
}
