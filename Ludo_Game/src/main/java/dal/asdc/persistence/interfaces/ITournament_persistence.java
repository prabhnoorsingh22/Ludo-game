package dal.asdc.persistence.interfaces;

import java.util.List;

import dal.asdc.model.interfaces.ITournaments;

/**
 * @author Reshma Unnikrishnan**/

public interface ITournament_persistence {
	public void create_record(ITournaments tournaments);
	public List<ITournaments> select_all_record();
	public void update_record(Integer tournament_id, ITournaments tournaments);
}
