package com.organization.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;

@RequestMapping(value="/game")
@RestController
public class GameController {

	@Autowired
	private GameService gameService;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<List<Game>>(gameService.retrieveAllGames(), HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody GameImpl game) {
		gameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	//Update
	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateGame(@RequestBody GameImpl game) {
	
		gameService.updateGame(game);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// URL will be localhost:8081/game (DELETE 
	@PostMapping(value="/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteGame(@RequestBody GameImpl game ){
		gameService.deleteGame(game);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	
}