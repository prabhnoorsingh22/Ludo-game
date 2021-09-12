package dal.asdc.model.interfaces;

/**
 * @author Reshma Unnikrishnan**/
public interface IGame_player_score {
	
	public String getScore_id();
	public void setScore_id(String score_id);
	public int getGame_id();
	public void setGame_id(int game_id);
	public int getPlayer_id();
	public void setPlayer_id(int player_id);
	public int getScore();
	public void setScore(int score);

}
