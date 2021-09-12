package dal.asdc.player;
import dal.asdc.player.Command_classes.Blue_token_command;
import dal.asdc.player.Command_classes.Green_token_command;
import dal.asdc.player.Command_classes.Red_token_command;
import dal.asdc.player.Command_classes.Yellow_token_command;

import java.util.*;

public class Player_intialiser implements IPlayer_intialiser {

    enum Colour {
        RED,
        YELLOW,
        GREEN,
        BLUE
    }
    private final int[][] YELLOW_HOME_POSITION={{11,12},{11,11},{12,11},{12,12}};


    private Map<String, Player> player_list= new HashMap<>();
    private Map<String,Player_command> input_commands= new HashMap<>();



    public void intialise(int number_of_players){
        for (int i = 0; i < number_of_players; i++) {
            player_list.put(String.valueOf(i),new Human_player());
        }

        player_list=  randomise(player_list);
        assign_colour_home_position(player_list);
    }

    private Map<String, Player> randomise(Map<String, Player> player_list){
        List<String> colour_list = new ArrayList<String>();
        for(Colour colour: Colour.values()){
            colour_list.add(colour.toString());
        }


        for (int i=0;i<player_list.size();i++){
            player_list.get(String.valueOf(i)).setColour(colour_list.get(i));
        }

        return player_list;
    }

    private void assign_colour_home_position(Map<String, Player> player_list){

        Player red_player=player_list.get("0");
        Player blue_player=player_list.get("3");
        Player yellow_player=player_list.get("1");
        Player green_player=player_list.get("2");


        input_commands.put("RED", new Red_token_command(red_player));
        input_commands.put("YELLOW", new Yellow_token_command(yellow_player));
        input_commands.put("BLUE", new Blue_token_command(blue_player));
        input_commands.put("GREEN", new Green_token_command(green_player));

        for (int i = 0; i < player_list.size(); i++) {
            String colour=player_list.get(String.valueOf(i)).getColour();
            Player_command player_command = input_commands.get(colour);
            player_command.execute();
        }
    }

    public void intialise_aggressive_computer_player(){
        intialise(1);
        Player aggressive_computer_player = new Aggressive_computer_player();
        Colour colour = Colour.YELLOW;
        aggressive_computer_player.setColour(colour.toString());
        aggressive_computer_player.setHome_position(YELLOW_HOME_POSITION);
        player_list.put("1",aggressive_computer_player);
    }

    public void intialise_easy_computer_player(){
        intialise(1);
        Player easy_computer_player = new Easy_computer_player();
        Colour colour = Colour.YELLOW;
        easy_computer_player.setColour(colour.toString());
        easy_computer_player.setHome_position(YELLOW_HOME_POSITION);
        player_list.put("1",easy_computer_player);
    }

    public Map<String, Player> getPlayer_list() {
        return player_list;
    }
}
