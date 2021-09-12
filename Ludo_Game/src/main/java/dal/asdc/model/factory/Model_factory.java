package dal.asdc.model.factory;

import dal.asdc.model.Dash_menu;
import dal.asdc.model.Game;
import dal.asdc.model.Game_menu;
import dal.asdc.model.Game_player_score;
import dal.asdc.model.Game_token_positions;
import dal.asdc.model.Main_menu;
import dal.asdc.model.Player;
import dal.asdc.model.Tournaments;
import dal.asdc.model.interfaces.IDash_menu;
import dal.asdc.model.interfaces.IGame;
import dal.asdc.model.interfaces.IGame_menu;
import dal.asdc.model.interfaces.IGame_player_score;
import dal.asdc.model.interfaces.IGame_token_positions;
import dal.asdc.model.interfaces.IMain_menu;
import dal.asdc.model.interfaces.IPlayer;
import dal.asdc.model.interfaces.ITournaments;

/**
 * @author Reshma Unnikrishnan**/

public class Model_factory extends Model_factory_abstract {
	
	public IDash_menu create_dash_menu() {
		return new Dash_menu();
	}
	
	public IGame_menu create_game_menu() {
		return new Game_menu();
	}
	
	public IMain_menu create_main_menu() {
		return new Main_menu();
	}
	
	public IGame_player_score create_game_player_score() {
		return new Game_player_score();
	}

	public IGame_token_positions create_game_token_positions() {
		return new Game_token_positions();
	}
	
	public IGame create_game() {
		return new Game();
	}
	
	public IPlayer create_player() {
		return new Player();
	}
	
	public ITournaments create_tournaments() {
		return new Tournaments();
	}
}
