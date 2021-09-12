package dal.asdc.model;

import org.springframework.stereotype.Component;

import dal.asdc.model.interfaces.IGame_menu;

/**
 * @author Reshma Unnikrishnan**/

@Component
public class Game_menu implements IGame_menu{
	public String game_menu;
	 
	public String getgame_menu() {
		if(game_menu != null) {
			return game_menu;
		}
		else {
			return "1";
		}
	}
 
	public void setgame_menu(String game_menu) {
		if(game_menu != null) {
			this.game_menu = game_menu;
		}
		else {
			this.game_menu = "1";
		}
	}
}