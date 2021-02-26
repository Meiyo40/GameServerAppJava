package com.meiyoservices.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meiyoservices.bo.GameServer;
import com.meiyoservices.database.Database;

public class GameServerDAO implements EntityDAOJdbcImpl<GameServer>{

	@Override
	public void insert(GameServer entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameServer entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(GameServer entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GameServer selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameServer selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GameServer> selectAll() {
		try {
			List<GameServer> datalist = new ArrayList<GameServer>();
			Database.connect();
			String req = "SELECT*FROM `game_server`";
			PreparedStatement stmt = Database.getCon().prepareStatement(req);
			ResultSet rs = stmt.executeQuery();			
			while(rs.next())
			{
				GameServer serv = new GameServer(rs.getInt("id"), rs.getString("name"), rs.getString("platform"), rs.getString("dirPath"), 
						rs.getString("launchOption"), rs.getString("uptime"), rs.getString("lastBoot"));
				datalist.add(serv);
			}
			Database.disconnect();
			return datalist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
