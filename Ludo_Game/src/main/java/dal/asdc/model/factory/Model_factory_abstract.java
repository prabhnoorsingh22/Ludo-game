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

public abstract class Model_factory_abstract {
	
	public abstract IDash_menu create_dash_menu();
	
	public abstract IGame_menu create_game_menu();
	
	public abstract IMain_menu create_main_menu(); 
	
	public abstract IGame_player_score create_game_player_score();

	public abstract IGame_token_positions create_game_token_positions();
	
	public abstract IGame create_game();
	
	public abstract IPlayer create_player();
	
	public abstract ITournaments create_tournaments();
}
