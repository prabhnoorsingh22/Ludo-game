package dal.asdc.ludo_board_structure;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Reshma Unnikrishnan **/
class Ludo_board_formationTest {
	
	private Ludo_board_formation lbf;
	
	@BeforeEach
	void initEach() {
		lbf = new Ludo_board_formation();
	}

	@Test
	void testForm_matrix() {
		lbf.form_matrix();
		assertEquals(225,lbf.board_value_count);
	}

	@Test
	void testSet_movable_positions() {
		lbf.set_movable_positions();
		assertEquals(72,lbf.movable_positions_map.size());
	}

	@Test
	void testSet_safe_positions() {
		lbf.set_safe_positions();
		assertEquals(8,lbf.safe_positions_map.size());
	}

	@Test
	void testSet_winning_square() {
		lbf.set_winning_square();
		assertEquals(9,lbf.winning_positions_map.size());
	}
	
	@Test
	void testadd_game_type() {
		lbf.add_game_type(1);
		assertEquals(2,lbf.player_num);
	}
	
	@Test
	void testadd_game_type_two() {
		lbf.add_game_type(2);
		assertEquals(3,lbf.player_num);
	}
	
	@Test
	void testadd_game_type_three() {
		lbf.add_game_type(3);
		assertEquals(4,lbf.player_num);
	}
	
	@Test
	void testadd_game_type_five() {
		assertEquals("computer_player",lbf.add_game_type(5));
	}

	@Test
	void  testboard_attributes(){
		lbf.player_num=2;
		assertEquals(16,lbf.board_attributes().size());
	}
}
