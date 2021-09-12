package dal.asdc.movement;
/**
 * @author Kishan Rakeshbhai Patel **/
import dal.asdc.playing_pieces.Token;

public class Check_move implements ICheck_move{
		
	private static final int HIGHEST_NUMBER_ON_DICE = 6;

	public boolean check_is_token_movable(Token selected_token,int dice_number) {
		if(selected_token.is_home() && dice_number<HIGHEST_NUMBER_ON_DICE) {
			return false;
		}
		if(selected_token.check_move_towards_winning_square(dice_number)) {
			return false;
		}
		
		if(selected_token.is_at_winning_square()) {
			return false;
		}
		return true;
	}
}