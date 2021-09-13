package com.organization.mvcproject.api.dao;

import java.util.List;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;

public interface MockGameDAO {

	List<GameImpl> getAllGames();

	Game saveGame(GameImpl game);

	Game findGameById(Long id);

	Boolean deleteGame(Long gameId);

}