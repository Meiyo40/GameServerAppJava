package com.meiyoservices.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
	
	private static Properties properties;
	private static Connection con;
	private static String dcn;
	
	static {
		Database.properties = new Properties();
		try {
			Database.properties.load(Database.class.getResourceAsStream("settings.properties"));
			dcn = Database.getProperty("url") + "?user=" + Database.getProperty("user")  + "&password=" + Database.getProperty("password");
			init();
			con = null;
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		return con;
	}
	
	public static void disconnect() throws SQLException
	{
		con.close();
		con = null;
	}
	
	private static void init()
	{
		try {
			Class.forName(Database.getProperty("driverjdc"));
        } catch (Exception ex) {
            // handle the error
        }
	}
	
	public static void connect()
	{
		try {
			con = null;
		    con = DriverManager.getConnection(dcn);
		} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	/**
	 * @return the properties
	 */
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}
