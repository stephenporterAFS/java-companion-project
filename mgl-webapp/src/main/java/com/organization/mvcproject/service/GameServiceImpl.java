package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.dao.MockGameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.model.GameImpl;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private MockGameDAO mockGameDAO;
	
	@Override
	public List<GameImpl> retrieveAllGames() {
		return mockGameDAO.getAllGames();
	}

	@Override
	public Game saveGame(GameImpl game) {
		return mockGameDAO.saveGame(game);
	}

	public Game findGameById(Long gameId) {
	return mockGameDAO.findGameById(gameId);
	}
	
	public Boolean deleteGame(Long gameId) {
		return mockGameDAO.deleteGame(gameId);
	}
}