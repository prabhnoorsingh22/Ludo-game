package dal.asdc.movement;
/**
 * @author Kishan Rakeshbhai Patel **/

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dal.asdc.game_handler.Dice;
import dal.asdc.game_handler.IDice;
import dal.asdc.game_handler.factory_method.Four_player_ludo_game_factory;
import dal.asdc.game_handler.factory_method.Ludo_game_factory;

public class Dice_test {

	@Test
    public void roll_dice_test(){
		Ludo_game_factory game_factory = new Four_player_ludo_game_factory();
		IDice dice = game_factory.create_dice();
		int number_test = dice.roll_dice();
        assertTrue(number_test>=0 && number_test<=6);

    }
}
