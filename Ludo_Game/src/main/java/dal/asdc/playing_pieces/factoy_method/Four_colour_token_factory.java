package dal.asdc.playing_pieces.factoy_method;
/**
 * @author Kishan Rakeshbhai Patel **/

import dal.asdc.playing_pieces.Blue_token;
import dal.asdc.playing_pieces.Green_token;
import dal.asdc.playing_pieces.Red_token;
import dal.asdc.playing_pieces.Token;
import dal.asdc.playing_pieces.Yellow_token;

public class Four_colour_token_factory extends Token_factory{

	public Token crete_red_token(int number_of_token) {
		return new Red_token(number_of_token);
	}
	
	public Token crete_green_token(int number_of_token) {
		return new Green_token(number_of_token);
	}
	
	public Token crete_blue_token(int number_of_token) {
		return new Blue_token(number_of_token);
	}
	
	public Token crete_yellow_token(int number_of_token) {
		return new Yellow_token(number_of_token);
	}
}
