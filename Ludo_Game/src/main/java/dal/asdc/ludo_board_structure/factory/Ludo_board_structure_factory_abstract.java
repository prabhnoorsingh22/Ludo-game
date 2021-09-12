package dal.asdc.ludo_board_structure.factory;

import dal.asdc.ludo_board_structure.interfaces.ILudo_board_formation;
import dal.asdc.ludo_board_structure.interfaces.IToken_paths;
import dal.asdc.ludo_board_structure.interfaces.IToken_positions;

/**
 * @author Reshma Unnikrishnan **/
public abstract class Ludo_board_structure_factory_abstract {

	public abstract ILudo_board_formation create_ludo_board_formation();
	
	public abstract IToken_paths create_token_paths();
	
	public abstract IToken_positions create_token_positions();
	
}
