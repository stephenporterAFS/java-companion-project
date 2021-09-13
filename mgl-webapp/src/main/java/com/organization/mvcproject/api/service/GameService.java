package com.organization.mvcproject.api.service;

import java.util.List;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;

public interface GameService {

	List<GameImpl> retrieveAllGames();

	Game saveGame(GameImpl game);
	
	Game findGameById(Long gameId);
	
	Boolean deleteGame(Long gameId);
	
}
