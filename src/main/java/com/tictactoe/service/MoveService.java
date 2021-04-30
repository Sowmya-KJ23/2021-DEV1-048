package com.tictactoe.service;

import java.util.Optional;

import com.tictactoe.dto.Move;
import com.tictactoe.exception.MyException;

public interface MoveService {

	Iterable<Move> list();
	Move save(Move move) throws MyException;
	Optional<Move> load(long id);
}
