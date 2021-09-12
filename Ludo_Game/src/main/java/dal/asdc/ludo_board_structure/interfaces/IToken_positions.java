package dal.asdc.ludo_board_structure.interfaces;

import java.util.Map;

public interface IToken_positions {
	public Map<String,String> get_red_token_positions();
	public Map<String,String> get_green_token_positions();
	public Map<String,String> get_empty_green_token_positions();
	public Map<String,String> get_yellow_token_positions();
	public Map<String,String> get_blue_token_positions();
	public Map<String,String> get_empty_blue_token_positions();
	public Map<String,String> get_two_player_positions();
	public Map<String,String> get_three_player_positions();
	public Map<String,String> get_four_player_positions();
	public Map<String,String> get_board_attributes(int ply_num);
}
