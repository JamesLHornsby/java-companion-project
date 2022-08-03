package com.organization.mvcproject.api.repository;

import com.organization.mvcproject.model.GameImpl;

public interface MockGameDAO {

	GameImpl updateGame(GameImpl game);

	GameImpl saveGame(GameImpl game);

	GameImpl findGameById(Long id);

	boolean deleteGame(Long id);

}
