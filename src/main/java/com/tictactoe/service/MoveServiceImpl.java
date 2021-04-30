package com.tictactoe.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tictactoe.dto.Game;
import com.tictactoe.dto.Move;
import com.tictactoe.dto.Player;
import com.tictactoe.exception.MyException;
import com.tictactoe.repository.GameRepository;
import com.tictactoe.repository.MoveRepository;

@Service
public class MoveServiceImpl implements MoveService{
	private MoveRepository repository;
	private GameService gameService;
	
	public MoveServiceImpl(MoveRepository repository, GameService service) {
		this.repository = repository;
		this.gameService = service;
	}

	public Iterable<Move> list(){
		return this.repository.findAllByOrderByIdDesc();
	}
	
	public Optional<Move> load(Long id){
		return this.repository.findById(id);
	}
	public Move save(Move move) throws MyException{
		Optional<Game> optional = this.gameService.load(move.getGame().getId());
		if(optional.isPresent()) {
			Game game = optional.get();
			Move moveSave = new Move(game,new Player(move.getPlayerType()),move.getCellnumber());
			return this.repository.save(moveSave);
		}
		else {
			throw new MyException("Specifies game id (" +move.getGame().getId()+") does not exist!");
		}
		
	}

	@Override
	public Optional<Move> load(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
