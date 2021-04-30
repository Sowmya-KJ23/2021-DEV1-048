package com.tictactoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tictactoe.dto.Move;

public interface MoveRepository extends JpaRepository<Move, Long>{
	
	Iterable<Move> findAllByOrderByIdDesc();
}
