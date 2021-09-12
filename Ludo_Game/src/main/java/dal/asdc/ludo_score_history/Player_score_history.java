package dal.asdc.ludo_score_history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dal.asdc.ludo_score_history.interfaces.IScore_history;
import dal.asdc.model.factory.Model_factory;
import dal.asdc.model.interfaces.IGame_player_score;
import dal.asdc.model.interfaces.IPlayer;
import dal.asdc.persistence.factory.Persistence_factory;
import dal.asdc.persistence.factory.Persistence_factory_abstract;
import dal.asdc.persistence.interfaces.IGame_player_score_persistence;
import dal.asdc.persistence.interfaces.IPlayer_persistence;

/**
 * @author Reshma Unnikrishnan**/

public class Player_score_history implements IScore_history {
	
	Persistence_factory_abstract persistence_factory = new Persistence_factory();
	Model_factory model_factory = new Model_factory();
	
	IGame_player_score_persistence game_player_score_persistence = persistence_factory.create_game_player_score_persistence();
	IPlayer_persistence player_persistence = persistence_factory.create_player_persistence();
	
	IGame_player_score game_player_score = model_factory.create_game_player_score();
	IPlayer player = model_factory.create_player();
	
	List<IGame_player_score> game_player_score_list = new ArrayList<>();
	
	@Override
	public void save_history() {
		game_player_score_persistence.insert_score(game_player_score);
	}

	@Override
	public void load_history(int player_id) {
		game_player_score_list = game_player_score_persistence.get_player_score(player_id);
	}

	@Override
	public Map<String,String> form_score_board() {
		int player_total_score = 0;
		int player_id=0;
		Map<String,String> player_score_map = new HashMap<String,String>();
		for(IGame_player_score model : game_player_score_list) {
            System.out.println(model.getScore());
            player_total_score = player_total_score + model.getScore();
            player_id = model.getPlayer_id();
        }
		player = player_persistence.filter_by_id(player_id);
		String player_name = player.getPlayer_name();
		String player_email = player.getPlayer_email();
		player_score_map.put("player_name", player_name);
		player_score_map.put("player_email", player_email);
		player_score_map.put("total_score", String.valueOf(player_total_score));
		return player_score_map;
	}

	public void form_save_score(String score_id,int game_id,int player_id,int score) {
		game_player_score.setScore_id(score_id);
		game_player_score.setGame_id(game_id);
		game_player_score.setPlayer_id(player_id);
		game_player_score.setScore(score);
		save_history();
	}


}
