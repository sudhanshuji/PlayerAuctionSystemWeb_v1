package pas.dao;

import java.util.List;
import java.util.Set;

import pas.dto.PlayerDto;
import pas.entity.Player;
import pas.exceptions.DaoException;

public interface TeamDao {

	Set<String> listTeamNames() throws DaoException;

	List<PlayerDto> fetchPlayerByTeamName(String teamName) throws DaoException;

}
