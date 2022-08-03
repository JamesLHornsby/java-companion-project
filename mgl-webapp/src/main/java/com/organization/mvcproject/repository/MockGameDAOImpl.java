package com.organization.mvcproject.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.api.repository.MockGameDAO;
import com.organization.mvcproject.model.GameImpl;

@Repository
public class MockGameDAOImpl implements MockGameDAO {

	
	private static Long gameId = new Long(0);

	public static List<GameImpl> games = new ArrayList<GameImpl>();


	static {
		games = populateGames();
	}
	
	private static List<GameImpl> populateGames() {

		GameImpl game1 = new GameImpl();
		game1.setGameId(++gameId);
		game1.setGameGenre("Sport");
		game1.setGameName("Rocket League");

		GameImpl game2 = new GameImpl();
		game2.setGameId(++gameId);
		game2.setGameGenre("Shooter");
		game2.setGameName("Halo 3");

		GameImpl game3 = new GameImpl();
		game3.setGameId(++gameId);
		game3.setGameGenre("MMORPG");
		game3.setGameName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}

	public List<GameImpl> retrieveAllGames() {
		return games;
	}
	@Override
	public GameImpl saveGame(GameImpl game) {
		game.setGameId(++gameId);
		games.add(game);
		return game;
	}
	@Override
	public GameImpl updateGame(GameImpl game) {
		if(game.getGameId() != null) {
			GameImpl foundGame = findGameById(game.getGameId());
			if(foundGame != null) {
				//update the game in the list
				//find game in the list
				for (int i=0; i<games.size(); i++) {
					if (game.getGameId().equals(games.get(i).getGameId())) {
						games.set(i, game);
						return games.get(i);
					}
				}
			}
			//optionally we could throw an error showing this game doesn't exist
		}
		return saveGame(game); //game doesn't exist, so we're saving it as new
	}
	@Override
	public GameImpl findGameById(Long id) {
		//for each loop
		for (GameImpl game : games) {
			if(id.equals(game.getGameId())) {
				return game;
			}
		}
		//if no game found
		return null;
	}
	@Override
	public boolean deleteGame(Long id) {
		for (int i=0; i<games.size();i++) {
			if(id == games.get(i).getGameId()) {
				return games.remove(games.get(i));
			}
		}
		return false;
	}


}
