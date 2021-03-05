package com.meiyoservices.tool;

import java.sql.Timestamp;
import com.meiyoservices.bll.manager.ServerManager;
import com.meiyoservices.bo.GameServer;

public class DesktopServerTools {
	
	
	public static void rebootServer(GameServer gs)
	{
		try {
			DesktopServerTools.stopServer(gs);
			Thread.sleep(5000);
			DesktopServerTools.startServer(gs);
		} catch (InterruptedException e) {
			System.out.println("Reboot error");
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
		if(!isRunning)
			WindowsProcessManager.execCmd(serverPath + "\\start.bat");
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		gs.setLastBoot(String.valueOf(ts.getTime()));
		gs.setUptime("0");
		ServerManager.updateServer(gs);
	}
	
	public static void updateServer(GameServer gs)
	{
		DesktopServerTools.saveServer(gs);
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
			System.out.println("Update error");
		}
		
	}
	
	public static void saveServer(GameServer gs)
	{
		/*
		 * BAT
		 * cd C:\SERVER\_Tools\7Zip
		 * start 7z a DirPathSaved.zip DirPathToSave
		 * */
		String worldDir = gs.getWorldDir();
		String processToScreen = gs.getDirPath() + "\\" + gs.getProcessName();
		WindowsProcessManager.execCmd(worldDir + "\\save.bat");
		/*
		 * try {
			//Sample process name == "C:\\SERVER\\_Tools\\7Zip\\7z.exe"
			ScreenshotSystem.doScreenShot(processToScreen, worldDir + "\\screen.jpg");
		} catch (AWTException | IOException e) {
			System.out.println("Screenshot error");
		}
		 * */
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
