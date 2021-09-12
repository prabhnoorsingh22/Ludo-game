package dal.asdc.ludo_score_history;

import java.util.HashMap;
import java.util.Map;

import dal.asdc.ludo_score_history.interfaces.IScore_history;
import dal.asdc.model.factory.Model_factory;
import dal.asdc.model.interfaces.ITournaments;
import dal.asdc.persistence.factory.Persistence_factory;
import dal.asdc.persistence.factory.Persistence_factory_abstract;
import dal.asdc.persistence.interfaces.ITournament_persistence;

/**
 * @author Reshma Unnikrishnan**/


public class Tournaments_score_history implements IScore_history{
	
	Persistence_factory_abstract persistence_factory = new Persistence_factory();
	Model_factory model_factory = new Model_factory();
	
	private final ITournament_persistence iTournament_persistence = persistence_factory.create_tournament_persistence();
	ITournaments tournament = model_factory.create_tournaments();
	
	@Override
	public void save_history() {
		iTournament_persistence.create_record(tournament);
	}

	@Override
	public void load_history(int id) {
		iTournament_persistence.select_all_record();
	}

	@Override
	public Map<String,String> form_score_board() {
		Map<String,String> tournament_score_board = new HashMap<String,String>();
		return tournament_score_board;
	}

	
}
