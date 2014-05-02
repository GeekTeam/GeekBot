package com.geekteam.kata;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Translator {

	@Autowired
	TranslatorListener listener;

	public void translateMatchInfo(String unparsedMatchInfo) {

		HashMap<String, String> params = new HashMap<String, String>();

		String[] pairs = unparsedMatchInfo.split("&");

		for (String pair : pairs) {
			String[] split = pair.split("=");
			params.put(split[0], split[1]);
		}

		MatchData matchData = new MatchData(params.get("opponentName"),
				Integer.parseInt(params.get("pointsToWin")),
				Integer.parseInt(params.get("maxRounds")),
				Integer.parseInt(params.get("dynamiteCount")));
		listener.receiveMatchData(matchData);
	}

	public void translateOpponentMove(String opponentMove) {

		String[] split = opponentMove.split("=");		
		listener.recieveOpponentMove(split[1]);		
	}

}
