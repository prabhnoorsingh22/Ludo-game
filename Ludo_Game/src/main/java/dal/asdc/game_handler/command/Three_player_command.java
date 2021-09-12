package dal.asdc.game_handler.command;
/**
 * @author Kishan Rakeshbhai Patel **/

import java.util.Map;
import dal.asdc.player.IPlayer_intialiser;

public class Three_player_command extends Board_creation_command {

	@Override
	public IPlayer_intialiser execute(Map<Integer, String> player_list,IPlayer_intialiser initialiser) {
		IPlayer_intialiser initialiser_temp = initialiser;
		initialiser_temp.intialise(3);
		return initialiser_temp;
	}

}
