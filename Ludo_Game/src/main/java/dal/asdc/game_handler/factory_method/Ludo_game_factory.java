package dal.asdc.game_handler.factory_method;
/**
 * @author Kishan Rakeshbhai Patel **/

import java.util.Map;

import dal.asdc.game_handler.IDice;
import dal.asdc.game_handler.IInput_parser;
import dal.asdc.game_handler.ILudo_game;

public abstract class Ludo_game_factory {
	public abstract IInput_parser create_input_parser(); 
	public abstract ILudo_game create_ludo_game(String game_type, Map<Integer,String> player_list);
	public abstract IDice create_dice();
}
