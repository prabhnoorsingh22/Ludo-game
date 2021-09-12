package dal.asdc.ludo_score_history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dal.asdc.ludo_score_history.interfaces.IScore_history;
import dal.asdc.model.factory.Model_factory;
import dal.asdc.model.factory.Model_factory_abstract;
import dal.asdc.model.interfaces.IGame;
import dal.asdc.model.interfaces.IGame_player_score;
import dal.asdc.model.interfaces.IPlayer;
import dal.asdc.persistence.factory.Persistence_factory;
import dal.asdc.persistence.factory.Persistence_factory_abstract;
import dal.asdc.persistence.interfaces.IGame_persistence;
import dal.asdc.persistence.interfaces.IGame_player_score_persistence;
import dal.asdc.persistence.interfaces.IPlayer_persistence;

/**
 * @author Reshma Unnikrishnan **/

public class Game_score_history implements IScore_history{
	
	Persistence_factory_abstract persistence_factory = new Persistence_factory();
	Model_factory_abstract model_factory = new Model_factory();
	
	IGame_player_score_persistence game_player_score_persistence = persistence_factory.create_game_player_score_persistence();
	IPlayer_persistence player_persistence = persistence_factory.create_player_persistence();
	IGame_persistence game_persistence = persistence_factory.create_game_persistence();
	
	IGame game = model_factory.create_game();
	IPlayer player = model_factory.create_player();
	IGame_player_score game_player_score = model_factory.create_game_player_score();
	
	private List<IGame_player_score> game_player_score_list = new ArrayList<>();
	
	@Override
	public void save_history() {
		game_player_score_persistence.insert_score(game_player_score);
	}

	@Override
	public void load_history(int game_id) {
		game_player_score_list = game_player_score_persistence.get_game_score(game_id);
	}

	@Override
	public Map<String,String> form_score_board() {
		int player_id=0;
		Map<String,String> player_score_map = new HashMap<String,String>();
		for(IGame_player_score model : game_player_score_list) {
            player_id = model.getPlayer_id();
            player = player_persistence.filter_by_id(player_id);
    		String player_name = player.getPlayer_name();
    		String player_score = String.valueOf(model.getScore());
    		player_score_map.put("player_name", player_name);
    		player_score_map.put("player_score", player_score);
        }
		
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
