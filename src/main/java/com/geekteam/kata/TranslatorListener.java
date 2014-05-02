package com.geekteam.kata;

public interface TranslatorListener {

	void receiveMatchData(MatchData matchData);

	void recieveOpponentMove(String string);

}
