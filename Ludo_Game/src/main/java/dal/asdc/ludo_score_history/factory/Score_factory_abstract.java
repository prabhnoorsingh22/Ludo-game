package dal.asdc.ludo_score_history.factory;

import dal.asdc.ludo_score_history.interfaces.IScore_history;

/**
 * @author Reshma Unnikrishnan **/
public abstract class Score_factory_abstract {
	
	public abstract IScore_history create_player_score_history();
	
	public abstract IScore_history create_game_score_history();
	
	public abstract IScore_history create_tournament_score_history();
	
}
