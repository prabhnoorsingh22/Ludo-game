package dal.asdc.model.interfaces;

/**
 * @author Reshma Unnikrishnan**/
public interface ITournaments {
	
	public int getTournament_id();
	public void setTournament_id(int tournament_id);
	public String getTournament_time();
	public void setTournament_time(String tournament_time);
	public int getNum_of_participants();
	public void setNum_of_participants(int num_of_participants);
	public int getTournament_winner_id();
	public void setTournament_winner_id(int tournament_winner_id);
	public int getTournament_runner_id();
	public void setTournament_runner_id(int tournament_runner_id);
	public String getTournament_status();
	public void setTournament_status(String tournament_status);
}
