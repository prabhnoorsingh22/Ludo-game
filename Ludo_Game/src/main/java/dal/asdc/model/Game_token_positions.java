package dal.asdc.model;

import org.springframework.stereotype.Component;

import dal.asdc.model.interfaces.IGame_token_positions;

/**
 * @author Reshma Unnikrishnan**/

@Component
public class Game_token_positions implements IGame_token_positions{
	public String move_token;
	public String turn;

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	public String getMove_token() {
		return move_token;
	}

	public void setMove_token(String move_token) {
		this.move_token = move_token;
	}	
}
