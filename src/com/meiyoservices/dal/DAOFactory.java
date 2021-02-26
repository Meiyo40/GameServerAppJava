package com.meiyoservices.dal;

public class DAOFactory {
	public static UserDAO getUserDao()
	{
		return new UserDAO();
	}
}
