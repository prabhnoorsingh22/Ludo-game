package dal.asdc.persistence.factory;

import dal.asdc.persistence.Game_persistence;
import dal.asdc.persistence.Game_player_score_persistence;
import dal.asdc.persistence.Jdbc_connection;
import dal.asdc.persistence.Player_persistence;
import dal.asdc.persistence.Tournament_persistence;
import dal.asdc.persistence.interfaces.IGame_persistence;
import dal.asdc.persistence.interfaces.IGame_player_score_persistence;
import dal.asdc.persistence.interfaces.IJdbc_connection;
import dal.asdc.persistence.interfaces.IPlayer_persistence;
import dal.asdc.persistence.interfaces.ITournament_persistence;

/**
 * @author Reshma Unnikrishnan**/

public class Persistence_factory extends Persistence_factory_abstract{
	
	public IGame_persistence create_game_persistence() {
		return new Game_persistence();
	}
	
	public IGame_player_score_persistence create_game_player_score_persistence() {
		return new Game_player_score_persistence();
	}
	
	public IJdbc_connection create_jdbc_connection() {
		return new Jdbc_connection();
	}
	
	public IPlayer_persistence create_player_persistence() {
		return new Player_persistence();
	}

	public ITournament_persistence create_tournament_persistence() {
		return new Tournament_persistence();
	}
}
