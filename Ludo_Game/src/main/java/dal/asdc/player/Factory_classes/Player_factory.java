package dal.asdc.player.Factory_classes;

import dal.asdc.player.IPlayer_intialiser;
import dal.asdc.player.Player;

public abstract class Player_factory {
    public abstract Player create_aggressive_computer_player();
    public abstract Player create_easy_computer_player();
    public abstract Player create_human_player();
    public abstract IPlayer_intialiser create_player_intialiser();
}
