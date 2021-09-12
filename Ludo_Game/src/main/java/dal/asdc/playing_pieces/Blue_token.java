package dal.asdc.playing_pieces;
/**
 * @author Kishan Rakeshbhai Patel **/
import dal.asdc.ludo_board_structure.Token_paths;

public class Blue_token extends Token{
	
	private static final String BLUE_COLOUR = "BLUE";
	static int[][] blue_home = {{2,12},{2,11},{3,12},{3,11}};
	int[][] winning_square = {{7,7}};
	int[][] blue_token_path;

	public Blue_token(int numer_of_token) {
		super(BLUE_COLOUR,numer_of_token,blue_home[numer_of_token][0],blue_home[numer_of_token][1]);
		create_path();
	}
	
	private void create_path() {
		Token_paths paths = new Token_paths();
		blue_token_path = paths.blue_path;
	}
	
	public boolean is_home() {
		return is_home_in_token(blue_home);
	}
	
	public boolean check_move_towards_winning_square(int dice_number) {
		return check_move_towards_winning_square_in_token(dice_number,blue_token_path);
	}
	
	public int[][] get_token_path(){
		return blue_token_path;
	}
	
	public int[][] get_winning_square(){
		return blue_token_path;
	}
	
	public void set_at_home() {
		token_set_at_home(blue_home);
	}
}
