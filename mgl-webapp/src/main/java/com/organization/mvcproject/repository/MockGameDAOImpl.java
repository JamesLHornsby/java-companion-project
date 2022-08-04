package com.organization.mvcproject.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.repository.MockGameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;

@Repository
public class MockGameDAOImpl implements MockGameDAO {

	
	private static Long gameId = new Long(0);
	public static List<GameImpl> gameImpls = new ArrayList<>();


	static {
		gameImpls = populateGames();
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

		gameImpls.add(game1);
		gameImpls.add(game2);
		gameImpls.add(game3);

		return gameImpls;
	}

	public List<Game> retrieveAllGames() {
		return ImmutableList.copyOf(gameImpls);
	}
	@Override
	public Game saveGame(Game game) {
		game.setGameId(++gameId);
		gameImpls.add((GameImpl) game);
		return game;
	}
	@Override
	public Game updateGame(Game game) {
		if(game.getGameId() != null) {
			Game foundGame = findGameById(game.getGameId());
			if(foundGame != null) {
				//update the game in the list
				//find game in the list
				for (int i=0; i<gameImpls.size(); i++) {
					if (game.getGameId().equals(gameImpls.get(i).getGameId())) {
						gameImpls.set(i, (GameImpl) game);
						return (Game) gameImpls.get(i);
					}
				}
			}
			//optionally we could throw an error showing this game doesn't exist
		}
		return saveGame(game); //game doesn't exist, so we're saving it as new
	}
	@Override
	public Game findGameById(Long id) {
		//for each loop
		for (Game game : gameImpls) {
			if(id.equals(game.getGameId())) {
				return game;
			}
		}
		//if no game found
		return null;
	}
	@Override
	public boolean deleteGame(Long id) {
		for (int i=0; i<gameImpls.size();i++) {
			if(id == gameImpls.get(i).getGameId()) {
				return gameImpls.remove(gameImpls.get(i));
			}
		}
		return false;
	}
	
	public List<Game> findGamesByGenre(String genre) {
		List<Game> gamesOfGenre = new ArrayList<>();
		for(int i=0; i< gameImpls.size();i++) {
			if (genre == gameImpls.get(i).getGameGenre()) {
				gamesOfGenre.add(gameImpls.get(i));
			}
		}
		return (gamesOfGenre.isEmpty()) ? null : gamesOfGenre;
	}


}
