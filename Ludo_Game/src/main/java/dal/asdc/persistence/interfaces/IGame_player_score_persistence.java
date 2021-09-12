package dal.asdc.persistence.interfaces;

import java.util.List;
import dal.asdc.model.Game_player_score;
import dal.asdc.model.interfaces.IGame_player_score;

/**
 * @author Reshma Unnikrishnan**/

public interface IGame_player_score_persistence {
	public void insert_score(IGame_player_score game_player_score);
	public List<IGame_player_score> get_player_score(int player_id);
	public List<IGame_player_score> get_game_score(int game_id);
}
