package com.tictactoe.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.tictactoe.dto.Game;
import com.tictactoe.service.GameService;

@RequestMapping("/game")
@RestController
public class GameController {

	private GameService service;
	
	public GameController(GameService service) {
		this.service = service;
	}
	
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Game> list(){
		return this.service.list();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value="/{id}")
	public Optional<Game> load(@PathVariable("id") Long id){
		return this.service.load(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Game create(@RequestBody Game entity) {
        return this.service.save(entity);
    }
}
