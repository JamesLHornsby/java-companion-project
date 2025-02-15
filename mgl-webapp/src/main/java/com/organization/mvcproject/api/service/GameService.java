package com.organization.mvcproject.api.service;

import java.util.List;

import com.organization.mvcproject.api.model.Game;

public interface GameService {

	List<Game> retrieveAllGames();
	
	List<Game> findGamesByGenre(String genre);

	Game saveGame(Game game);

	Game updateGame(Game game);

	boolean deleteGame(Game game);

	Game findGameById(Long id);

}
