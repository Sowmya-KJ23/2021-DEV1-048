package com.tictactoe.dto;

public class Cell {

	private int number;
	private PlayerType type;
	
	public Cell() {
		super();
	}
	
	public Cell(int num, PlayerType type) {
		this();
		this.number = num;
		this.type=type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public PlayerType getType() {
		return type;
	}

	public void setType(PlayerType type) {
		this.type = type;
	}
	
	public boolean isEmpty() {
		if(type == null)
			return true;
		else
			return false;
		
	}
	
	public boolean isNotEmpty() {
		if(type!=null) 
			return true;
		else
			return false;		
	}
}
