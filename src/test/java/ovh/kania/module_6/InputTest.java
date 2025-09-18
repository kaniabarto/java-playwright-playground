package ovh.kania.module_6;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;

import ovh.kania.common.BaseTest;

public class InputTest extends BaseTest {

	@Test
	void inputTest(){
		
		//copy - paste, value to input
		page.fill("selector", "value");
		//type letter by letter
		page.type("selector", "text");
		
		//if element is hidden by another element and we want to type value there then we should use FillOptions().setForece()
		page.fill("selector", "value", new Page.FillOptions().setForce(true));
	}
}
