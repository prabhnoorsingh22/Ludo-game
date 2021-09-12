package dal.asdc.ludo_menu;

/**
 * @author Reshma Unnikrishnan**/

public class Main_dashboard_menu {
	
	public enum menu_options{
		LOGIN,
		REGISTER,
		EXIT
	}
	
	public enum redirect_class{
		Player_login,
		Player_register
	}
	
	public static class Main_menu {
		public menu_options menu;
		public redirect_class redir = null;
		
		public Main_menu(menu_options menu) {
			this.menu = menu;
		}
		
		public redirect_class get_menu_page() {
			if(menu == menu_options.LOGIN) {
				return redirect_class.Player_login;
			}else if(menu == menu_options.REGISTER) {
				return redirect_class.Player_register;
			}else {
				return redirect_class.Player_login;
			}
		}
}
}
