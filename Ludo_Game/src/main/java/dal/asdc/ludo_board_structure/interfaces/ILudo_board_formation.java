package dal.asdc.ludo_board_structure.interfaces;

import java.util.Map;

public interface ILudo_board_formation {
	public void form_matrix();
	public void set_movable_positions();
	public void set_safe_positions();
	public void set_winning_square();
	public String add_game_type(int choice);
	public Map<String,String> board_attributes();
}
