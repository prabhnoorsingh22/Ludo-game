package dal.asdc.playing_pieces;
/**
 * @author Kishan Rakeshbhai Patel **/
import dal.asdc.ludo_board_structure.Token_paths;

public class Yellow_token extends Token{
	
	private static final String YELLOW_COLOUR = "YELLOW";
	static int[][] yellow_home = {{11,12},{11,11},{12,11},{12,12}};
	int[][] winning_square = {{7,7}};
	int[][] yellow_token_path ;

	public Yellow_token(int numer_of_token) {
		super(YELLOW_COLOUR,numer_of_token,yellow_home[numer_of_token][0],yellow_home[numer_of_token][1]);
		create_path();
	}
	
	private void create_path() {
		Token_paths paths = new Token_paths();
		yellow_token_path = paths.yellow_path;
	}
	
	public boolean is_home() {
		return is_home_in_token(yellow_home);
	}
	
	public boolean check_move_towards_winning_square(int dice_number) {
		return check_move_towards_winning_square_in_token(dice_number,yellow_token_path);
	}
	
	public int[][] get_token_path(){
		return yellow_token_path;
	}
	
	public int[][] get_winning_square(){
		return yellow_token_path;
	}
	
	public void set_at_home() {
		token_set_at_home(yellow_home);
	}
}
