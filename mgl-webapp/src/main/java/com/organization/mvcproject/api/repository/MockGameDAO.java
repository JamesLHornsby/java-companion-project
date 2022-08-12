package com.organization.mvcproject.api.repository;

import java.util.List;

import com.organization.mvcproject.api.model.Game;

public interface MockGameDAO {

	Game updateGame(Game game);

	Game saveGame(Game game);

	Game findGameById(Long id);

	boolean deleteGame(Game game);

	List<Game> filterByGenre(String genre);

	List<Game> retrieveAllGames();
}
