package com.organization.mvcproject.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.model.Game;

@Repository
public class MockGameDAO {

	
	private static Long gameId = new Long(0);

	public static List<Game> games = new ArrayList<Game>();


	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new Game();
		game1.setGameId(++gameId);
		game1.setGameGenre("Sport");
		game1.setGameName("Rocket League");

		Game game2 = new Game();
		game2.setGameId(++gameId);
		game2.setGameGenre("Shooter");
		game2.setGameName("Halo 3");

		Game game3 = new Game();
		game3.setGameId(++gameId);
		game3.setGameGenre("MMORPG");
		game3.setGameName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}

	public List<Game> retrieveAllGames() {
		return games;
	}

	public Game saveGame(Game game) {
		game.setGameId(++gameId);
		games.add(game);
		return game;
	}
	
	public Game updateGame(Game game) {
		if(game.getGameId() != null) {
			Game foundGame = findGameById(game.getGameId());
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
	
	public Game findGameById(Long id) {
		//for each loop
		for (Game game : games) {
			if(id.equals(game.getGameId())) {
				return game;
			}
		}
		//if no game found
		return null;
	}

	public boolean deleteGame(Long id) {
		for (int i=0; i<games.size();i++) {
			if(id == games.get(i).getGameId()) {
				return games.remove(games.get(i));
			}
		}
		return false;
	}


}
