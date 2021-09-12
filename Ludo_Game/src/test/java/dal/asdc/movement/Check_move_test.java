package dal.asdc.movement;
/**
 * @author Kishan Rakeshbhai Patel **/

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dal.asdc.movement.factory_method.Move_factory;
import dal.asdc.movement.factory_method.Simple_move_factory;
import dal.asdc.playing_pieces.Token;
import dal.asdc.playing_pieces.factoy_method.Four_colour_token_factory;
import dal.asdc.playing_pieces.factoy_method.Token_factory;

public class Check_move_test {

	Token_factory factory;
	Token token;
	ICheck_move check_move;
	
	@BeforeEach
	void initialize() {
		factory = new Four_colour_token_factory();
		token = factory.crete_red_token(0);

		Move_factory factory = new Simple_move_factory();
		check_move = factory.create_check_move();
	}
	
	@Test
	void check_is_red_token_6_dice_movable_test() {
		boolean is_movable = check_move.check_is_token_movable(token,6);
		assertEquals(true,is_movable);
	}
	
	@Test
	void check_is_red_token_3_dice_at_home_movable_test() {
		boolean is_movable = check_move.check_is_token_movable(token,3);
		assertEquals(false,is_movable);
	}
	
	@Test
	void check_is_red_token_in_winning_square_movable_test() {
		Check_move check_move = new Check_move();
		int[][] new_position = new int[][]{{7,7}};
		token.set_coordinate_position(new_position);
		int[][] checking = token.get_coordinate_position();
		boolean is_movable = check_move.check_is_token_movable(token,6);
		assertEquals(false,is_movable);
	}
	
	@Test
	void check_is_red_token_near_winning_square_2_dice_only_movable_test() {
		int[][] token_path = token.get_token_path();
		int[][] token_position = {{token_path[(token_path.length - 3)][0],token_path[(token_path.length - 3)][1]}};
		token.set_coordinate_position(token_position);
		boolean is_movable = check_move.check_is_token_movable(token,4);
		assertEquals(false,is_movable);
	}
	
	@Test
	void check_is_red_token_in_winning_square_more_than_required_dice_movable_test() {
		int[][] token_path = token.get_token_path();
		int[][] token_position = {{token_path[(token_path.length - 3)][0],token_path[(token_path.length - 3)][1]}};
		token.set_coordinate_position(token_position);
		boolean is_movable = check_move.check_is_token_movable(token,2);
		assertEquals(true,is_movable);
	}
	
	
}
