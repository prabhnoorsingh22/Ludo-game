package dal.asdc.playing_pieces.factoy_method;
/**
 * @author Kishan Rakeshbhai Patel **/

import dal.asdc.playing_pieces.Token;

public abstract class Token_factory {
	
	public abstract Token crete_red_token(int number_of_token);
	
	public abstract Token crete_green_token(int number_of_token);
	
	public abstract Token crete_blue_token(int number_of_token);
	
	public abstract Token crete_yellow_token(int number_of_token);
}
