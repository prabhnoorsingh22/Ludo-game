package dal.asdc.persistence.factory;

import dal.asdc.persistence.interfaces.IGame_persistence;
import dal.asdc.persistence.interfaces.IGame_player_score_persistence;
import dal.asdc.persistence.interfaces.IJdbc_connection;
import dal.asdc.persistence.interfaces.IPlayer_persistence;
import dal.asdc.persistence.interfaces.ITournament_persistence;

/**
 * @author Reshma Unnikrishnan**/

public abstract class Persistence_factory_abstract {
	
	public abstract IGame_persistence create_game_persistence();
	
	public abstract IGame_player_score_persistence create_game_player_score_persistence();
	
	public abstract IJdbc_connection create_jdbc_connection();
	
	public abstract IPlayer_persistence create_player_persistence();

	public abstract ITournament_persistence create_tournament_persistence();
}
