package com.tictactoe.dto;

public class GameStatus {

	private GameStatusType statusType; 
	private PlayerType type;
	
	public GameStatus() {}
	public GameStatus(GameStatusType statusType, PlayerType type) {
		this.statusType = statusType;
		this.type = type;
	}
	public GameStatusType getStatusType() {
		return statusType;
	}
	public void setStatusType(GameStatusType statusType) {
		this.statusType = statusType;
	}
	public PlayerType getType() {
		return type;
	}
	public void setType(PlayerType type) {
		this.type = type;
	}
}
