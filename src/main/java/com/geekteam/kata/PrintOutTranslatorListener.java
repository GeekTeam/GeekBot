package com.geekteam.kata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PrintOutTranslatorListener implements TranslatorListener {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void receiveMatchData(MatchData matchData) {
//		logger.debug(matchData);
	}

	@Override
	public void recieveOpponentMove(String string) {
		// TODO Auto-generated method stub
		
	}

}
