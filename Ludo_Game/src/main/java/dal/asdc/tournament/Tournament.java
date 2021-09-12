package dal.asdc.tournament;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dal.asdc.persistence.Player_persistence;
import dal.asdc.persistence.interfaces.IPlayer_persistence;
import dal.asdc.tournament.interfaces.ITournament;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tournament implements ITournament{ 
	private static final Logger LOGGER = LoggerFactory.getLogger(Tournament.class);

	IPlayer_persistence iPlayer_persistence_obj;
	
	public Tournament(){
		iPlayer_persistence_obj = new Player_persistence();
	}
	
	
	public ArrayList<Integer> tournament_players_list = new ArrayList();
	public Map<String,Integer> tournament_winners = new HashMap<String,Integer>();
	
	public ArrayList<Integer> get_tournament_players(Map<Integer, List<Integer>> group_map){
		group_map.forEach((k,v) -> {
			for(int i=0;i<v.size();i++) {
				tournament_players_list.add(v.get(i));
			}
		});
		LOGGER.info("Tournament player list : "+tournament_players_list);
		return tournament_players_list;
	}
	
	public ArrayList<Integer> form_next_round_players(List<Integer> winners_list){
		LOGGER.info("Winners list : "+ winners_list);
		ArrayList<Integer> next_round_players_list = new ArrayList();
		for(int i =0;i<winners_list.size();i++) {
			next_round_players_list.add(winners_list.get(i));
		};
		LOGGER.info("Next round players list size : "+next_round_players_list.size());
		return next_round_players_list;
	}
	
	
	public void schedule_games(Map<Integer, List<Integer>> group_map) {
		int num_of_groups = group_map.size();
		
		Map<Integer,List<Integer>> next_group = new HashMap<Integer,List<Integer>>();
		if(num_of_groups != 1) {
			ArrayList<Integer> next_round_players_list = new ArrayList();
			ArrayList<Integer> winners_list = new ArrayList();
		group_map.forEach((k,v) -> {
			Map<String,Integer> winner_map = new HashMap<String,Integer>();
			winner_map = game(v);
			winner_map.forEach((w,id) -> {
				winners_list.add(id);
			}); 
		});
			next_round_players_list = form_next_round_players(winners_list);
			next_group = form_further_round_groups(next_round_players_list);
			schedule_games(next_group);
		}else {
			group_map.forEach((k,v) -> {
				Map<String,Integer> winner_map = new HashMap<String,Integer>();
				winner_map = game(v);
				winner_map.forEach((w,id) -> {
					tournament_winners.put(w, id);
				}); 
			});
		}
	}

	
	public Map<Integer, List<Integer>> form_further_round_groups(ArrayList<Integer> next_round_players_list){
		List<Integer> player_id_list = new ArrayList<Integer>();
		LOGGER.info("Next round players list size : "+next_round_players_list.size());
		for(int i =0;i<next_round_players_list.size();i++) {
			player_id_list.add(next_round_players_list.get(i));
		}
		
		int temp = player_id_list.size()%4;
		Map<Integer,List<Integer>> next_group = new HashMap<Integer,List<Integer>>();
		if(temp > 2 || temp == 0) {
			int num_of_groups = (player_id_list.size()+3)/4;
			int start = 0;
			for(int i = 0;i<num_of_groups;i++) {
				List<Integer> group_list = new ArrayList<Integer>();
				for(int j = start; j<start+4;j++) {
					try {
					group_list.add(player_id_list.get(j));
					}catch(ArrayIndexOutOfBoundsException e) {
						LOGGER.info("Reached the end of the list");
					} 
				}
				next_group.put(i, group_list);
				start+=4;
			}
			LOGGER.info("Next group list");
			next_group.forEach((k,v) -> {
				System.out.println(k+" -- "+v);
			});
		}else {
			int num_of_groups = (player_id_list.size()+3)/4;
			LOGGER.info("Group size : "+num_of_groups);
			int start = 0;
			for(int i = 0;i<num_of_groups;i++) {
				List<Integer> group_list = new ArrayList<Integer>();
				LOGGER.info("start+(player_id_list.size()/2) : "+start+(player_id_list.size()/2));
				for(int j = start; j<start+(player_id_list.size()/2);j++) {
					LOGGER.info("Start value 1 : "+start);
					try {
					group_list.add(player_id_list.get(j));
					}catch(ArrayIndexOutOfBoundsException e) {
						LOGGER.info("Reached the end of the list");
					} 
				}
				next_group.put(i, group_list);
				start = start+(player_id_list.size()/2);
				LOGGER.info("Start value 2 : "+start);
			}
			LOGGER.info("Next group list");
			next_group.forEach((k,v) -> {
				System.out.println(k+" -- "+v);
			});
		}
		player_id_list.clear();
		return next_group;
	}
	
	public Map<String,Integer> game (List<Integer> players_id){
		LOGGER.info("Game started ... ");
		Map<String,Integer> winner_map = new HashMap<String,Integer>();
		winner_map.put("Winner",players_id.get(1));
		winner_map.put("Runner",players_id.get(2));
		return winner_map;
	}
	
}
