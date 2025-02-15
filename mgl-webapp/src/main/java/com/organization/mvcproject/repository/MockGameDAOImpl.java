package com.organization.mvcproject.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		if(game.getGameId() != null) {
			Game foundGame = findGameById(game.getGameId());
			if(foundGame != null) {
				//update the game in the list
				//find game in the list
				gameImpls = gameImpls.stream()
						.map(games -> games.getGameId().equals(game.getGameId()) ? (GameImpl) game : games)
						.collect(Collectors.toList());
				return game;
				
				/*
				 * for (int i=0; i<gameImpls.size(); i++) { if
				 * (game.getGameId().equals(gameImpls.get(i).getGameId())) { gameImpls.set(i,
				 * (GameImpl) game); return (Game) gameImpls.get(i); } }
				 */
			}
			//optionally we could throw an error showing this game doesn't exist
		}
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
	public List<Game> filterByGenre(String genre) {
		return gameImpls.stream()
				.filter(game -> genre.equals(game.getGameGenre()))
				.collect(Collectors.toList());
		/*
		 * for (Game game : gameImpls) { if(id.equals(game.getGameId())) { return game;
		 * } } //if no game found
		 * 
		 * return null;
		 */
		
	}
	@Override
	public boolean deleteGame(Game game) {
		return gameImpls.removeIf(games -> games.getGameId().equals(game.getGameId()));
		/*
		 * for (int i=0; i<gameImpls.size();i++) {
		 * if(game.getGameId().equals(gameImpls.get(i).getGameId())) { return
		 * gameImpls.remove(gameImpls.get(i)); } } return false;
		 */
	}
	


	@Override
	public Game findGameById(Long id) {
		return gameImpls.stream()
				.filter(game -> id.equals(game.getGameId()))
				.findAny()
				.orElse(null);
	}


}
