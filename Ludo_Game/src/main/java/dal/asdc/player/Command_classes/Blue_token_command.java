package dal.asdc.player.Command_classes;


import dal.asdc.player.Player;
import dal.asdc.player.Player_command;
import dal.asdc.playing_pieces.Token;
import dal.asdc.playing_pieces.factoy_method.Four_colour_token_factory;
import dal.asdc.playing_pieces.factoy_method.Token_factory;

public class Blue_token_command extends Player_command {
    private Player player;
    private final int[][] BLUE_HOME_POSITION={{2,12},{2,11},{3,12},{3,11}};

    public Blue_token_command(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.setPosition(BLUE_HOME_POSITION);
        Token_factory token_factory = new Four_colour_token_factory();
        for(int i=0;i<4;i++){
            Token token = token_factory.crete_blue_token(i);
            player.set_selected_token(token);
        }
    }
}
