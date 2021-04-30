package com.tictactoe.dto;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqgame")
    @SequenceGenerator(name = "seqgame", sequenceName = "gameidseq", allocationSize = 1)
	private Long id;
	
	@Embedded
	private GameStatus gameStatus;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "game")
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
	
	public void updateStatus(Move move) {
		Board board = this.getBoard();
		PlayerType type = move.getPlayerType();
		if(playerWin(board,type))
			return;
		checkBoardIsFull(board);
	}
	
	public boolean playerWin(Board board, PlayerType type) {
		this.setGameStatus(new GameStatus(GameStatusType.Over,type));
		return true;
	}
	
	public void checkBoardIsFull(Board board) {
		if(board.isFull()) {
			this.setGameStatus(new GameStatus(GameStatusType.Draw,null));
		}
	}
	
	@Transient
	public Move getLastMove() {
		List<Move> moves = this.getMoves();
        return moves.get(moves.size() - 1);
		
	}
	
	@Transient
	public PlayerType getLastMovePlayerType() {
		try {
			return this.getLastMove().getPlayerType();
		}
		catch(NullPointerException e) {
			return null;
		}
	}
	public boolean cellIsEmpty(Integer num) {
		Board board = this.getBoard();
		Cell cell = board.getCells()[num-1];
		return cell.isEmpty();
	}
}
