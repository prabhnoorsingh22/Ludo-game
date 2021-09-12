package dal.asdc.tournament.interfaces;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import dal.asdc.model.Player;
import dal.asdc.model.interfaces.IPlayer;

public interface IGroups {
	public Map<Integer, Collection<List<IPlayer>>> form_tournaments_group();
}
