package dal.asdc.player.Command_classes;


import dal.asdc.player.Player;
import dal.asdc.player.Player_command;
import dal.asdc.playing_pieces.Token;
import dal.asdc.playing_pieces.factoy_method.Four_colour_token_factory;
import dal.asdc.playing_pieces.factoy_method.Token_factory;

public class Yellow_token_command extends Player_command {

    private Player player;
    private final int[][] YELLOW_HOME_POSITION={{11,12},{11,11},{12,11},{12,12}};

    public Yellow_token_command(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.setPosition(YELLOW_HOME_POSITION);
        Token_factory token_factory = new Four_colour_token_factory();
        for(int i=0;i<4;i++){
            Token token = token_factory.crete_yellow_token(i);
            player.set_selected_token(token);
        }
    }
}
