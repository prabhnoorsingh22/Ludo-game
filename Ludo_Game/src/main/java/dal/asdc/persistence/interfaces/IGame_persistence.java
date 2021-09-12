package dal.asdc.persistence.interfaces;

import java.util.List;

import dal.asdc.model.Game;

/**
 * @author Reshma Unnikrishnan
 * */

public interface IGame_persistence {
	public void create_record(Game game);
	public List<Game> select_all_record();
	public void update_record(Integer game_id, Game game);
	public void filter_by_id();
}
