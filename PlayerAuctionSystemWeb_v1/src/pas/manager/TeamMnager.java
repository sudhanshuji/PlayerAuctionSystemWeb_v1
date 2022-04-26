package pas.manager;

import java.util.List;
import java.util.Set;

import pas.dto.PlayerDto;
import pas.entity.Player;
import pas.exceptions.InvalidTeamNameException;
import pas.exceptions.ServiceException;

public interface TeamMnager {

	List<PlayerDto> fetchPlayerByTeam(String teamName) throws ServiceException;

	Set<String> listTeamNames() throws ServiceException;
}
