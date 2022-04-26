package pas.dao;

import java.util.Set;

import pas.entity.Player;
import pas.exceptions.DaoException;

public interface PlayerDao {

	boolean insertPlayer(Player player) throws DaoException;

	int retrieveTeamIdByTeamName(String teamName) throws DaoException;

	boolean insertTeamPlayer(int teamId, int playerNumber) throws DaoException;

	int getLatestPlayerNo() throws DaoException;

	Set<String> listPlayersNames() throws DaoException;
}
