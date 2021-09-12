package dal.asdc.playing_pieces;
/**
 * @author Kishan Rakeshbhai Patel **/
public abstract class Token {
    private static final int NUMBER_OF_TOKENS = 4;
	int[][] position;
    private boolean is_token_at_home=true;
    private boolean is_token_at_winning_box = false;
    private String token_colour;
    private int token_number;
    private int[][] safe_boxes = {{1,6},{6,2},{8,1},{12,6},{13,8},{8,12},{6,13},{2,8}};
	int[][] winning_square = {{7,7}};

    public Token(String token_colour, int token_number, int positionX, int positionY) {
        this.token_colour = token_colour;
        this.token_number = token_number;
        int positionX_temp = positionX;
        int positionY_temp = positionY;
        position = new int[][]{{positionX_temp,positionY_temp}};
    }
    
    public boolean is_home_in_token(int[][] token_home_coordinates) {
		int[][] selected_token_postion = get_coordinate_position();
		for(int i=0;i<NUMBER_OF_TOKENS;i++) {
			if(token_home_coordinates[i][0] == selected_token_postion[0][0] && token_home_coordinates[i][1] == selected_token_postion[0][1]) {
				return true;
			}
		}
		return false;
	}
    
    public boolean check_move_towards_winning_square_in_token(int dice_number, int[][] token_path) {
		int[][] selected_token_postion = get_coordinate_position();
		for(int i=0;i<token_path.length;i++) {
			if(token_path[i][0] == selected_token_postion[0][0] && token_path[i][1] == selected_token_postion[0][1]) {
				if((i+dice_number) > token_path.length) {
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}
    
    public boolean is_at_winning_square() {
		int[][] selected_token_postion = get_coordinate_position();
		for(int i = 0 ; i < 1 ; i++) {
			if(winning_square[i][0]==selected_token_postion[0][0] && winning_square[i][1]==selected_token_postion[0][1]) {
				return true;
			}
		}
		return false;
	}
    
    public void token_set_at_home(int[][] token_home) {
		int token_number = get_token_number();
		int[][] perfect_home_cordinates = {{token_home[token_number][0],token_home[token_number][1]}};
		set_coordinate_position(perfect_home_cordinates);
		set_is_token_at_home(true);
	}

    public String get_token_colour() {
        return token_colour;
    }

    public int[][] get_coordinate_position() {
        return position;
    }

    public void set_coordinate_position(int[][] position_new) {
        position = position_new;
    }

    public int get_token_number() {
        return token_number;
    }

    public boolean get_is_token_at_home() {
        return is_token_at_home;
    }

    public void set_is_token_at_home(boolean is_token_at_home) {
        this.is_token_at_home = is_token_at_home;
    }

    public boolean get_is_token_at_winning_box() {
        return is_token_at_winning_box;
    }

    public void set_is_token_at_winning_box(boolean is_token_at_winning_box) {
        this.is_token_at_winning_box = is_token_at_winning_box;
    }

    public int[][] get_safe_boxes() {
		return safe_boxes;
	}

	public void set_safe_boxes(int[][] safe_boxes) {
		this.safe_boxes = safe_boxes;
	}
	
    public abstract boolean is_home();
    public abstract boolean check_move_towards_winning_square(int dice_number);
    public abstract int[][] get_token_path();
    public abstract int[][] get_winning_square();
    public abstract void set_at_home();
}
