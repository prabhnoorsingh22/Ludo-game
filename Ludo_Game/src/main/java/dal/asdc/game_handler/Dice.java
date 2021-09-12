package dal.asdc.game_handler;
/**
 * @author Kishan Rakeshbhai Patel **/
import java.util.Random;

public class Dice implements IDice{

	private static final int RANGE_TO_GET_NUMBER = 6;

	public int roll_dice(){
	        Random random = new Random();
	        int number = random.nextInt(RANGE_TO_GET_NUMBER)+1;
	        return number;
	    }
}
