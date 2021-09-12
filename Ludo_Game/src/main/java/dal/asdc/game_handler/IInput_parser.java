package dal.asdc.game_handler;

/**
 * @author Kishan Rakeshbhai Patel **/

import java.util.List;

import dal.asdc.player.Player;
import dal.asdc.playing_pieces.Token;

public interface IInput_parser {
	boolean check_input(String input);
	char[] get_word_tokens(String input);
	Token get_player_from_input(List<Player> player_list_temp, char[] input_tokens);
}
