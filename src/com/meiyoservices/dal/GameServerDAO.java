package com.meiyoservices.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.meiyoservices.bo.GameServer;
import com.meiyoservices.database.Database;
import com.meiyoservices.tool.WindowsProcessManager;

public class GameServerDAO implements EntityDAOJdbcImpl<GameServer>{

	@Override
	public void insert(GameServer entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameServer entity) {
		boolean isRunning = WindowsProcessManager.isProcessRunning(entity.getProcessName());
		if(isRunning)
		{
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			Long uptime = entity.getUptime() != null ? ts.getTime() - Long.valueOf(entity.getUptime()) : ts.getTime(); 
			entity.setUptime(String.valueOf(uptime));;
		} else {
			entity.setUptime("0");
		}
		try {
			Database.connect();
			String req = "UPDATE `game_server` SET `name`=?, `process_name`=?, `platform`=?, `dirPath`=?, `dataPath`=?, `worldDir`=?,`launchOption`=?, `uptime`=?, `lastBoot`=?";
			PreparedStatement stmt = Database.getCon().prepareStatement(req); 
			stmt.setString(1, entity.getName());
			stmt.setString(2, entity.getProcessName());
			stmt.setString(3, entity.getPlatform());
			stmt.setString(4, entity.getDirPath());
			stmt.setString(5, entity.getDataPath());
			stmt.setString(6, entity.getWorldDir());
			stmt.setString(7, entity.getLaunchOption());
			stmt.setString(8, entity.getUptime());
			stmt.setString(9, entity.getLastBoot());
			int success = stmt.executeUpdate();
			Database.disconnect();
			if(success <= 0)
			{
				throw new SQLException("Erreur sur la mise a jour des données serveur");
			}
		} catch(SQLException e)
		{
			e.printStackTrace();
		}	
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
		try {
			GameServer gs = null;
			Database.connect();
			String req = "SELECT*FROM `game_server` WHERE `name` = ?";
			PreparedStatement stmt = Database.getCon().prepareStatement(req);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();			
			while(rs.next())
			{
				if(rs.getString("name").equals(name)) {
					
					gs = new GameServer(rs.getInt("id"), rs.getString("name"), rs.getString("process_name"),rs.getString("platform"), rs.getString("dirPath"), 
							rs.getString("dataPath"), rs.getString("worldDir"), rs.getString("launchOption"), rs.getString("uptime"), rs.getString("lastBoot")); 
				}
					

			}
			Database.disconnect();
			return gs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				GameServer serv = new GameServer(rs.getInt("id"), rs.getString("name"), rs.getString("process_name"),rs.getString("platform"), rs.getString("dirPath"), 
						rs.getString("dataPath"), rs.getString("worldDir"), rs.getString("launchOption"), rs.getString("uptime"), rs.getString("lastBoot"));
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
