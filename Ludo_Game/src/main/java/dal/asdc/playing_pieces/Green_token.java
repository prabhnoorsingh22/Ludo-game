package dal.asdc.playing_pieces;
/**
 * @author Kishan Rakeshbhai Patel **/
import dal.asdc.ludo_board_structure.Token_paths;

public class Green_token extends Token{
	
	private static final String GREEN_COLOUR = "GREEN";
	static int[][] green_home = {{11,3},{12,3},{12,2},{11,2}};
	int[][] winning_square = {{7,7}};
	int[][] green_token_path;

	public Green_token(int numer_of_token) {
		super(GREEN_COLOUR,numer_of_token,green_home[numer_of_token][0],green_home[numer_of_token][1]);
		create_path();
	}
	
	private void create_path() {
		Token_paths paths = new Token_paths();
		green_token_path = paths.green_path;
	}
	
	public boolean is_home() {
		return is_home_in_token(green_home);
	}
	
	public boolean check_move_towards_winning_square(int dice_number) {
		return check_move_towards_winning_square_in_token(dice_number,green_token_path);
	}

	public int[][] get_token_path(){
		return green_token_path;
	}
	
	public int[][] get_winning_square(){
		return green_token_path;
	}
	
	public void set_at_home() {
		token_set_at_home(green_home);
	}
}
