package ovh.kania.module_6;

import org.junit.jupiter.api.Test;

import ovh.kania.common.BaseTest;

public class TextTest extends BaseTest{

	@Test
	void textTest(){
		
		page.navigate("https://the-internet.herokuapp.com/notification_message_rendered");
		
		// innerHTML = tags + text
		page.innerHTML("#content");

		//innerText = only text
		page.innerText("#content");

		//textContent = visible text + invisible text (display:none)
		page.textContent("#content");

		//getAtribute
		page.getAttribute("div im", "alt");

	}
	
}
