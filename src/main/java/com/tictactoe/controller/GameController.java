package com.tictactoe.controller;

import org.springframework.web.bind.annotation.*;

import com.tictactoe.service.GameService;

@RestController
public class GameController {

	private GameService service;
	
	public GameController(GameService service) {
		this.service = service;
	}
}
