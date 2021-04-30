package com.tictactoe.dto;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class GameStatus {

	@Enumerated(EnumType.STRING)
	private GameStatusType statusType; 
	
	@Enumerated(EnumType.STRING)
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
