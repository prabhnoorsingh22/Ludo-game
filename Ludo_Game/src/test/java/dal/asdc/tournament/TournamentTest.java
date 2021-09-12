package dal.asdc.tournament;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Reshma Unnikrishnan **/
class TournamentTest {

	private Tournament tournament;
	private Mock_tournament mock_tournament = new Mock_tournament();
	
	
	@BeforeEach
	void initEach() {
		tournament = new Tournament();
	}
	
	@Test
	void testGet_tournament_players() {
		mock_tournament.form_players();
		assertEquals(12,tournament.get_tournament_players(mock_tournament.group_map).size());
	}

	@Test
	void testForm_next_round_players() {
		assertEquals(8,tournament.form_next_round_players(mock_tournament.winners_list).size());
	}

	@Test
	void testSchedule_games() {
		tournament.schedule_games(mock_tournament.group_map);
		assertEquals(8,mock_tournament.winners_list.size());
	}
	
	@Test
	void testSchedule_games_with_one_group() {
		tournament.schedule_games(mock_tournament.one_group_map);
		assertEquals(2,tournament.tournament_winners.size());
	}
	
	@Test
	void testSchedule_games_with_10_players() {
		tournament.schedule_games(mock_tournament.group_map_ten_players);
		assertEquals(8,mock_tournament.winners_list.size());
	}

	@Test
	void testForm_further_round_groups() {
		mock_tournament.form_players();
		assertEquals(3,tournament.form_further_round_groups(mock_tournament.players).size());
	}

}
