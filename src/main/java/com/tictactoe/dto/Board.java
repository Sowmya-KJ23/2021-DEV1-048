package com.tictactoe.dto;

import java.util.Arrays;

public class Board {
	
	public static int boardSize=9;
	
	Cell[] cells;
	
	public Board() {
		super();
		this.setCells(new Cell[boardSize]);
		for(int i=0;i<boardSize;i++) {
			this.getCells()[i] = new Cell(i+1,null);
		}
	}
	
	public Board(Game game) {
		this();
		game.getMoves().forEach(move ->{
			this.cells[move.getCellnumber()-1].setType(move.getPlayerType());
		});
	}
	
	public Cell[] getCells() {
		return cells;
	}

	public void setCells(Cell[] cells) {
		this.cells = cells;
	}

	public boolean isFull() {
		return Arrays.stream(this.cells).anyMatch(Cell::isNotEmpty);
	}
	
	private int getWinner(PlayerType type) {
		for(int y = 0; y < 3; y++){
            boolean winning = true;
            for(int x=0; x < 3; x++){
                if(!type.equals(this.getCells()[(y * 3) + x].getType())){
                    winning = false;
                    break;
                }
            }
            if(winning) return y +1;
        }
		for(int x = 0; x < 3; x++){
            boolean winning = true;
            for(int y=0; y < 3; y++){
                if(!type.equals(this.getCells()[(y * 3) + x].getType())){
                    winning = false;
                    break;
                }
            }
            if(winning) return x + 1;
        }
		 for(int i = 0; i < 3; i++){
	            if(!type.equals(this.getCells()[(i * 3) + i].getType())){
	                return 0;
	            }
	        }
           return 0;
	}
}
