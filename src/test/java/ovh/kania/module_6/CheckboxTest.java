package ovh.kania.module_6;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.options.AriaRole;

import ovh.kania.common.BaseTest;

public class CheckboxTest extends BaseTest{

	@Test
	void checkboxTest(){
		
		page.navigate("https://the-internet.herokuapp.com/checkboxes");

		//checkbox state always will be unchek after refresh 
		page.getByRole(AriaRole.CHECKBOX).first().check();
		
		//checkbox state alwys will be checked after refresh
		page.getByRole(AriaRole.CHECKBOX).last().uncheck();
	}

}
