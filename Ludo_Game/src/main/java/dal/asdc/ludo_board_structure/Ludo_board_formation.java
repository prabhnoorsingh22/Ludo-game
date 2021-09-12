package dal.asdc.ludo_board_structure;

import java.util.*;

import dal.asdc.ludo_board_structure.interfaces.ILudo_board_formation;

/**
 * @author Reshma Unnikrishnan**/

public class Ludo_board_formation implements ILudo_board_formation{
	
	int [][] board = new int [15][15];
    int board_value_count = 0;
    Map<String,Integer> movable_positions_map = new HashMap<String,Integer>();
    Map<String,Integer> safe_positions_map = new HashMap<String,Integer>();
    Map<String,Integer> winning_positions_map = new HashMap<String,Integer>();
    static int player_num = 0;
    Token_positions tk_pos = new Token_positions();
    
    public void form_matrix(){
        int value=1;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++) {
                board[i][j] = value;
                value = value + 1;
                board_value_count = board_value_count+1;
            }
        }
    }
    
    public void set_movable_positions(){
        int count=0,count2= 0;
        for(int i=0;i<board.length;i++){
            if(i!=6 && i!=7 &&i!=8 ){
                for(int j=6;j<9;j++) {
                    movable_positions_map.put("[" + i + "][" + j + "]",board[i][j]);
                    count = count + 1;
                }  }
        }

        for(int i=6;i<9;i++){
            for(int j=0;j< board.length;j++) {
                if(j!=6 && j!=7 && j!=8 ){
                    movable_positions_map.put("[" + i + "][" + j + "]",board[i][j]);
                    count2 = count2 + 1;
                }  }
        }

    }
    
    public void set_safe_positions(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++) {
                if(i==1&&j==8 || i==2&&j==6 || i==6&&j==1 || i==6&&j==12 || i==8&&j==2 || i==8&&j==13 || i==12&&j==8 || i==13&&j==6){
                	safe_positions_map.put("[" + i + "][" + j + "]",board[i][j]);
                }
            }
        }
    }
    
    public void set_winning_square() {
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                winning_positions_map.put("[" + i + "][" + j + "]",board[i][j]);
            }
        }
    }
    
    public String add_game_type(int choice) {
    	String type= "";
    	if(choice == 1) {
    		player_num = 2;
    		type="two_player";
    	}else if(choice == 2) {
    		player_num = 3;
    		type="three_player";
    	}else if(choice == 3) {
    		player_num = 4;
    		type="four_player";
    	}else {
    		player_num = 5;
    		type="computer_player";
    	}
    	return type;
    }
    
    public Map<String,String> board_attributes(){
    	Map<String,String> initial_board_attributes_map = new HashMap<String,String>();
    	initial_board_attributes_map = tk_pos.get_board_attributes(player_num);
    	return initial_board_attributes_map;
    }

}