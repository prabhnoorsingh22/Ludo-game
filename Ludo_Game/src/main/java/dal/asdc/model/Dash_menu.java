package dal.asdc.model;

import org.springframework.stereotype.Component;

import dal.asdc.model.interfaces.IDash_menu;

/**
 * @author Reshma Unnikrishnan**/

@Component
public class Dash_menu implements IDash_menu{
	public String dash_menu;
	 
	public String getdash_menu() {
		if(dash_menu != null) {
			return dash_menu;
		}
		else {
			return "1";
		}
	}
 
	public void setdash_menu(String dash_menu) {
		if(dash_menu != null) {
			this.dash_menu = dash_menu;
		}
		else {
			this.dash_menu = "1";
		}
	}
}
