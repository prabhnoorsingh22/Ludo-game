package dal.asdc.player;

import dal.asdc.player.Factory_classes.Player_factory;
import dal.asdc.player.Factory_classes.Player_factory_normal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

class Player_intialiserTest {
    @Test
    void intialise_test_red_command() {

        Player_factory player_factory = new Player_factory_normal();
        IPlayer_intialiser iPlayer_intialiser = player_factory.create_player_intialiser();
        iPlayer_intialiser.intialise(4);

        Map<String, Player> player_list= new HashMap<>();
        player_list = iPlayer_intialiser.getPlayer_list();

        final int[][] RED_HOME_POSITION={{2,3},{3,3},{3,2},{2,2}};
        Player red_player = player_list.get("0");
        int [][] position = red_player.getPosition();
        Assertions.assertArrayEquals(position,RED_HOME_POSITION);

    }

    @Test
    void intialise_test_blue_command() {
        Player_factory player_factory = new Player_factory_normal();
        IPlayer_intialiser iPlayer_intialiser = player_factory.create_player_intialiser();

        iPlayer_intialiser.intialise(4);

        Map<String, Player> player_list= new HashMap<>();
        player_list = iPlayer_intialiser.getPlayer_list();


        final int[][] BLUE_HOME_POSITION={{2,12},{2,11},{3,12},{3,11}};
        Player blue_player = player_list.get("3");
        int [][] position = blue_player.getPosition();

        Assertions.assertArrayEquals(position,BLUE_HOME_POSITION);
    }

    @Test
    void intialise_test_yellow_command() {
        Player_factory player_factory = new Player_factory_normal();
        IPlayer_intialiser iPlayer_intialiser = player_factory.create_player_intialiser();

        iPlayer_intialiser.intialise(4);
        Map<String, Player> player_list= new HashMap<>();
        player_list = iPlayer_intialiser.getPlayer_list();

        final int[][] YELLOW_HOME_POSITION={{11,12},{11,11},{12,11},{12,12}};
        Player yellow_player = player_list.get("1");
        int [][] position = yellow_player.getPosition();

        Assertions.assertArrayEquals(position,YELLOW_HOME_POSITION);
    }

    @Test
    void intialise_test_green_command() {
        Player_factory player_factory = new Player_factory_normal();
        IPlayer_intialiser iPlayer_intialiser = player_factory.create_player_intialiser();
        iPlayer_intialiser.intialise(4);
        Map<String, Player> player_list= new HashMap<>();
        player_list = iPlayer_intialiser.getPlayer_list();

        final int[][] GREEN_HOME_POSITION={{11,3},{12,3},{12,2},{11,2}};
        Player green_player = player_list.get("2");
        int [][] position = green_player.getPosition();

        Assertions.assertArrayEquals(position,GREEN_HOME_POSITION);
    }

    @Test
    void intialise_aggressive_player() {
        Player_factory player_factory = new Player_factory_normal();
        IPlayer_intialiser iPlayer_intialiser = player_factory.create_player_intialiser();
        iPlayer_intialiser.intialise_aggressive_computer_player();

        Map<String, Player> player_list= new HashMap<>();
        player_list = iPlayer_intialiser.getPlayer_list();

        Player human_player = player_list.get("0");
        Player computer_player = player_list.get("1");

        final int[][] RED_HOME_POSITION={{2,3},{3,3},{3,2},{2,2}};
        final int[][] YELLOW_HOME_POSITION={{11,12},{11,11},{12,11},{12,12}};

        Assertions.assertArrayEquals(human_player.getPosition(),RED_HOME_POSITION);
        Assertions.assertArrayEquals(computer_player.getHome_position(),YELLOW_HOME_POSITION);

    }

    @Test
    void intialise_easy_player() {
        Player_factory player_factory = new Player_factory_normal();
        IPlayer_intialiser iPlayer_intialiser = player_factory.create_player_intialiser();
        iPlayer_intialiser.intialise_easy_computer_player();

        Map<String, Player> player_list= new HashMap<>();
        player_list = iPlayer_intialiser.getPlayer_list();

        Player human_player = player_list.get("0");
        Player computer_player = player_list.get("1");

        final int[][] RED_HOME_POSITION={{2,3},{3,3},{3,2},{2,2}};
        final int[][] YELLOW_HOME_POSITION={{11,12},{11,11},{12,11},{12,12}};

        Assertions.assertArrayEquals(human_player.getPosition(),RED_HOME_POSITION);
        Assertions.assertArrayEquals(computer_player.getHome_position(),YELLOW_HOME_POSITION);
    }
}