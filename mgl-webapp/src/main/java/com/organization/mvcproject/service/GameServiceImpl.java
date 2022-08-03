package com.organization.mvcproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.model.GameImpl;
import com.organization.mvcproject.repository.MockGameDAOImpl;


@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private MockGameDAOImpl gameDAO;

	@Override
	public List<GameImpl> retrieveAllGames() {
		return gameDAO.retrieveAllGames();
	}

	@Override
	public GameImpl saveGame(GameImpl game) {
		return gameDAO.saveGame(game);
	}
	
	@Override
	public GameImpl updateGame(GameImpl game) {
		return gameDAO.updateGame(game);
	}
	
	@Override
	public boolean deleteGame(Long id) {
		return gameDAO.deleteGame(id);
	}

}