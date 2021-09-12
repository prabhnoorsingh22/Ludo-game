package dal.asdc.movement;
/**
 * @author Kishan Rakeshbhai Patel **/

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dal.asdc.player.Factory_classes.Player_factory_normal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dal.asdc.movement.factory_method.Move_factory;
import dal.asdc.movement.factory_method.Simple_move_factory;
import dal.asdc.player.IPlayer_intialiser;
import dal.asdc.player.Player;
import dal.asdc.player.Factory_classes.Player_factory;
import dal.asdc.playing_pieces.Token;

public class Make_move_test {
	IMake_move make_move;
	List<Player> total_player_list;
	Player player1;
	Player player2;
	List<Token> output_list;
	
	@BeforeEach
	void initialize() {
		Move_factory move_factory = new Simple_move_factory();
		make_move = move_factory.create_make_move();
		total_player_list = new ArrayList<>(); 
		
		List<Token> output_list = new ArrayList<>();
		
		Player_factory factory = new Player_factory_normal();
		IPlayer_intialiser initialiser = factory.create_player_intialiser();
		initialiser.intialise(2);
		Map<String, Player> map = initialiser.getPlayer_list();
		for(Map.Entry<String, Player> iterate : map.entrySet()) {
			total_player_list.add(iterate.getValue());
		}
		player1 = total_player_list.get(0);
		player2 = total_player_list.get(1);
	}
	
	
	@Test
	void get_token_path_index_test() {
		int[][] token_position = {{3,4}};
		int[][] token_path = {{2,3},{3,4},{4,5}};
		
		int index = make_move.get_index_of_token_on_path(token_position, token_path);
		
		assertEquals(1,index);
	}
	
	@Test
	void play_token_out_from_home_test() {
		Token red1 = player1.get_all_tokens().get(0);
		output_list = make_move.play_move(red1, 6, total_player_list);
		assertEquals(false,output_list.get(0).is_home());
	}
	
	@Test
	void play_token_in_winning_square_test() {
		
		Token red1 = player1.get_all_tokens().get(0);
		int[][] token_path = red1.get_token_path();
		int[][] token_position = {{token_path[(token_path.length - 3)][0],token_path[(token_path.length - 3)][1]}};
		red1.set_coordinate_position(token_position);
		output_list = make_move.play_move(red1, 3, total_player_list);
		assertEquals(true,output_list.get(0).get_is_token_at_winning_box());
	}
	
	@Test
	void play_token_defeat() {
		Token yellow1 = player2.get_all_tokens().get(0);
		int[][] token_position = {{10,8}};
		yellow1.set_coordinate_position(token_position);
		List<Token> yellow_tokens = player2.get_all_tokens();
		yellow_tokens.set(0, yellow1);
		player2.set_tokens(yellow_tokens);
		
		Token red1 = player1.get_all_tokens().get(0);
		int[][] token_position_red = {{13,8}};
		red1.set_coordinate_position(token_position_red);

		output_list = make_move.play_move(red1, 3, total_player_list);
		assertEquals(2,output_list.size());
	}
}