package dal.asdc.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dal.asdc.game_handler.ILudo_game;
import dal.asdc.game_handler.Ludo_game;
import dal.asdc.game_handler.factory_method.Four_player_ludo_game_factory;
import dal.asdc.game_handler.factory_method.Ludo_game_factory;
import dal.asdc.ludo_board_structure.Ludo_board_formation;
import dal.asdc.ludo_board_structure.Token_positions;
import dal.asdc.model.Game_token_positions;

/**
 * @author Reshma Unnikrishnan **/
@Controller
public class Board_controller {
	
	Ludo_board_formation l_board = new Ludo_board_formation();
	ILudo_game ludo_game;
	Token_positions token_pos = new Token_positions();
	String type;
	Map<Integer,String> player_map;
	
	@Autowired
	Game_token_positions gm_tk_pos;

	@RequestMapping("home")
	public String home() {
		return "ludo_board.jsp";
	}
	
	@RequestMapping("/start_game")
	public String display_board() {
		return "ludo_board.jsp";
	}
	
	@RequestMapping(value="/game_menu", method=RequestMethod.POST)
	public String decide_game_menu(@RequestParam("game_menu") int gmenu, Model model) {
		model.addAttribute("gamemenu", gmenu);
		type = l_board.add_game_type(gmenu);
		System.out.println();
		Map<Integer,String> player_map = new HashMap<Integer,String>(){{
			put(4, "Jay");
			put(5, "Rahul");
		}};
		Ludo_game_factory ludo_factory = new Four_player_ludo_game_factory();
		ludo_game = ludo_factory.create_ludo_game(type,player_map);
		String current_turn = ludo_game.get_current_turn_text();
		model.addAttribute("turn", current_turn);		
        Map<String,String> token_positions = new HashMap<String,String>();
        token_positions = ludo_game.get_position_of_all_tokens();
    	model.addAttribute("token_path", token_positions);
		return "ludo_board.jsp";
	}
	
	@RequestMapping(value="/move_token", method=RequestMethod.POST)
	public String game_moves(@RequestParam("move_token") String dmenu, Model model) {
		model.addAttribute("Game_token_positions", gm_tk_pos);
		model.addAttribute("move_token", dmenu);
		return "Moved... ";
	}


    @RequestMapping(value = "/token_select", method = RequestMethod.POST)
    public String token_select(@RequestParam String token, Model model) {
        model.addAttribute("token", token);
        boolean is_succeed = ludo_game.user_input_receiver(token);
        String error_message = "";
        if(!is_succeed) {
        	error_message = ludo_game.get_error_message();
        	model.addAttribute("error", error_message);
        }
        Map<String,String> token_positions = new HashMap<String,String>();
        token_positions = ludo_game.get_position_of_all_tokens();
    	model.addAttribute("token_path", token_positions);
        String current_turn = ludo_game.get_current_turn_text();
		model.addAttribute("turn", current_turn);
        return "ludo_board.jsp";
    }

    @RequestMapping(value = "/roll_dice", method = RequestMethod.GET)
    public String roll_dice(Model model) {
    	boolean is_rolled = ludo_game.roll_dice();
    	if(is_rolled) {
        	model.addAttribute("dice_num", ludo_game.get_dice_number());
    	}else {
    		String error_message = ludo_game.get_error_message();
        	model.addAttribute("error", error_message);
        	model.addAttribute("dice_num", ludo_game.get_dice_number());
    	}
    	String current_turn = ludo_game.get_current_turn_text();
		model.addAttribute("turn", current_turn);
		
		Map<String,String> token_positions = new HashMap<String,String>();
        token_positions = ludo_game.get_position_of_all_tokens();
    	model.addAttribute("token_path", token_positions);
    	
    	return "ludo_board.jsp";
    }
    
    @RequestMapping(value = "/reset_board", method = RequestMethod.GET)
    public String reset_board(Model model) {
    	ludo_game = null;
    	Ludo_game_factory ludo_factory = new Four_player_ludo_game_factory();
		ludo_game = ludo_factory.create_ludo_game(type,player_map);
		String current_turn = ludo_game.get_current_turn_text();
		model.addAttribute("turn", current_turn);		
        Map<String,String> token_positions = new HashMap<String,String>();
        token_positions = ludo_game.get_position_of_all_tokens();
    	model.addAttribute("token_path", token_positions);
    	return "ludo_board.jsp";
    }
	
    @RequestMapping(value = "/back_to_menu", method = RequestMethod.GET)
    public String back_to_menu(Model model) {
    	ludo_game = null;
    	return "Dashboard_menu.jsp";
    }
}
