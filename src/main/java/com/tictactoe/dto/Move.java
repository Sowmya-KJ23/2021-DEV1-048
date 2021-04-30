package com.tictactoe.dto;

import java.util.*;

import javax.persistence.*;

import com.tictactoe.exception.MyException;

@Entity
@Table(name = "move")
public class Move {

	private static final Integer minCellNum = 1;
	private static final Integer maxCellNum = 9;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
	@SequenceGenerator(name = "seq", sequenceName = "seqid", allocationSize = 1)
	private Long id;
	
	@ManyToOne
	private Game game;
	
	private Integer cellnumber;
	
	@Enumerated(EnumType.STRING)
	private PlayerType playerType;
	
	private Boolean active = true;
	
	public Move() {
		super();
	}
	
	public Move(Game game, Player player, Integer cellnum) throws MyException {
		this.game = game;
		this.playerType = player.getType();
		this.cellnumber = cellnum;
		this.checkCellNumber(game, cellnum);
		this.checkEmptyCell(game, cellnum);
		this.checkPlayer(game, player);
		
	}
	
	private void checkCellNumber(Game game,Integer cellnum) throws MyException {
		List<Move> moves = game.getMoves();
		 if(moves.size()>9) {
			throw new MyException("Exceeded the possible moves!Total number of moves cannot exceed 9");
		}
		 if((cellnum<=0) | (cellnum>9)) {
			 throw new MyException("Invalid Cell number. Enter a valid number.");
		 }
		 
	}
	private void checkEmptyCell(Game game, Integer cellnum) throws MyException {
		if(!game.cellIsEmpty(cellnum))
			throw new MyException("Invalid Cell: "+cellnum+ ". Entered cell is not empty.");
	}
	
	private void checkPlayer(Game game, Player player) throws MyException {
		List<Move> moves = game.getMoves();
		if(moves.size()==0) {
			if(!PlayerType.X.equals(player.getType())) {
				throw new MyException("Invalid player order: "+player.getType().toString()+ ".Player X must play first.");
			}
		}
		
		else {
			PlayerType last = game.getLastMovePlayerType();
			if(player.getType().equals(last)) {
				throw new MyException("Player "+player.getType().toString()+"Same player cannot do 2 turns");
			}
		}
		
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

	public PlayerType getPlayerType() {
		return playerType;
	}

	public void setPlayerType(PlayerType playerType) {
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
