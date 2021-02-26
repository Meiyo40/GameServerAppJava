package com.meiyoservices.dal;

public class DAOFactory {
	public static UserDAO getUserDao()
	{
		return new UserDAO();
	}
	
	public static GameServerDAO getGameServerDAO()
	{
		return new GameServerDAO();
	}
}
