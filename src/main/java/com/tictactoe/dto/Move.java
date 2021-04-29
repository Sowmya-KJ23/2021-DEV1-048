package com.tictactoe.dto;

public class Move {

	private static final Integer minCellNum = 1;
	private static final Integer maxCellNum = 9;
	
	private Long id;
	
	private Game game;
	
	private Integer cellnumber;
	
	private Player playerType;
	
	private Boolean active = true;
	
	public Move() {
		
	}
	
	public Move(Game game, Player player, Integer cellnum) {
		
	}
	
	private void checkPlayedCell(Game game, Integer cellnum) {
		
	}
	
	private void checkPlayer(Game game, Player player) {
		
	}
	
	public void setCellNumber(Integer cellNum) {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Integer getCellnumber() {
		return cellnumber;
	}

	public void setCellnumber(Integer cellnumber) {
		this.cellnumber = cellnumber;
	}

	public Player getPlayerType() {
		return playerType;
	}

	public void setPlayerType(Player playerType) {
		this.playerType = playerType;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public static Integer getMincellnum() {
		return minCellNum;
	}

	public static Integer getMaxcellnum() {
		return maxCellNum;
	}
	
}
