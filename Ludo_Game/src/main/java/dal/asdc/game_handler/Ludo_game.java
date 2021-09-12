package dal.asdc.game_handler;
/**
 * @author Kishan Rakeshbhai Patel **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dal.asdc.player.Factory_classes.Player_factory_normal;
import dal.asdc.playing_pieces.Token;
import dal.asdc.game_handler.command.Board_creation_command;
import dal.asdc.game_handler.command.Computer_player_command;
import dal.asdc.game_handler.command.Four_player_command;
import dal.asdc.game_handler.command.Three_player_command;
import dal.asdc.game_handler.command.Two_player_command;
import dal.asdc.game_handler.factory_method.Four_player_ludo_game_factory;
import dal.asdc.game_handler.factory_method.Ludo_game_factory;
import dal.asdc.ludo_board_structure.Token_paths;
import dal.asdc.movement.IMake_move;
import dal.asdc.movement.factory_method.Move_factory;
import dal.asdc.movement.factory_method.Simple_move_factory;
import dal.asdc.player.IPlayer_intialiser;
import dal.asdc.player.Player;
import dal.asdc.player.Factory_classes.Player_factory;

public class Ludo_game implements ILudo_game{

	private static final String COMPUTER_PLAYER_GAME = "computer_player";
	private static final String FOUR_PLAYER_GAME = "four_player";
	private static final String THREE_PLAYER_GAME = "three_player";
	private static final String TWO_PLAYER_GAME = "two_player";
	private static final String RUNNER = "Runner";
	private static final String WINNER = "Winner";
	private static final String END_PART_OF_TURN_TEXT = "'s turn";
	private static final int TWO_DIMENSIONS = 2;
	private static final int NUMBER_OF_TOKENS_PER_PLAYER = 4;
	Player player1 = null;
	Player player2 = null;
	Player player3 = null;
	Player player4 = null;
	private Player current_turn = null;
	private List<Player> total_player_list = new ArrayList<>();
	private boolean dice_rolled = false;
	private String error_message = "";
	int dice_number;
	String type_of_game = null;
	boolean is_defeat_move = false;
	boolean is_game_over = false;
	Token_paths token_paths = new Token_paths();
	Map<String,String> winner_map = new HashMap<>();
	IInput_parser input_parser = null;
	IMake_move make_move = null;
	IDice dice = null;
	Map<String,Board_creation_command> input_commands = new HashMap<>();
	private static Ludo_game ludo_game = null;
	
	public static Ludo_game instance(String type, Map<Integer,String> player_list) {
		if(null == ludo_game) {
			ludo_game = new Ludo_game(type, player_list);
		}
		return ludo_game;
	}
	
	public Ludo_game(String game_type, Map<Integer,String> player_list) {
		type_of_game = game_type;
		Player_factory factory = new Player_factory_normal();
		IPlayer_intialiser initialiser = factory.create_player_intialiser();
		
		input_commands.put(TWO_PLAYER_GAME, new Two_player_command());
		input_commands.put(THREE_PLAYER_GAME, new Three_player_command());
		input_commands.put(FOUR_PLAYER_GAME, new Four_player_command());
		input_commands.put(COMPUTER_PLAYER_GAME, new Computer_player_command());

		Board_creation_command command = input_commands.get(game_type);
		initialiser = command.execute(player_list,initialiser);
		Map<String,Player> map = initialiser.getPlayer_list();
		for(Map.Entry<String,Player> iterate : map.entrySet()) {
			total_player_list.add(iterate.getValue());
		}
		next_turn();
		Ludo_game_factory game_factory = new Four_player_ludo_game_factory();
		input_parser = game_factory.create_input_parser();
		dice = game_factory.create_dice();
		
		Move_factory move_factory = new Simple_move_factory();
		make_move = move_factory.create_make_move();
		set_dice_rolled(false);
	}

	public boolean user_input_receiver(String input) {
        is_defeat_move = false;
        Token token_from_input;
        char[] word_tokens;
        assert(input_parser!=null);
        if(dice_rolled) {
            if(input_parser.check_input(input)) {
                word_tokens = input_parser.get_word_tokens(input);
                token_from_input = input_parser.get_player_from_input(get_total_player_list(), word_tokens);
            }else {
            	set_error_message("Input is not correct");
                return false;
            }
        }else {
        	set_error_message("First roll the dice then select token");
            return false;
        }
        if(check_turn(token_from_input)) {
            if(make_move.check_moving_path(token_from_input,dice_number)) {
                List<Token> updated_tokens = new ArrayList<>();
                updated_tokens = make_move.play_move(token_from_input, dice_number,get_total_player_list());
                if(updated_tokens.size()>1) {
                    is_defeat_move = true;
                }
                update_player(updated_tokens);
                next_turn();
                set_dice_rolled(false);
                return true;
            }else {
            	set_error_message("You cann't play this token");
                return false;
            }
        }else {
        	set_error_message("It's not selected token's turn");
            return false;
        }
    }
	
	public Map<String,String> get_position_of_all_tokens(){
        Map<String,String> positions = new HashMap<>();
		int[][] tokens_position = new int[get_total_player_list().size()*NUMBER_OF_TOKENS_PER_PLAYER][TWO_DIMENSIONS];
		int counter=0;
		List<Token> all_tokens = new ArrayList<>();
        for(Player player : get_total_player_list()) {
		  List<Token> four_tokens =player.get_all_tokens();
		  for(Token token : four_tokens) { 
			  int[][] coordinates = token.get_coordinate_position();
			  tokens_position[counter][0]=coordinates[0][0];
			  tokens_position[counter][1]=coordinates[0][1];
			  counter++;
			  all_tokens.add(token);
		  }
		}
        int[][] total_path = token_paths.total_path;
        positions = set_token_names_on_actual_spots(total_path,all_tokens);
        return positions;
    }
	
	private Map<String,String> set_token_names_on_actual_spots(int[][] total_path, List<Token> all_tokens){
        Map<String,String> positions_temp = new HashMap<>();
		for(int i = 0;i < total_path.length; i++) {
        	int[][] temp_position = {{total_path[i][0],total_path[i][1]}};
        	boolean is_set = false;
        	String token_name = "";
        	for(Token token : all_tokens) {
        		int[][] position = token.get_coordinate_position();
        		if(temp_position[0][0] == position[0][0] && temp_position[0][1] == position[0][1]) {
        			token_name = token_name + token.get_token_colour().substring(0, 1)+(token.get_token_number()+1);
      			  	is_set = true;
      			  	break;
        		}
        	}
        	if(is_set) {
        		positions_temp.put("{"+ temp_position[0][0]+","+temp_position[0][1] +"}", token_name);
        	}else {
        		positions_temp.put("{"+ temp_position[0][0]+","+temp_position[0][1] +"}", " ");
        	}
        }
		return positions_temp;
	}
	
	public void update_player(List<Token> updated_tokens) {
		List<Player> all_players = get_total_player_list();
		for(int player_index = 0 ; player_index < all_players.size() ; player_index++) {
			Player temp_player = all_players.get(player_index);
			List<Token> four_tokens = temp_player.get_all_tokens();
			int updated_token_index = 0;

			for(Token token : four_tokens) {
				Token temp_token = token;
				for(Token updated_token : updated_tokens) {
					if(temp_token.get_token_colour().equals(updated_token.get_token_colour()) &&
							temp_token.get_token_number() == updated_token.get_token_number()) {
						four_tokens.set(updated_token_index, updated_token);
					}
				}
				updated_token_index++;
			}
			temp_player = check_player_is_done(four_tokens,temp_player);
			all_players.set(player_index, temp_player);
		}
		set_total_player_list(all_players);
	}

	public void next_turn() {
		Player current_player_temp = get_current_turn();
		List<Player> temp_list = get_total_player_list();
		if(current_player_temp == null) {
			current_player_temp = temp_list.get(0);
			set_current_turn(current_player_temp);
			return;
		}else {
			if(dice_number == 6 || is_defeat_move) {
				return;
			}
			Player next_player = get_next_player(temp_list,current_player_temp);
			if(next_player.get_is_done()) {
				if(get_total_player_list().size() == 2) {
					set_is_game_over(true);
				}
			}else {
				set_current_turn(next_player);
			}
			return;
		}	
	}
	
	public boolean roll_dice() {
		if(get_dice_rolled()) {
			set_error_message("Play a token first");
            return false;
		}
        int number = dice.roll_dice();
        if(number <= 6 && number >= 1) {
        	int all_home_count = 0;
        	List<Token> four_tokens = get_current_turn().get_all_tokens();
        	for(Token token : four_tokens) {
        		if(token.is_home()) {
        			all_home_count++;
        		}
        	}
        	if(all_home_count == 4 && number != 6) {
        		next_turn();
        		dice_number = number;
        	}else {
        		dice_number = number;
                set_dice_rolled(true);
        	}
        	return true;
        }
        return false;
		
    }
	
	public Player get_next_player(List<Player> temp_list, Player current_player_temp) {
		int index = temp_list.indexOf(current_player_temp);
		Player next_player;
		if(index == (temp_list.size()-1)) {
			next_player = temp_list.get(0);
		}else {
			next_player = temp_list.get(index+1);
		}
		return next_player;
	}

	private boolean check_turn(Token token_from_input) {
		Player temp_current_player = get_current_turn();
		if(token_from_input.get_token_colour().equals(temp_current_player.getColour())) {
			return true;
		}
		return false;
	}

	
	public String get_current_turn_text() {
        String turn_text = get_current_turn().getColour()+END_PART_OF_TURN_TEXT;
        return turn_text;
    }
	
	private Player check_player_is_done(List<Token> four_tokens, Player temp_player) {
		int tokens_at_winning_box = 0;
		for(Token token : four_tokens) {
			if(token.get_is_token_at_winning_box()) {
				tokens_at_winning_box++;
			}
		}
		if(tokens_at_winning_box==4) {
			set_winner_in_map(temp_player);
			temp_player.set_is_done(true);
		}else {
			temp_player.set_is_done(false);
		}
		temp_player.set_tokens(four_tokens);
		return temp_player;
	}
	
	private void set_winner_in_map(Player temp_player) {
		if(winner_map.isEmpty()) {
			winner_map.put(WINNER, temp_player.getColour());
			return;
		}
		if(winner_map.containsKey(WINNER) && winner_map.size()==1) {
			winner_map.put(RUNNER, temp_player.getColour());
			return;
		}
	}
	
	public Player get_current_turn() {
		return current_turn;
	}

	public void set_current_turn(Player current_turn) {
		this.current_turn = current_turn;
	}
	
	public List<Player> get_total_player_list() {
		return total_player_list;
	}

	public void set_total_player_list(List<Player> total_player_list_temp_var) {
		total_player_list = total_player_list_temp_var;
	}
	
	public boolean get_dice_rolled() {
		return dice_rolled;
	}

	public void set_dice_rolled(boolean dice_rolled) {
		this.dice_rolled = dice_rolled;
	}
	
	public void set_error_message(String error_message) {
		this.error_message = error_message;
	}

	public String get_error_message() {
		return error_message;
	}
	
	public void set_dice_number(int number) {
		dice_number = number;
	}
	
	public int get_dice_number() {
		return dice_number;
	}
	
	public boolean get_is_game_over() {
		return is_game_over;
	}
	
	public void set_is_game_over(boolean is_game_over) {
		this.is_game_over = is_game_over;
	}
}
