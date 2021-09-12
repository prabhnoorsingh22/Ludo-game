package dal.asdc.playing_pieces;
/**
 * @author Kishan Rakeshbhai Patel **/
import dal.asdc.ludo_board_structure.Token_paths;

public class Red_token extends Token{
	
	private static final String RED_COLOUR = "RED";
	static int[][] red_home = {{2,3},{3,3},{3,2},{2,2}};
	int[][] winning_square = {{7,7}};
	int[][] red_token_path;

	public Red_token(int numer_of_token) {
		super(RED_COLOUR,numer_of_token,red_home[numer_of_token][0],red_home[numer_of_token][1]);
		create_path();
	}
	
	private void create_path() {
		Token_paths paths = new Token_paths();
		red_token_path = paths.red_path;
	}
	
	public boolean is_home() {
		return is_home_in_token(red_home);
	}
	
	public boolean check_move_towards_winning_square(int dice_number) {
		return check_move_towards_winning_square_in_token(dice_number,red_token_path);
	}

	public int[][] get_token_path(){
		return red_token_path;
	}
	
	public int[][] get_winning_square(){
		return red_token_path;
	}
	
	public void set_at_home() {
		token_set_at_home(red_home);
	}
	
}
