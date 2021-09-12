package dal.asdc.movement;
/**
 * @author Kishan Rakeshbhai Patel **/
import java.util.List;

import dal.asdc.player.Player;
import dal.asdc.playing_pieces.Token;

public interface IMake_move {
	boolean check_moving_path(Token token, int dice_number);
	
	List<Token> play_move(Token selected_token, int dice_number, List<Player> all_players);
	
	int get_index_of_token_on_path(int[][] token_position, int
			[][] token_path);
	
	List<Token> add_all_tokens_other_than_selected_into_list(Token selected_token, List<Player> all_players);
	
	boolean is_defeat_move_or_not(int[][] after_move_position, Token selected_token, List<Token> all_tokens);
	 
	boolean is_move_into_safe_box_or_not(int[][] after_move_position, int[][] safe_box);

	List<Token> move_token_out_of_home(Token selected_token);

	List<Token> move_token_in_winning_square(Token selected_token);

	List<Token> move_token_to_defeat_opponent(Token selected_token, int[][] after_move_position);

	List<Token> move_token_on_normal_path(Token selected_token, int[][] after_move_position);
}
