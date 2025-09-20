package ovh.kania.module_6;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.options.AriaRole;

import ovh.kania.common.BaseTest;

public class DropdownTest extends BaseTest{

	@Test
	void dropdownTest(){

		page.navigate("https://the-internet.herokuapp.com/dropdown");
		
		//by text/content
		page.selectOption("#dropdown", "Option 2"); //content
		
		//by value
		page.selectOption("#dropdown", "1"); //value
		
	}

	@Test
	void multiSelectDropdown(){

		page.navigate("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
		page.getByRole(AriaRole.LISTBOX).selectOption(new String[]{"ms1", "ms3"});
	}
}
