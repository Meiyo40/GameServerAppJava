package com.meiyoservices.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.meiyoservices.bo.User;
import com.meiyoservices.database.Database;

public class UserDAO implements EntityDAOJdbcImpl<User> {

	@Override
	public void insert(User entity) {
		if(!this.userExist(entity))
		{
			try {
				Database.connect();
				String req = "INSERT INTO `user` (`username`, `password`, `role`, `last_ip`, `last_connexion`, `salt`) VALUES (?,?,?,?,?,?)";
				PreparedStatement stmt = Database.getCon().prepareStatement(req);
				stmt.setString(1, entity.getUsername());
				stmt.setString(2, entity.getPassword());
				stmt.setString(3, entity.getRole());
				stmt.setString(4, entity.getLastIp());
				stmt.setString(5, entity.getLastConnection());
				stmt.setString(6, entity.getPwdSalt());
				int success = stmt.executeUpdate();
				Database.disconnect();
				if(success <= 0)
				{
					throw new SQLException("Erreur lors de la creation de l'utilisateur");
				}
			} catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void update(User entity) {
		if(this.userExist(entity))
		{
			try {
				Database.connect();
				String req = "UPDATE `user` SET `username` = ?, `password` = ?, `salt` = ?, `role` = ?, `last_ip` = ?, `last_connexion` = ?";
				PreparedStatement stmt = Database.getCon().prepareStatement(req); 
				stmt.setString(1, entity.getUsername());
				stmt.setString(2, entity.getPassword());
				stmt.setString(3, entity.getPwdSalt());
				stmt.setString(4, entity.getRole());
				stmt.setString(5, entity.getLastIp());
				stmt.setString(6, entity.getLastConnection());
				int success = stmt.executeUpdate();
				Database.disconnect();
				if(success <= 0)
				{
					throw new SQLException("Erreur sur la mise a jour de l'utilisateur");
				}
			} catch(SQLException e)
			{
				e.printStackTrace();
			}
		}	
	}

	@Override
	public void delete(User entity) {
		if(this.userExist(entity))
		{
			try {
				Database.connect();
				String req = "DELETE FROM `user` WHERE `username` = ?";
				PreparedStatement stmt = Database.getCon().prepareStatement(req); 
				stmt.setString(1, entity.getUsername());
				int success = stmt.executeUpdate();
				Database.disconnect();
				if(success <= 0)
				{
					throw new SQLException("Erreur sur la mise a jour de l'utilisateur");
				}
			} catch(SQLException e)
			{
				e.printStackTrace();
			}
		}	
	}

	@Override
	public User selectById(int id) {
		try {
			Database.connect();
			String req = "SELECT*FROM `user` WHERE `id` = ?";
			PreparedStatement stmt = Database.getCon().prepareStatement(req);
			stmt.setString(1, String.valueOf(id));
			ResultSet rs = stmt.executeQuery();			
			while(rs.next())
			{
				if(rs.getInt("id") == id)
				{
					return new User(rs.getInt("id"), rs.getString("username"), rs.getString("role"), rs.getString("password"), 
							rs.getString("salt"), rs.getString("last_ip"), rs.getString("last_connexion"));
				}
			}
			Database.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<User> selectAll() {
		try {
			List<User> userList = new ArrayList<User>();
			Database.connect();
			String req = "SELECT*FROM `user`";
			PreparedStatement stmt = Database.getCon().prepareStatement(req);
			ResultSet rs = stmt.executeQuery();			
			while(rs.next())
			{
				User nUser = new User(rs.getInt("id"), rs.getString("username"), rs.getString("role"), rs.getString("password"), 
						rs.getString("salt"), rs.getString("last_ip"), rs.getString("last_connexion")); 
				userList.add(nUser);
			}
			Database.disconnect();
			return userList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean userExist(User entity)
	{
		try {
			Database.connect();
			String req = "SELECT*FROM `user` WHERE `username` = ?";
			PreparedStatement stmt = Database.getCon().prepareStatement(req);
			stmt.setString(1, entity.getUsername());
			ResultSet rs = stmt.executeQuery();			
			while(rs.next())
			{
				if(rs.getString("username").equals(entity.getUsername()))
				{
					Database.disconnect();
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public User selectByName(String name) {
		try {
			Database.connect();
			String req = "SELECT*FROM `user` WHERE `username` = ?";
			PreparedStatement stmt = Database.getCon().prepareStatement(req);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();			
			while(rs.next())
			{
				if(rs.getString("username").equals(name))
				{
					return new User(rs.getInt("id"), rs.getString("username"), rs.getString("role"), rs.getString("password"), 
							rs.getString("salt"), rs.getString("last_ip"), rs.getString("last_connexion"));
				}
			}
			Database.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
