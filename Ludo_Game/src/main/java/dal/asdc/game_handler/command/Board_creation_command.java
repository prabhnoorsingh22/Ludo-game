package dal.asdc.game_handler.command;
/**
 * @author Kishan Rakeshbhai Patel **/

import java.util.Map;

import dal.asdc.player.IPlayer_intialiser;

public abstract class Board_creation_command {
	public abstract IPlayer_intialiser execute( Map<Integer,String> player_list,IPlayer_intialiser initialiser);

}
