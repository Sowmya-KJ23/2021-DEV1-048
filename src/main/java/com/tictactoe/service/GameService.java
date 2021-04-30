package com.tictactoe.service;

import java.util.Optional;

import com.tictactoe.dto.Game;

public interface GameService {

	Iterable<Game> list();
	Optional<Game> load(Long id);
	Game save(Game game);
}
