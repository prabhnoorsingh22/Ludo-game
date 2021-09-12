package dal.asdc.playing_pieces;
/**
 * @author Kishan Rakeshbhai Patel **/

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dal.asdc.playing_pieces.factoy_method.Four_colour_token_factory;
import dal.asdc.playing_pieces.factoy_method.Token_factory;

public class Red_token_test {

	Token token;
	
	@BeforeEach
	void initialize() {
		Token_factory factory = new Four_colour_token_factory();
		token = factory.crete_red_token(0);
	}
	
	@Test
	void constructor_test() {
		int[][] position = token.get_coordinate_position();

		assertEquals("RED",token.get_token_colour());
		assertEquals(true,token.get_is_token_at_home());
		assertEquals(false,token.get_is_token_at_winning_box());
		assertEquals(0,token.get_token_number());
		assertEquals(2,position[0][0]);
		assertEquals(3,position[0][1]);
	}
	
	@Test
	void check_move_towards_winning_square_test_less_than_last_box() {
		int[][] token_path = token.get_token_path();
		int[][] token_position = {{token_path[(token_path.length - 3)][0],token_path[(token_path.length - 3)][1]}};
		token.set_coordinate_position(token_position);
		assertEquals(false,token.check_move_towards_winning_square(2));
	}
	
	@Test
	void check_move_towards_winning_square_test_grater_than_last_box() {
		int[][] token_path = token.get_token_path();
		int[][] token_position = {{token_path[(token_path.length - 3)][0],token_path[(token_path.length - 3)][1]}};
		token.set_coordinate_position(token_position);
		assertEquals(true,token.check_move_towards_winning_square(4));
	}
	
	@Test
	void set_at_home_test() {
		int[][] position = {{6,6}};
		token.set_coordinate_position(position);
		assertEquals(false,token.is_home());	
		token.set_at_home();
		assertEquals(true,token.is_home());	
	}
}
