package com.organization.mvcproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.repository.MockGameDAO;
import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.repository.MockGameDAOImpl;


@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private MockGameDAO gameDAO;

	@Override
	public List<Game> retrieveAllGames() {
		return gameDAO.retrieveAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		return gameDAO.saveGame(game);
	}
	
	@Override
	public Game updateGame(Game game) {
		return gameDAO.updateGame(game);
	}
	
	@Override
	public Game findGameById(Long id) {
		return gameDAO.findGameById(id);
	}
	
	@Override
	public boolean deleteGame(Game game) {
		return gameDAO.deleteGame(game);
	}

	@Override
	public List<Game> findGamesByGenre(String genre) {
		return gameDAO.filterByGenre(genre);
	}

}