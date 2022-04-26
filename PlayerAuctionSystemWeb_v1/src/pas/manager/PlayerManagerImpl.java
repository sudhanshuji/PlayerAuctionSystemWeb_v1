package pas.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import pas.dao.DBUtil;
import pas.dao.PlayerDao;
import pas.dao.PlayerDaoImpl;
import pas.entity.Player;
import pas.exceptions.DaoException;
import pas.exceptions.DuplicateEntryException;
import pas.exceptions.InvalidCategoryException;
import pas.exceptions.InvalidDataException;
import pas.exceptions.InvalidTeamNameException;
import pas.exceptions.NotABatsmanException;
import pas.exceptions.NotABowlerException;
import pas.exceptions.ServiceException;
import pas.util.ValidationUtilityImpl;

public class PlayerManagerImpl implements PlayerManager {

	PlayerDao dao;
	ValidationUtilityImpl validationUtil;

	public PlayerManagerImpl() {
		dao = new PlayerDaoImpl();
		validationUtil = new ValidationUtilityImpl();
	}

	@Override
	public String insertPlayer(Player player) throws ServiceException, InvalidDataException {

		boolean isValid = false;
		try {
			isValid = validationUtil.isPlayerValid(player);
		} catch (DuplicateEntryException | NotABatsmanException | NotABowlerException | InvalidTeamNameException
				| InvalidCategoryException | DaoException e) {
			throw new InvalidDataException(e);
		}
		if (isValid) {
			try {
				dao.insertPlayer(player);
				int teamId = dao.retrieveTeamIdByTeamName(player.getTeam().getTeamName());

				int playerNumber = dao.getLatestPlayerNo();

				if (dao.insertTeamPlayer(teamId, playerNumber)) {
					return "Player Added successfully";
				}
			} catch (DaoException ex) {
				throw new ServiceException(ex);
			}

		} else {
		}
		return "Some error";

	}

	@Override
	public Set<String> listTeamNames() {
		
		return null;
	}

//	@Override
//	public boolean checkPlayerName(String playerName) throws DuplicateEntryException  {
//		if(!validation.isPlayerNameValid(playerName))
//			throw new DuplicateEntryException("Player Name already exist in the database");
//		else 
//			return true;
//		}
//
//	@Override
//	public boolean checkTeamName(String teamName) throws InvalidTeamNameException {
//		if(!validation.validateTeamName(teamName))
//			throw new InvalidTeamNameException("Invalid team name, please check your input");
//		else
//			return true;
//	}
//
//	@Override
//	public boolean checkHighestScore(int highestScore) throws NotABatsmanException {
//		if(!validation.validateHighestScore(highestScore))
//			throw new NotABatsmanException("Invalid Batsman, please check your input");
//		else
//			return true;
//	}
//
//	@Override
//	public boolean checkBestFigure(int score,String bestFigure) throws NotABowlerException {
//		if (!validation.validateBestFigure(score, bestFigure))
//				throw new NotABowlerException("Invalid Batsman, please check your input");
//		else
//			return true;
//	}
//
//	@Override
//	public boolean checkCategory(String category) throws InvalidCategoryException{
//		if(!validation.validateCategory(category))
//			throw new InvalidCategoryException("Invalid category name please check your input");
//		else 
//			return true;
//	}

}
