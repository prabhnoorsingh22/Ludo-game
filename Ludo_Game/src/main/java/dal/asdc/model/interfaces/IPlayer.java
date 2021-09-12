package dal.asdc.model.interfaces;

/**
 * @author Reshma Unnikrishnan**/
public interface IPlayer {
	public int getPlayer_id();
	public void setPlayer_id(int player_id);
	public String getPlayer_name();
	public void setPlayer_name(String player_name);
	public String getPlayer_email();
	public void setPlayer_email(String player_email);
	public String getPlayer_password();
	public void setPlayer_password(String player_password);
	public String getAcc_created_date();
	public void setAcc_created_date(String acc_created_date);
}
