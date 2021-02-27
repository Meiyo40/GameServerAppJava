package com.meiyoservices.tool;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;

import com.meiyoservices.bll.manager.ServerManager;
import com.meiyoservices.bo.GameServer;
import com.meiyoservices.database.Database;

public class DesktopServerTools {
	private static Properties properties;
	
	static {
		DesktopServerTools.properties = new Properties();
		try {
			DesktopServerTools.properties.load(Database.class.getResourceAsStream("server.properties"));
			//steamRepository = DesktopServerTools.properties.getProperty("steamRepository");
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void rebootServer(GameServer gs)
	{
		try {
			DesktopServerTools.stopServer(gs);
			Thread.sleep(5000);
			DesktopServerTools.startServer(gs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void stopServer(GameServer gs)
	{
		String serverName = gs.getProcessName();
		boolean isRunning = WindowsProcessManager.isProcessRunning(serverName);
		if(isRunning)
		{
			WindowsProcessManager.killProcess(serverName);
		}
	}
	
	public static void startServer(GameServer gs)
	{
		String serverPath = gs.getDirPath();
		String serverName = gs.getProcessName();
		
		boolean isRunning = WindowsProcessManager.isProcessRunning(serverName);
		isRunning = WindowsProcessManager.isProcessRunning(serverName);
		if(!isRunning)
			WindowsProcessManager.execCmd(serverPath + "\\" + serverName);
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		gs.setLastBoot(String.valueOf(ts.getTime()));
		gs.setUptime("0");
		ServerManager.updateServer(gs);
	}
	
	public static void updateServer(GameServer gs)
	{
		DesktopServerTools.saveServer(gs.getWorldDir());
		boolean isRunning = WindowsProcessManager.isProcessRunning(gs.getProcessName());
		if(isRunning)
			DesktopServerTools.stopServer(gs);
		try {
			Thread.sleep(5000);
			isRunning = WindowsProcessManager.isProcessRunning(gs.getProcessName());
			if(!isRunning)
			{
				WindowsProcessManager.execCmd(gs.getDirPath() + "\\" + "update.bat");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void saveServer(String worldDir)
	{
		/*
		 * BAT
		 * cd C:\SERVER\_Tools\7Zip
		 * start 7z a DirPathSaved.zip DirPathToSave
		 * */
		WindowsProcessManager.execCmd(worldDir + "\\save.bat");
	}
	
	
	public static void execute(String cmd)
	{
		
	}
	
	public static void takeScreenShot()
	{
		
	}

	public static void getSave(String dataPath) {
		
	}
}
