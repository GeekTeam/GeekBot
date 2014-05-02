package com.geekteam.kata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isIn;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class BotTest {

	private static final List<String> VALID_MOVES = Arrays.asList("ROCK", "PAPER", "SCISSORS", "DYNAMITE", "WATERBOMB");
	private RestTemplate restTemplate = new RestTemplate();

	@Test
	public void makesAMove() throws RestClientException, URISyntaxException {
		assertThat(move(), isIn(VALID_MOVES));
	}

	@Test
	public void canStartAMatch() throws URISyntaxException {
		assertThat(start().getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	@Test
	public void receivesOpponentMove() throws RestClientException, URISyntaxException {
		assertThat(opponentMove().getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	private String move() throws URISyntaxException {
		return restTemplate.getForObject(botUrl("move"), String.class);
	}

	private ResponseEntity<String> start() throws URISyntaxException {
		return restTemplate.postForEntity(botUrl("start"), "opponentName=FATBOTSLIM"
				+ "&pointsToWin=1000"
				+ "&maxRounds=2100"
				+ "&dynamiteCount=100", String.class);
	}

	private ResponseEntity<String> opponentMove() throws URISyntaxException {
		return restTemplate.postForEntity(botUrl("move"), "", String.class);
	}

	private URI botUrl(String string) throws URISyntaxException {
		return new URI("http://localhost:8080/GeekBot/" + string);
	}
}