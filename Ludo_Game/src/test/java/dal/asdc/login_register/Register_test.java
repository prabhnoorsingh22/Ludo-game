package dal.asdc.login_register;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import dal.asdc.model.Player;
import dal.asdc.model.interfaces.IPlayer;
import dal.asdc.persistence.Player_persistence;
import dal.asdc.persistence.interfaces.IPlayer_persistence;

public class Register_test {
	@Test
	public void register_test() {
		IPlayer player = new Player();
		IPlayer_persistence plyr_dao = new Player_persistence();
		player.setPlayer_email("admin@gmail.com");
		player.setPlayer_password("Admin@123");
		player.setPlayer_password(generate_hash_password(player.getPlayer_password()));    
		player.setPlayer_name("Admin User");
		plyr_dao.save_record(player);
		IPlayer fatched_player = plyr_dao.filter_by_emailid(player.getPlayer_email());
		System.out.print(fatched_player);
		assertEquals(fatched_player.getPlayer_email(), player.getPlayer_email());
	}
	
	 private String generate_hash_password(String plain_password){
			return BCrypt.hashpw(plain_password, BCrypt.gensalt());
		}
}
