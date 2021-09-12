package dal.asdc.player.Command_classes;

import dal.asdc.player.Player;
import dal.asdc.player.Player_command;
import dal.asdc.playing_pieces.Token;
import dal.asdc.playing_pieces.factoy_method.Four_colour_token_factory;
import dal.asdc.playing_pieces.factoy_method.Token_factory;

public class Red_token_command extends Player_command {

    private Player player;
    private final int[][] RED_HOME_POSITION={{2,3},{3,3},{3,2},{2,2}};
    public Red_token_command(Player red_player) {
        this.player = red_player;
    }

    public void execute() {
        player.setPosition(RED_HOME_POSITION);
        Token_factory token_factory = new Four_colour_token_factory();
        for(int i=0;i<4;i++){
            Token token = token_factory.crete_red_token(i);
            player.set_selected_token(token);
        }
    }
}
