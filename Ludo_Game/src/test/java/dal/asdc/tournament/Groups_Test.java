package dal.asdc.tournament;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import dal.asdc.model.Player;
import dal.asdc.persistence.Player_persistence;
import dal.asdc.persistence.interfaces.IPlayer_persistence;

public class Groups_Test {
	 private IPlayer_persistence plyr_dao = new Player_persistence();
	 List<Integer> player_list = new ArrayList<>();
	 
	@Test
    public void form_tournament_groups_test(){	
		 int no_of_players = 6;		
		 player_list = plyr_dao.select_n_players(no_of_players);	
		 Map<Integer, Collection<List<Player>>> map = new HashMap<>();
		 final AtomicInteger counter = new AtomicInteger();
		 final Collection<List<Integer>> result = player_list.stream()
		     .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 4))
		     .values();
		 Object[] resultant_players = result.toArray();
		 for (int i = 0; i < resultant_players.length; i++) {
			  map.put(i+1 , (Collection<List<Player>>) resultant_players[i]);
		 }			
		 assertEquals(map.size(), 2);
		 assertEquals(map.get(1).size(), 4);
		 assertEquals(map.get(2).size(), 2);
    }
}
