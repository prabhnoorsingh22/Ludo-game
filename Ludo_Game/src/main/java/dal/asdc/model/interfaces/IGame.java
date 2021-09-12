package dal.asdc.model.interfaces;

/**
 * @author Reshma Unnikrishnan**/
public interface IGame {
	public int getGame_id();
	public void setGame_id(int game_id);
	public String getGame_time();
	public void setGame_time(String game_time);
	public int getPlayer_id();
	public void setPlayer_id(int player_id);
	public int getGame_winner_id();
	public void setGame_winner_id(int game_winner_id);
	public int getGame_runner_id();
	public void setGame_runner_id(int game_runner_id);
	public String getGame_status();
	public void setGame_status(String game_status);
}
