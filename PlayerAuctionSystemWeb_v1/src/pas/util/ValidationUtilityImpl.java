package pas.util;

import java.util.Locale.Category;

import pas.dao.PlayerDao;
import pas.dao.PlayerDaoImpl;
import pas.dao.TeamDao;
import pas.dao.TeamDaoImpl;
import pas.entity.Player;
import pas.exceptions.*;
import pas.manager.PlayerManagerImpl;
import pas.manager.TeamManagerImpl;

public class ValidationUtilityImpl {

	private boolean isCategoryValid(String category) {
		if (category.equalsIgnoreCase("Batsman") == true || category.equalsIgnoreCase("Bowler") == true
				|| category.equalsIgnoreCase("Allrounder") == true)
			return true;
		else
			return false;
	}

	private boolean isHighestScoreValid(int score) {
		if (score >= 50 && score <= 200)
			return true;
		else
			return false;
	}

	private boolean isBestFigureValid(int score, String bestfigure) {
		if (score > 0 && bestfigure != null) {
			if (bestfigure.matches("[\\d]+[/][\\d]+"))
				return true;
			else
				return false;
		} else
			return false;
	}

	private boolean isPlayerNameValid(String name) throws DaoException {
		PlayerDaoImpl forList = new PlayerDaoImpl();
		if (forList.listPlayersNames().contains(name))
			return false;
		else
			return true;
	}

	public boolean isTeamNameValid(String teamName) throws DaoException {
		TeamDao teamDao = new TeamDaoImpl();
		if (teamDao.listTeamNames().contains(teamName))
			return true;
		else
			return false;
	}

	private boolean isValidBatsman(Player player) {
		if (!player.getCategory().equalsIgnoreCase("batsman"))
			return false;
		else {
			if (isHighestScoreValid(player.getHighestScore())) {
				return true;
			} else {
				return false;
			}
		}
	}

	private boolean isValidBowler(Player player) {

		if (!player.getCategory().equalsIgnoreCase("bowler"))
			return false;
		else {
			if (isBestFigureValid(player.getHighestScore(), player.getBestFigure()))
				return true;
			else
				return false;
		}

	}

	public boolean isPlayerValid(Player player) throws DuplicateEntryException, NotABatsmanException,
			NotABowlerException, InvalidTeamNameException, InvalidCategoryException, DaoException {

//		try {
//		check.checkPlayerName(playerName);
//	} catch (DuplicateEntryException e) {
//		// TODO Auto-generated catch block
//		System.out.println(e.getMessage());
//	}

//		try {
//		check.checkHighestScore(highestScore);
//	} catch (NotABatsmanException e) {
//		// TODO Auto-generated catch block
//		System.out.println(e.getMessage());
//	}

//		try {
//		check.checkBestFigure(highestScore, bestFigure);
//	} catch (NotABowlerException e) {
//		// TODO Auto-generated catch block
//		System.out.println(e.getMessage());
//	}

//		try {
//		check.checkTeamName(teamName);
//	} catch (InvalidTeamNameException e) {
//		// TODO Auto-generated catch block
//		System.out.println(e.getMessage());
//	}
		if (!isCategoryValid(player.getCategory())) {
			throw new InvalidCategoryException("invalid category name");
		}
		if (!isTeamNameValid(player.getTeam().getTeamName())) {
			throw new InvalidTeamNameException("invalid team name");
		}
		if (!isPlayerNameValid(player.getPlayerName())) {
			throw new DuplicateEntryException("Player with same name exists in DB");
		}
		if (player.getCategory().equalsIgnoreCase("Batsman")) {
			if (!isValidBatsman(player)) {
				throw new NotABatsmanException("Not a valid batsman");
			}
		} else if (player.getCategory().equalsIgnoreCase("Bowler")) {
			if (!isValidBowler(player)) {
				throw new NotABowlerException("Not a valid bowler");
			}
		}

		return true;
	}

}
