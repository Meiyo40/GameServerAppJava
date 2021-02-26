package com.meiyoservices.database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class ConnectionProvider {
	
	private static DataSource dataSource;
	
	static {
		Context ctx;
		try {
			ctx = new InitialContext();
			ConnectionProvider.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible d'accéder à la base de données");
		}
	}
	
	public static Connection getConnection() throws SQLException
	{
		return ConnectionProvider.dataSource.getConnection();
	}

	/**
	 * @return the dataSource
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource the dataSource to set
	 */
	public static void setDataSource(DataSource dataSource) {
		ConnectionProvider.dataSource = dataSource;
	}
}
