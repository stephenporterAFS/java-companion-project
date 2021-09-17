package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.api.dao.MockGameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;

@Repository
public class MockGameDAOImpl implements MockGameDAO {
	
	

	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<GameImpl> games = new ArrayList<GameImpl>();

	static {
		games = populateGames();
	}

	private static List<GameImpl> populateGames() {

		GameImpl game1 = new GameImpl();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		GameImpl game2 = new GameImpl();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		GameImpl game3 = new GameImpl();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}
	// CRUD: Read
	@Override
	public List<GameImpl> getAllGames() {
		return games;
	}
	
	// CRUD: Create & Update
	@Override
	public Game saveGame(GameImpl game) {
		if (game.getId() != null) {
			GameImpl foundGame = findGameById(game.getId());
			if (foundGame != null) {
				for (int i = 0; i < games.size(); i++) {
					if (game.getId().equals(games.get(i).getId())) {
						return games.set(i, game);
					}
				}
			}
			// If ID was provided but game not found...
		}
		
		game.setId(++gameId);
		games.add(game);
		return game;
	}
	
	@Override
	public GameImpl findGameById(Long id) {
		for (GameImpl game : games) {
			if (id.equals(game.getId())) {
				return game;
			}
		}
		return null;
	}
	
	// CRUD: Delete
	@Override
	public Boolean deleteGame(Long gameId) {
		for (int i = 0; i < games.size(); i++) {
			if (gameId.equals(games.get(i).getId())) {
				return games.remove(games.get(i));
			}
		}
		return false;
	}
}
