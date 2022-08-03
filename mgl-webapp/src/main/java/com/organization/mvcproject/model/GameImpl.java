package com.organization.mvcproject.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.service.GameServiceImpl;

@Component
public class GameImpl implements Game {

	private Long gameId;
	private String gameName;
	private String gameGenre;

	@Override
	public Long getGameId() {
		return gameId;
	}

	@Override
	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	@Override
	public String getGameName() {
		return gameName;
	}

	@Override
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	@Override
	public String getGameGenre() {
		return gameGenre;
	}

	@Override
	public void setGameGenre(String gameGenre) {
		this.gameGenre = gameGenre;
	}

}
