package com.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
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
import com.tictactoe.exception.NotEmptyException;
import com.tictactoe.service.GameService;
import com.tictactoe.service.MoveService;

import org.junit.jupiter.api.Assertions;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTests {

	private Player playerFirst = new Player(PlayerType.X);
	private Player playerSecond = new Player(PlayerType.O);
	private Integer validInput = 3;
	private Integer invalidInputOne = 15;
	private Integer invalidInputTwo = 0;
	private Game game;
	
	@Autowired
	MoveService moveService;
	
	@Autowired
	GameService gameService;
	
	@BeforeEach
    public void setUp(){
        this.game = new Game();
        this.gameService.save(game);
    }
	
	/*
	 * Check for alternate plays
	 */	
	@Test
	public void testPlayerAlter() throws Exception{
		Assertions.assertThrows(MyException.class, () ->{
			this.addMove(this.game,this.playerFirst,5);
			this.addMove(this.game,this.playerFirst,6);
		});
	}
	
	/*
	 * check for player X starts first
	 */
	@Test
	public void testPlayer() throws Exception{
		Assertions.assertThrows(MyException.class, () -> {
			this.addMove(this.game,this.playerSecond, validInput);
		});
	}
	
	/*
	 * Check the input cell number is not greater than 9
	 */
	@Test
	public void testInvalidInputGreaterThan() throws Exception{
		Assertions.assertThrows(MyException.class, () -> {
			this.addMove(this.game, this.playerFirst,invalidInputOne);
		});
	}
	
	/*
	 * check for input cell number less than 1
	 */
	@Test
	public void testInvalidInputLesserThan() throws Exception{
		Assertions.assertThrows(MyException.class, () -> {
			this.addMove(this.game, this.playerFirst,invalidInputTwo);
		});
	}
	
	/*
	 * check for not placing the input on the non empty slot 
	 */
	@Test
	public void testPlayedCellNotEmpty() throws Exception{
		Assertions.assertThrows(NotEmptyException.class, () -> {
			this.addMove(this.game,this.playerFirst,5);
			this.addMove(this.game,this.playerSecond,5);
		});
	}
	
	/*
	 * check for game draw
	 */
	@Test
	public void testDraw() throws Exception{
		
		this.addMove(this.game, this.playerFirst, 5);
        this.addMove(this.game, this.playerSecond, 1);
        this.addMove(this.game, this.playerFirst, 3);
        this.addMove(this.game, this.playerSecond, 7);
        this.addMove(this.game, this.playerFirst, 9);
        this.addMove(this.game, this.playerSecond, 6);
        this.addMove(this.game, this.playerFirst, 2);
        this.addMove(this.game, this.playerSecond, 8);
        this.addMove(this.game, this.playerFirst, 4);
		
		//Assert.isTrue(!(GameStatusType.Over).equals(game.getGameStatus().getStatusType()),"Status must not be over");

		Assert.isTrue(GameStatusType.Draw.equals(game.getGameStatus().getStatusType()),"Status must be Draw");
		
	}

	/*
	 * check for game over
	 */
	@Test
	public void testGameOver() throws Exception{
		this.addMove(this.game,this.playerFirst,1);
		this.addMove(this.game,this.playerSecond,2);
		this.addMove(this.game,this.playerFirst,4);
		this.addMove(this.game,this.playerSecond,5);
		this.addMove(this.game,this.playerFirst,7);
		
	//	Assert.isTrue(!(GameStatusType.Draw).equals(game.getGameStatus().getStatusType()), "Status must not be draw!");
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
