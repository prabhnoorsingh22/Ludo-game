package dal.asdc.game_handler;

/**
 * @author Kishan Rakeshbhai Patel **/

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import dal.asdc.player.Player;
import dal.asdc.playing_pieces.Token;
import dal.asdc.game_handler.command.*;

public class Input_parser implements IInput_parser{
	
	private static final char LETTER_B = 'b';
	private static final char LETTER_Y = 'y';
	private static final char LETTER_G = 'g';
	private static final char LETTER_R = 'r';
	private static final String REGULAR_EXPRESSION_TO_CHECK_INPUT = "[rgby]{1}[1-4]{1}";
	Map<Character,Colour_command> input_commands = new HashMap<>();
	String input_text = "";
	
	public Input_parser(){
		input_commands.put(LETTER_R, new Red_command());
		input_commands.put(LETTER_G, new Green_command());
		input_commands.put(LETTER_Y, new Yellow_command());
		input_commands.put(LETTER_B, new Blue_command());
	}
	
	public boolean check_input(String input) {
		input_text = input.trim().toLowerCase();
		String regular_expression = REGULAR_EXPRESSION_TO_CHECK_INPUT;
		boolean result = Pattern.matches(regular_expression, input_text);
		return result;
	}
	
	public char[] get_word_tokens(String input) {
		char[] tokens = new char[input.length()];
		for(int chars = 0 ; chars < input.length() ; chars++) {
			tokens[chars] = input.charAt(chars);
		}
		return tokens;
	}
	
	public Token get_player_from_input(List<Player> player_list_temp, char[] input_tokens) {
		char first_letter = input_tokens[0];
		first_letter = Character.toLowerCase(first_letter);
		Colour_command command = input_commands.get(first_letter);
		command.set_parameters(player_list_temp, input_tokens);
		return command.execute();
	}
}
