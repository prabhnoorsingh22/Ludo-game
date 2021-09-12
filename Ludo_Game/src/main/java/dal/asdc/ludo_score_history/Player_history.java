package dal.asdc.ludo_score_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dal.asdc.model.Player;
import dal.asdc.model.interfaces.IPlayer;
import dal.asdc.persistence.factory.Persistence_factory;
import dal.asdc.persistence.factory.Persistence_factory_abstract;
import dal.asdc.persistence.interfaces.IPlayer_persistence;

/**
 * @author Reshma Unnikrishnan**/

public class Player_history{

	Persistence_factory_abstract persistence_factory = new Persistence_factory();
	IPlayer_persistence player_persistence = persistence_factory.create_player_persistence();

    @Autowired
    public Player_history(IPlayer_persistence player_persistence) {
        this.player_persistence = player_persistence;
    }
	
	public void save_player_history(IPlayer player) {
		this.player_persistence.save_record(player);
	}

	public List<IPlayer> load_player_history() {
		return this.player_persistence.select_all_record();
	}
	
	public IPlayer search_player_history_by_id(int plyr_id) {
		return this.player_persistence.filter_by_id(plyr_id);
	}
	
	public void update_record(int player_id, IPlayer player) {
		this.player_persistence.update_record(player_id, player);
	}
}
