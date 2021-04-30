package com.tictactoe.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tictactoe.service.MoveService;

@RestController
public class MoveController {

	private MoveService service;
}
