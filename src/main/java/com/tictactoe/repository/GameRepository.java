package com.tictactoe.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.tictactoe.dto.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

	Iterable<Game> findAllByOrderByIdDesc();
}
