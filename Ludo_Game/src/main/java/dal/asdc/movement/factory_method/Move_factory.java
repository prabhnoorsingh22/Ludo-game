package dal.asdc.movement.factory_method;
/**
 * @author Kishan Rakeshbhai Patel **/
import dal.asdc.movement.ICheck_move;
import dal.asdc.movement.IMake_move;

public abstract class Move_factory {
	
	public abstract ICheck_move create_check_move(); 
	
	public abstract IMake_move create_make_move();
	
}
