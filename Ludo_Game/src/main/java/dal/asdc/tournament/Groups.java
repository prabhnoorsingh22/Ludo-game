package dal.asdc.tournament;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import dal.asdc.model.Player;
import dal.asdc.model.interfaces.IPlayer;
import dal.asdc.persistence.Player_persistence;
import dal.asdc.persistence.interfaces.IPlayer_persistence;
import dal.asdc.tournament.interfaces.IGroups;

public class Groups implements IGroups{
 private IPlayer_persistence plyr_dao = new Player_persistence();
 List<Integer> player_list = new ArrayList<>();
 
 public Map<Integer, Collection<List<IPlayer>>> form_tournaments_group() {
	 Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
	 int no_of_players = 0;
	 do{
		 System.out.print("Enter number of players - ");  
		 no_of_players = sc.nextInt(); 
     }
     while( !(no_of_players > 1) );
	 if(no_of_players > 1) {
		 System.out.print("Input Accepted. Forming groups... ");  
	 }
	 player_list = plyr_dao.select_n_players(no_of_players);	
	 Map<Integer, Collection<List<IPlayer>>> map = new HashMap<>();
	 final AtomicInteger counter = new AtomicInteger();
	 final Collection<List<Integer>> result = player_list.stream()
	     .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 4))
	     .values();
	 Object[] resultant_players = result.toArray();
	 for (int i = 0; i < resultant_players.length; i++) {
		  map.put(i+1 , (Collection<List<IPlayer>>) resultant_players[i]);
	 }
	 System.out.println(map);
	 return map;
 }
}
