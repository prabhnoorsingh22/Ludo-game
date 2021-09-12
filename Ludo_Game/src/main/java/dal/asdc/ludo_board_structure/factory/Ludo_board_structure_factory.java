package dal.asdc.ludo_board_structure.factory;

import org.springframework.stereotype.Component;

import dal.asdc.ludo_board_structure.Ludo_board_formation;
import dal.asdc.ludo_board_structure.Token_paths;
import dal.asdc.ludo_board_structure.Token_positions;
import dal.asdc.ludo_board_structure.interfaces.ILudo_board_formation;
import dal.asdc.ludo_board_structure.interfaces.IToken_paths;
import dal.asdc.ludo_board_structure.interfaces.IToken_positions;

/**
 * @author Reshma Unnikrishnan **/
public class Ludo_board_structure_factory extends Ludo_board_structure_factory_abstract{
	
	public ILudo_board_formation create_ludo_board_formation() {
		return new Ludo_board_formation();
	}
	
	public IToken_paths create_token_paths() {
		return new Token_paths();
	}
	
	public IToken_positions create_token_positions() {
		return new Token_positions();
	}
}
