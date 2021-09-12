package dal.asdc.movement.factory_method;
/**
 * @author Kishan Rakeshbhai Patel **/

import dal.asdc.movement.Check_move;
import dal.asdc.movement.ICheck_move;
import dal.asdc.movement.IMake_move;
import dal.asdc.movement.Make_move;

public class Simple_move_factory extends Move_factory {
	
	public ICheck_move create_check_move() {
		return new Check_move();
	}
	
	public IMake_move create_make_move() {
		return new Make_move();
	}
}
