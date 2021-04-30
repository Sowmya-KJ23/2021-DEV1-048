package com.tictactoe.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tictactoe.dto.Move;
import com.tictactoe.exception.MyException;
import com.tictactoe.service.MoveService;



@RequestMapping("/move")
@RestController
public class MoveController {

	private MoveService service;
	
	public MoveController(MoveService service) {
		this.service = service;
	}
	
	@ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Iterable<Move> list() {
        return this.service.list();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public Optional<Move> load(@PathVariable("id") Long id) {
        return this.service.load(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Move create(@RequestBody Move entity) throws Exception {
        return this.service.save(entity);
    }

}
