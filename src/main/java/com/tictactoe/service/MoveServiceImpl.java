package com.tictactoe.service;

import com.tictactoe.dto.Game;
import com.tictactoe.dto.Move;
import com.tictactoe.dto.Player;
import com.tictactoe.exception.MyException;
import com.tictactoe.repository.MoveRepository;

public class MoveServiceImpl {
	private MoveRepository repository;
	
	public MoveServiceImpl(MoveRepository repository) {
		this.repository = repository;
	}

	public Move save(Move move) throws RuntimeException, MyException{
		Game game = new Game();
		Move moveSave = new Move(game, new Player(move.getPlayerType()), move.getCellnumber());
		return this.repository.save(move);
	}
}
