package dal.asdc.movement;
/**
 * @author Kishan Rakeshbhai Patel **/
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import dal.asdc.player.Player;
import dal.asdc.playing_pieces.Token;

public class Make_move implements IMake_move {
	
	private static final int INITIAL_VALUE_OF_TOKEN_INDEX = -1;
	private static final int HIGHEST_NUMBER_ON_DICE = 6;
	ICheck_move check_move = new Check_move();
	List<Token> return_token = null;
	List<Token> all_tokens = null;
	int[][] token_path;
	int[][] safe_box;
	int[][] token_position;
	int token_index_on_path;
	private static final Logger LOGGER = LoggerFactory.getLogger(Make_move.class);
	
	public Make_move() {
	}
	
	public boolean check_moving_path(Token token, int dice_number) {
		if(check_move.check_is_token_movable(token, dice_number)){
			return true;
		}else {
			LOGGER.info("You can't play this token");
			return false;
		}
	}
	
	@Override
	public List<Token> play_move(Token selected_token, int dice_number, List<Player> all_players) {
		token_path = selected_token.get_token_path();
		safe_box = selected_token.get_safe_boxes();
		return_token = new ArrayList<>();
		all_tokens = new ArrayList<>();
		
		if(selected_token.is_home()) {
			if(dice_number==HIGHEST_NUMBER_ON_DICE) {
				LOGGER.info("out of home move");
				return move_token_out_of_home(selected_token);
			}
		}else{
			token_index_on_path = INITIAL_VALUE_OF_TOKEN_INDEX;
			token_position = selected_token.get_coordinate_position();
			token_index_on_path = get_index_of_token_on_path(token_position,token_path);
			all_tokens = add_all_tokens_other_than_selected_into_list(selected_token,all_players);
			if((token_index_on_path+dice_number) < token_path.length) {
				int[][] after_move_position = {{token_path[token_index_on_path+dice_number][0],token_path[token_index_on_path+dice_number][1]}};
				boolean is_defeat = is_defeat_move_or_not(after_move_position,selected_token,all_tokens);
				boolean is_safe = is_move_into_safe_box_or_not(after_move_position,safe_box);

				if(is_defeat && !is_safe) {
					LOGGER.info("defeat move");
					return move_token_to_defeat_opponent(selected_token,after_move_position);
				}else {
					LOGGER.info("normal move");
					return move_token_on_normal_path(selected_token,after_move_position);
				}	
			}else if(token_index_on_path+dice_number == token_path.length) {
				LOGGER.info("at winning square");
				return move_token_in_winning_square(selected_token);
			}
		}
		return return_token;
	}
	
	public boolean is_defeat_move_or_not(int[][] after_move_position, Token selected_token, List<Token> all_tokens) {
		boolean is_defeat = false;
		for(int all_token_counter = 0 ; all_token_counter < all_tokens.size() ; all_token_counter++) {
			Token temp_all_token_holder = all_tokens.get(all_token_counter);
			int[][] temp_all_token_holder_position = temp_all_token_holder.get_coordinate_position();
			if(temp_all_token_holder_position[0][0] == after_move_position[0][0] && temp_all_token_holder_position[0][1] == after_move_position[0][1]) {
				if(temp_all_token_holder.get_token_colour().equals(selected_token.get_token_colour())) {
					is_defeat = false;
				}else {
					is_defeat = true;
					break;
				}
			}
		}
		return is_defeat;
	}
	
	public boolean is_move_into_safe_box_or_not(int[][] after_move_position, int[][] safe_box) {
		boolean is_safe = false;
		for(int safe_box_index = 0 ; safe_box_index < safe_box.length ; safe_box_index++) {
			if(safe_box[safe_box_index][0] == after_move_position[0][0] && safe_box[safe_box_index][1] == after_move_position[0][1]) {
				is_safe = true;
				LOGGER.info("in safe box move");
				break;
			}
		}
		return is_safe;
	}
	
	public List<Token> move_token_out_of_home(Token selected_token){
		int[][] new_position = {{token_path[0][0],token_path[0][1]}};
		selected_token.set_coordinate_position(new_position);
		selected_token.set_is_token_at_home(false);
		return_token.add(selected_token);
		return return_token;
	}
	
	public List<Token> move_token_on_normal_path(Token selected_token, int[][] after_move_position){
		selected_token.set_coordinate_position(after_move_position);
		selected_token.set_is_token_at_home(false);
		selected_token.set_is_token_at_winning_box(false);
		return_token.add(selected_token);
		return return_token;
	}
	
	public List<Token> move_token_to_defeat_opponent(Token selected_token, int[][] after_move_position){
		selected_token.set_coordinate_position(after_move_position);
		selected_token.set_is_token_at_home(false);
		selected_token.set_is_token_at_winning_box(false);
		return_token.add(selected_token);

		for(int all_token_counter = 0 ; all_token_counter < all_tokens.size() ; all_token_counter++) {
			Token temp_all_token_holder = all_tokens.get(all_token_counter);
			int[][] temp_all_token_holder_position = temp_all_token_holder.get_coordinate_position();
			if(temp_all_token_holder_position[0][0] == after_move_position[0][0] &&
					temp_all_token_holder_position[0][1] == after_move_position[0][1]) {
				temp_all_token_holder.set_at_home();
				return_token.add(temp_all_token_holder);
			}
		}
		return return_token;
	}

	public List<Token> move_token_in_winning_square(Token selected_token){
		int[][] winning_zone_coordinates = selected_token.get_winning_square();
		int[][] new_position = {{winning_zone_coordinates[0][0],winning_zone_coordinates[0][1]}};
		selected_token.set_coordinate_position(new_position);
		selected_token.set_is_token_at_winning_box(true);
		return_token.add(selected_token);
		return return_token;
	}
	
	public int get_index_of_token_on_path(int[][] token_position, int[][] token_path) {
		int temp_path_index = 0;
		for(int path_index = 0; path_index < token_path.length ; path_index++) {
			if(token_path[path_index][0] == token_position[0][0] && token_path[path_index][1] == token_position[0][1]) {
				temp_path_index = path_index;
			}
		}
		return temp_path_index;
	}

	@Override
	public List<Token> add_all_tokens_other_than_selected_into_list(Token selected_token, List<Player> all_players) {
		List<Token> all_token_bucket = new ArrayList<>();
		for(int player_count = 0 ; player_count < all_players.size() ; player_count++) {

			Player temp_player = all_players.get(player_count);
			List<Token> temp_player_tokens = temp_player.get_all_tokens();
			for(int tokens = 0 ; tokens < temp_player_tokens.size() ; tokens++) {
				if(temp_player_tokens.get(tokens).get_token_colour().equals(selected_token.get_token_colour()) && 
						temp_player_tokens.get(tokens).get_token_number() == selected_token.get_token_number()) {
					continue;
				}else {
					all_token_bucket.add(temp_player_tokens.get(tokens));
				}
			}
		}
		return all_token_bucket;
	}

}

