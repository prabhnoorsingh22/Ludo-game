package dal.asdc.player;

import dal.asdc.game_handler.IDice;
import dal.asdc.game_handler.factory_method.Four_player_ludo_game_factory;
import dal.asdc.game_handler.factory_method.Ludo_game_factory;
import dal.asdc.movement.factory_method.Move_factory;
import dal.asdc.movement.factory_method.Simple_move_factory;
import dal.asdc.playing_pieces.Token;
import dal.asdc.movement.IMake_move;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Human_player extends Player {

    private String colour;
    private int[][] position;
    private int[][] home_position;
    private boolean is_turn;
    List<Token> token_list= new ArrayList<>();
    private String name;
    private int user_id;
    private boolean is_done = false;
    private int roll;
    Move_factory move_factory = new Simple_move_factory();
    IMake_move make_move = move_factory.create_make_move();
    Ludo_game_factory ludo_game_factory = new Four_player_ludo_game_factory();
    IDice iDice = ludo_game_factory.create_dice();

    List<Player> all_player_list = new ArrayList<>();
    Player_intialiser intialiser;
    Map<String, Player> player_list= new HashMap<>();

    public Human_player(){

    }
    public Human_player(String colour){
        this.colour=colour;
    }
    public int roll(){
        roll= iDice.roll_dice();
        return roll;
    }
    public List<Token> play(List<Token> token_list){

        player_list = intialiser.getPlayer_list();

        for (int i = 0; i < 4; i++) {
            all_player_list.add(player_list.get(i));
        }

        for (int i = 0; i < 4; i++) {
            make_move.play_move(token_list.get(i), roll() ,all_player_list);
        }

        return token_list;
    }
    public List<Token> get_all_tokens(){
    	return token_list;
    }

    public Token get_selected_token(int token_number){
        return token_list.get(token_number);
    }

    public void set_selected_token(Token token){
        token_list.add(token);
    }
    
    public void set_tokens(List<Token> four_tokens) {
    	token_list = four_tokens;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setPosition(int[][] position) {
        this.position = position;
    }

    public boolean get_is_done(){
        return is_done;
    }

    public void set_is_done(boolean is_done) {
        this.is_done = is_done;
    }

    public int[][] getPosition() {
        return position;
    }
	@Override
	public void setHome_position(int[][] gREEN_HOME_POSITION) {
        this.home_position = home_position;		
	}

    @Override
    public int[][] getHome_position() {
        return new int[0][];
    }
}
