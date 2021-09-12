package dal.asdc.player.Factory_classes;

import dal.asdc.player.*;
import dal.asdc.player.Factory_classes.Player_factory;

public class Player_factory_normal extends Player_factory {
    @Override
    public Player create_aggressive_computer_player() {
        return new Aggressive_computer_player();
    }

    @Override
    public Player create_easy_computer_player() {
        return new Easy_computer_player();
    }

    @Override
    public Player create_human_player() {
        return new Human_player();
    }

    @Override
    public IPlayer_intialiser create_player_intialiser() {
        return new Player_intialiser();
    }
}
