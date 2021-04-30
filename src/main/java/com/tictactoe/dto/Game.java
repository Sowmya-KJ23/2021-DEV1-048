package com.tictactoe.dto;

import java.util.*;

public class Game {

	
	private Long id;
	private GameStatus gameStatus;
	private List<Move> moves;
	private Boolean active = true;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public GameStatus getGameStatus() {
		return gameStatus;
	}
	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}
	public List<Move> getMoves() {
		return moves;
	}
	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Game() {
		super();	
	}
	
	public Board getBoard() {
		return new Board(this);
	}
	
	public void addMove(Move move) {
		this.getMoves().add(move);
		this.updateStatus(move);
	}
	
	private void updateStatus(Move move) {
		Board board = this.getBoard();
		PlayerType type = move.getPlayerType();
		if(playerWin(board,type))
			return;
		checkBoardIsFull(board);
	}
	
	private boolean playerWin(Board board, PlayerType type) {
		this.setGameStatus(new GameStatus(GameStatusType.Over,type));
		return true;
	}
	
	private void checkBoardIsFull(Board board) {
		if(board.isFull()) {
			this.setGameStatus(new GameStatus(GameStatusType.Draw,null));
		}
	}
}
