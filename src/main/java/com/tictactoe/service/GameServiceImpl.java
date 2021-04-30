package com.tictactoe.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tictactoe.dto.Game;
import com.tictactoe.repository.GameRepository;

@Service
public class GameServiceImpl implements GameService{
	
	private GameRepository repository;
	
	public GameServiceImpl(GameRepository repository) {
		this.repository = repository;
	}
	
	public Iterable<Game> list(){
		return this.repository.findAllByOrderByIdDesc();
	}
	
	public Optional<Game> load(Long id){
		return this.repository.findById(id);
	}
	public Game save(Game game) {
		return this.repository.save(game);
	}
}
