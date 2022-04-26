package pas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pas.dto.PlayerDto;
import pas.entity.Player;
import pas.exceptions.DBUtilException;
import pas.exceptions.DaoException;

public class TeamDaoImpl implements TeamDao {

	String sql = "";

	@Override
	public Set<String> listTeamNames() throws DaoException {
		Set<String> teamsName = new HashSet<>();
		sql = "select team_name from team";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				teamsName.add(rs.getString(1));
			}
		} catch (DBUtilException | SQLException e) {
			throw new DaoException(e);
		}
		//System.out.println(teamsName.toString());
		return teamsName;
	}

	@Override
	public List<PlayerDto> fetchPlayerByTeamName(String teamName) throws DaoException {
		List<PlayerDto> players = new ArrayList<PlayerDto>();

		sql = "select player_name,category from player where player_no IN (select player_no from team_player tp inner join team t on tp.team_id=t.team_id where team_name = ?)";
		Connection conn;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, teamName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PlayerDto player = new PlayerDto();
				player.setPlayerName(rs.getString(1));
				player.setCategory(rs.getString(2));
				players.add(player);
			}
		} catch (DBUtilException | SQLException e) {
			throw new DaoException(e);
		}

		return players;
	}

}
