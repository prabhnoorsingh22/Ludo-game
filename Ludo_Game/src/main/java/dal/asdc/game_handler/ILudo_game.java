package dal.asdc.game_handler;

/**
 * @author Kishan Rakeshbhai Patel **/

import java.util.Map;

public interface ILudo_game {
	String get_current_turn_text();
	Map<String,String> get_position_of_all_tokens();
	boolean roll_dice();
	String get_error_message();
	int get_dice_number();
	boolean user_input_receiver(String input);
}
