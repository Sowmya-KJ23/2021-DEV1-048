package com.tictactoe.dto;

public class Player {

	

	private PlayerType type;
	
	public Player() {
		super();
	}
	
	
	public Player(PlayerType type) {
		this.type=type;
	}


	public PlayerType getType() {
		return type;
	}

	public void setType(PlayerType type) {
		this.type = type;
	}
	
}
