package dal.asdc.login_register;




import org.mindrot.jbcrypt.BCrypt;

import dal.asdc.login_register.interfaces.IRegister;
import dal.asdc.model.Player;
import dal.asdc.model.interfaces.IPlayer;
import dal.asdc.persistence.Player_persistence;
import dal.asdc.persistence.interfaces.IPlayer_persistence;

/**
 * @author Heli Bhavsar**/

public class Register implements IRegister{
	public boolean register(IPlayer player) {
		IPlayer_persistence plyr_dao = new Player_persistence();    
	    player.setPlayer_password(generate_hash_password(player.getPlayer_password()));    
	    IPlayer fatched_player = plyr_dao.filter_by_emailid(player.getPlayer_email());
	    if(fatched_player==null) {
	    	plyr_dao.save_record(player);
	    	return true;
	    }
	    else {
	    	return false;
	    }		 
 }
 
	private String generate_hash_password(String plain_password){
		return BCrypt.hashpw(plain_password, BCrypt.gensalt());
	}
}
