package com.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import com.tictactoe.dto.Game;
import com.tictactoe.dto.GameStatusType;
import com.tictactoe.dto.Move;
import com.tictactoe.dto.Player;
import com.tictactoe.dto.PlayerType;
import com.tictactoe.exception.InvalidInputException;
import com.tictactoe.exception.InvalidPlayerException;
import com.tictactoe.exception.InvalidPlayerOrderException;
import com.tictactoe.exception.MyException;
import com.tictactoe.service.GameService;
import com.tictactoe.service.MoveService;

import org.junit.jupiter.api.Assertions;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {

	private Player playerFirst = new Player("XXX", PlayerType.X);
	private Player playerSecond = new Player("OOO", PlayerType.O);
	private Integer validInput = 3;
	private Integer invalidInputOne = 15;
	private Integer invalidInputTwo = 0;
	private Game game;
	
	@Autowired
	MoveService moveService;
	
	@Autowired
	GameService gameService;
	
	@Test
	public void testPlayerAlter() throws Exception{
		Assertions.assertThrows(MyException.class, () ->{
			this.addMove(this.game,this.playerFirst,5);
			this.addMove(this.game,this.playerFirst,6);
		});
	}
	
	@Test
	public void testPlayer() throws Exception{
		Assertions.assertThrows(MyException.class, () -> {
			this.addMove(this.game,this.playerSecond, validInput);
		});
	}
	
	@Test
	public void testInvalidInputGreaterThan() throws Exception{
		Assertions.assertThrows(MyException.class, () -> {
			this.addMove(this.game, this.playerFirst,invalidInputOne);
		});
	}
	
	@Test
	public void testInvalidInputLesserThan() throws Exception{
		Assertions.assertThrows(MyException.class, () -> {
			this.addMove(this.game, this.playerFirst,invalidInputTwo);
		});
	}
	
	@Test
	public void testPlayedCellNotEmpty() throws Exception{
		Assertions.assertThrows(MyException.class, () -> {
			this.addMove(this.game,this.playerFirst,5);
			this.addMove(this.game,this.playerSecond,5);
		});
	}
	
	@Test
	public void testDraw() throws Exception{
		this.addMove(this.game,this.playerFirst,1);
		this.addMove(this.game,this.playerSecond,2);
		this.addMove(this.game,this.playerFirst,5);
		this.addMove(this.game,this.playerSecond,9);
		this.addMove(this.game,this.playerFirst,3);
		this.addMove(this.game,this.playerSecond,7);
		this.addMove(this.game,this.playerFirst,8);
		this.addMove(this.game,this.playerSecond,4);
		this.addMove(this.game,this.playerFirst,6);
		
		Assert.isTrue(GameStatusType.Draw.equals(game.getGameStatus().getStatusType()),"Status must be Draw");
		
	}

	@Test
	public void testGameOver() throws Exception{
		this.addMove(this.game,this.playerFirst,5);
		this.addMove(this.game,this.playerSecond,1);
		this.addMove(this.game,this.playerFirst,4);
		this.addMove(this.game,this.playerSecond,2);
		this.addMove(this.game,this.playerFirst,6);
		
		Assert.isTrue(GameStatusType.Over.equals(game.getGameStatus().getStatusType()), "Status must be Gameover");
	}
	
	private Move addMove(Game game, Player player, Integer number) throws Exception{
		Move move = new Move(game,player, number);
		this.moveService.save(move);
		game.addMove(move);
		this.gameService.save(game);
		return move;
	}
}
