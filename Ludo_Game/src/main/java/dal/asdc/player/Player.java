package dal.asdc.player;

import dal.asdc.playing_pieces.Token;

import java.util.List;

public abstract class Player {
    public abstract List<Token> play(List<Token> tokenList);
    public abstract List<Token> get_all_tokens();
	public abstract void setColour(String string);
	public abstract void setPosition(int[][] position);
	public abstract void set_selected_token(Token token);
	public abstract String getColour();
	public abstract Token get_selected_token(int i);
	public abstract boolean get_is_done();
	public abstract void set_is_done(boolean b);
	public abstract void set_tokens(List<Token> four_tokens);
	public abstract int[][] getPosition();
	public abstract void setHome_position(int[][] gREEN_HOME_POSITION);
	public abstract int[][] getHome_position();


}
