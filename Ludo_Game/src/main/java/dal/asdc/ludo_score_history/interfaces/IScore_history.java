package dal.asdc.ludo_score_history.interfaces;

import java.util.Map;

import dal.asdc.model.interfaces.ITournaments;

/**
 * @author Reshma Unnikrishnan**/

public interface IScore_history {
	void save_history();
	void load_history(int id);
	Map<String,String> form_score_board();
}
