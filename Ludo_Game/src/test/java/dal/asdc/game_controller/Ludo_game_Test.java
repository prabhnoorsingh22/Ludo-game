package dal.asdc.game_controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import dal.asdc.game_handler.Dice;
import dal.asdc.game_handler.IDice;
import dal.asdc.game_handler.Ludo_game;
import dal.asdc.player.Player;
import dal.asdc.playing_pieces.Token;

public class Ludo_game_Test {
	
	@Mock
	IDice dice;
	Ludo_game game_controller;
	@BeforeEach
	void initialize() {
		Map<Integer, String> player_id_list = new HashMap<>();
		game_controller = null;
		game_controller = Ludo_game.instance("two_player",player_id_list);
	}
	
	@Test
	void constructor_test() {		
		assertEquals(false,game_controller.get_dice_rolled());
		Player current_player = game_controller.get_current_turn();
		assertEquals("RED",current_player.getColour());	
		List<Player> player_list = new ArrayList<>();
		player_list = game_controller.get_total_player_list();
		assertEquals(2,player_list.size());
	}
	
	@Test
	void user_input_receiver_no_dice_rolled_test() {		
		game_controller.set_dice_rolled(false);
		boolean result = game_controller.user_input_receiver("r1");
		assertEquals(false,result);
	}
	
	@Test
	void user_input_receiver_input_not_correct_test() {
		game_controller.set_dice_rolled(true);
		boolean result = game_controller.user_input_receiver("r145");
		game_controller.set_dice_rolled(false);
		assertEquals(false,result);
	}
	
	@Test
	void user_input_receiver_not_your_turn_test() {
		game_controller.set_dice_rolled(true);
		boolean result = game_controller.user_input_receiver("y1");
		game_controller.set_dice_rolled(false);
		assertEquals(false,result);
	}
	
	@Test
	void user_input_receiver_cannot_play_token_test() {
		game_controller.set_dice_rolled(true);
		game_controller.set_dice_number(4);
		boolean result = game_controller.user_input_receiver("r1");
		game_controller.set_dice_rolled(false);
		assertEquals(false,result);
	}
	
	@Test
	void get_all_position_test() {
		Map<String,String> positions = new HashMap<>();
		positions = game_controller.get_position_of_all_tokens();
		int total_positions = positions.size();
		assertEquals(88,total_positions);
	}
	
	@Test
	void roll_dice_not_rolled_test() {
		assertEquals(false,game_controller.get_dice_rolled());
	}
	
	@Test
	void roll_dice_wrong_number_test() {
		Dice dice=null;
		dice= mock(Dice.class);
        when(dice.roll_dice()).thenReturn(0);  
		assertEquals(false,game_controller.get_dice_rolled());
	}
	
	@Test
	void get_next_player_test() {
		Player player = game_controller.get_next_player(game_controller.get_total_player_list(), game_controller.get_current_turn());
		assertEquals("YELLOW",player.getColour());
	}
	
	@Test
	void current_player_text_test() {
		assertEquals("RED's turn",game_controller.get_current_turn_text());
	}
	
	@Test
	void update_player_list_test() {
		Player player = game_controller.get_total_player_list().get(0);
		Token token = player.get_all_tokens().get(0);
		token.set_at_home();
		List<Token> tokens = new ArrayList();
		tokens.add(token);
		game_controller.update_player(tokens);
		Player player_latest = game_controller.get_total_player_list().get(0);
		Token token_latest = player_latest.get_all_tokens().get(0);
		assertEquals(true,token_latest.get_is_token_at_home());
	}
	
	@Test
	void next_turn_if_6_test() {
		game_controller.set_dice_number(6);
		assertEquals("RED",game_controller.get_current_turn().getColour());
	}
	
	@Test
	void game_over_test() {
		List<Player> player = game_controller.get_total_player_list();
		player.get(1).set_is_done(true);
		game_controller.set_total_player_list(player);
		game_controller.next_turn();
		assertEquals(true,game_controller.get_is_game_over());
	}
}
