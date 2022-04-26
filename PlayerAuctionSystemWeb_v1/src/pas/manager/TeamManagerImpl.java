package pas.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pas.dao.DBUtil;
import pas.dao.TeamDao;
import pas.dao.TeamDaoImpl;
import pas.dto.PlayerDto;
import pas.entity.Player;
import pas.exceptions.DaoException;
import pas.exceptions.InvalidTeamNameException;
import pas.exceptions.ServiceException;
import pas.util.ValidationUtility;
import pas.util.ValidationUtilityImpl;

public class TeamManagerImpl implements TeamMnager {

	TeamDao dao;

	public TeamManagerImpl() {
		dao = new TeamDaoImpl();
	}

	@Override
	public List<PlayerDto> fetchPlayerByTeam(String teamName) throws ServiceException {
		// validate teamName

		try {
			if (validateTeamName(teamName)) {
				try {
					return dao.fetchPlayerByTeamName(teamName);
				} catch (DaoException e) {
					throw new ServiceException(e);
				}
			} else {
				throw new ServiceException("Erroneous input");
			}
		} catch (DaoException | InvalidTeamNameException e) {
			throw new ServiceException(e);
		}

	}

	private boolean validateTeamName(String teamName) throws InvalidTeamNameException, DaoException {
		ValidationUtilityImpl validateTeam = new ValidationUtilityImpl();
		if (validateTeam.isTeamNameValid(teamName)) {
			return true;
		} else
			throw new InvalidTeamNameException("invalid team name,check your input");

	}

	@Override
	public Set<String> listTeamNames() throws ServiceException {
		Set<String> set = null;
		try {
			set = dao.listTeamNames();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return set;
	}

}
