package dal.asdc.playing_pieces;
/**
 * @author Kishan Rakeshbhai Patel **/

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import dal.asdc.playing_pieces.factoy_method.Four_colour_token_factory;
import dal.asdc.playing_pieces.factoy_method.Token_factory;

public abstract class Token_test {


	Token token;
	
	@BeforeEach
	void initialize() {
		Token_factory factory = new Four_colour_token_factory();
		token = factory.crete_yellow_token(0);
	}
	
	@Test
	void is_at_winning_square_test() {
		int[][] winning_position = {{7,7}};
		token.set_coordinate_position(winning_position);
		assertEquals(true,token.is_at_winning_square());
	}
	
	@Test
	void is_home_test() {
		assertEquals(true,token.is_home());
	}
}