package dal.asdc.player;

import java.util.Map;

public interface IPlayer_intialiser {
    void intialise(int number_of_players);
    Map<String, Player> getPlayer_list();
    void intialise_aggressive_computer_player();
    void intialise_easy_computer_player();
}
