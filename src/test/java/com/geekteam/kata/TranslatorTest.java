package com.geekteam.kata;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;

public class TranslatorTest {

	Translator translator = new Translator();
	TranslatorListener listener = mock(TranslatorListener.class);

	@Before
	public void setup() {
		translator.listener = listener;
	}
	
	@Test
	public void canParseAnOpponentName() {
		
		translator.translateMatchInfo("opponentName=FATBOTSLIM"
				+ "&pointsToWin=1000"
				+ "&maxRounds=2100"
				+ "&dynamiteCount=100");
		
		verify(listener).receiveMatchData(argThat(hasOpponentName("FATBOTSLIM")));
	}

	@Test
	public void canParseAllFields() {
		
		translator.translateMatchInfo("opponentName=FATBOTSLIM"
				+ "&pointsToWin=1000"
				+ "&maxRounds=2100"
				+ "&dynamiteCount=100");
		
		MatchData matchData = new MatchData("FATBOTSLIM", 1000, 2100, 100);
		verify(listener).receiveMatchData(matchData);
	}

	@Test
	public void canParseOpponentMove() {
		translator.translateOpponentMove("lastOpponentMove=ROCK");
		
		verify(listener).recieveOpponentMove("ROCK");
	}
	
	private MatchDataWithName hasOpponentName(String expectedName) {
		return new MatchDataWithName(expectedName);
	}
	
	
	class MatchDataWithName extends ArgumentMatcher<MatchData> {
		private String expectedName;
		
		public MatchDataWithName(String expectedName) {
			this.expectedName = expectedName;
		}
		
		public boolean matches(Object matchData) {
			return ((MatchData)matchData).getOpponentName().equals(expectedName);
		}
	}
}
