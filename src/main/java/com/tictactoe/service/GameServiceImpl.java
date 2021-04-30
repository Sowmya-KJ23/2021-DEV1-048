package com.tictactoe.service;

import com.tictactoe.dto.Game;
import com.tictactoe.repository.GameRepository;

public class GameServiceImpl {
	
	private GameRepository repository;
	
	public Game save(Game game) {
		return this.repository.save(game);
	}
}
