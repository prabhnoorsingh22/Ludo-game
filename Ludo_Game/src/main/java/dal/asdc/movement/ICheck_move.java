package dal.asdc.movement;
/**
 * @author Kishan Rakeshbhai Patel **/
import dal.asdc.playing_pieces.Token;

public interface ICheck_move {
	boolean check_is_token_movable(Token selected_token,int dice_number);
}
