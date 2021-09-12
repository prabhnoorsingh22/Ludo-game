package dal.asdc.game_handler.factory_method;
/**
 * @author Kishan Rakeshbhai Patel **/

import java.util.Map;

import dal.asdc.game_handler.Dice;
import dal.asdc.game_handler.IDice;
import dal.asdc.game_handler.IInput_parser;
import dal.asdc.game_handler.ILudo_game;
import dal.asdc.game_handler.Input_parser;
import dal.asdc.game_handler.Ludo_game;

public class Four_player_ludo_game_factory extends Ludo_game_factory{

	@Override
	public IInput_parser create_input_parser() {
		return new Input_parser();
	}

	@Override
	public ILudo_game create_ludo_game(String game_type, Map<Integer, String> player_list) {
		return new Ludo_game(game_type, player_list);
	}

	@Override
	public IDice create_dice() {
		return new Dice();
	}
	
}
