package pas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import pas.entity.Player;
import pas.exceptions.DBUtilException;
import pas.exceptions.DaoException;

public class PlayerDaoImpl implements PlayerDao {
	String sql = "";
	String sql1 = "";

	@Override
	public boolean insertPlayer(Player player) throws DaoException {
		int result = 0;
		int count = 0;
		sql = "insert into Player Values (null,?,?,?,?)";
		// sql1="insert into Team_Player(Player_No) Values (";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			Statement st = conn.createStatement();
			//ps.setInt(1, player.getPlayerNo());
			ps.setString(1, player.getPlayerName());
			ps.setString(2, player.getCategory());
			ps.setInt(3, player.getHighestScore());
			ps.setString(4, player.getBestFigure());
			result = ps.executeUpdate();
			ResultSet rs = st.executeQuery(
					"select Player_No from Player where Player_Name = '" + player.getPlayerName() + "'" + " ;");
			while (rs.next()) {
				count = rs.getInt(1);
				// st.executeQuery(sql1+");");
			}
		} catch (DBUtilException e) {
			throw new DaoException(e);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		if (result >= 1) {
			//System.out.println("Player added succesfully with player No :-" + count);
			return true;
		} else
			return false;
	}

	@Override
	public int retrieveTeamIdByTeamName(String teamName) throws DaoException {
		int teamId = 0;
		sql = "select team_Id from Team where Team_Name = '" + teamName + "'";
		try {
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				teamId = rs.getInt(1);
			}
		} catch (DBUtilException e) {
			throw new DaoException(e);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		return teamId;
	}

	@Override
	public boolean insertTeamPlayer(int teamId, int playerNumber) throws DaoException {
		int upd = 0;
		sql = "insert into Team_Player Values (" + playerNumber + "," + teamId + ")";
		//System.out.println("QUery is " + sql);
		try {
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			upd = st.executeUpdate(sql);
		} catch (DBUtilException e) {
			throw new DaoException(e);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		if (upd > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int getLatestPlayerNo() throws DaoException {
		int latestPlayerNo = 0;
		sql = "select MAX(Player_No) from Player";
		try {
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				latestPlayerNo = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} catch (DBUtilException e) {
			throw new DaoException(e);
		}
		return latestPlayerNo;
	}

	@Override
	public Set<String> listPlayersNames() throws DaoException {
		Set<String> playersName = new HashSet<>();
		String sql = "select Player_Name from Player;";
		try {
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				playersName.add(rs.getString(1));
			}
		} catch (SQLException | DBUtilException e) {
			throw new DaoException(e);
		}
		//System.out.println(playersName.toString());
		return playersName;
	}

}
