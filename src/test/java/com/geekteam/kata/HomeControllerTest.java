package com.geekteam.kata;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class HomeControllerTest {

	Translator translator = mock(Translator.class);
	HomeController homeController = new HomeController();

	@Before
	public void setUp() {
		homeController.translator = translator;
	}
	
	
	@Test
	public void delegatesTranslationOfMatchData() {

		homeController.start("test-match-data");
		
		verify(translator).translateMatchInfo("test-match-data");
	}

}
