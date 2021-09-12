package dal.asdc.ludo_score_history.factory;

import dal.asdc.ludo_score_history.Game_score_history;
import dal.asdc.ludo_score_history.Player_score_history;
import dal.asdc.ludo_score_history.Tournaments_score_history;
import dal.asdc.ludo_score_history.interfaces.IScore_history;

/**
 * @author Reshma Unnikrishnan**/
public class Score_factory extends Score_factory_abstract {

	public IScore_history create_player_score_history() {
		return new Player_score_history();
	}
	
	public IScore_history create_game_score_history() {
		return new Game_score_history();
	}
	
	public IScore_history create_tournament_score_history() {
		return new Tournaments_score_history();
	}

}
