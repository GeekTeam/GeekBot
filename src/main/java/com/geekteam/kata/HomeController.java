package com.geekteam.kata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	public Translator translator;
	
	@RequestMapping(value = "/move", method = RequestMethod.GET)
	public ResponseEntity<String> makeMove() {

		logger.info("move");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/plain");
		
		return new ResponseEntity<String>("SCISSORS", headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/move", method = RequestMethod.POST)
	public ResponseEntity<String> receiveOpponentMove(@RequestBody String opponentMove) {

		logger.info("Opponent move was: " + opponentMove);
		
		
		translator.translateOpponentMove(opponentMove);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/start" , method = RequestMethod.POST)
	public ResponseEntity<String> start(@RequestBody String matchInfo) {
		
		logger.info("Start");
		
		logger.info("Match Info: " + matchInfo);
		
		translator.translateMatchInfo(matchInfo);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
 
}
