package com.meiyoservices.bll.manager;

import java.util.List;

import com.meiyoservices.bo.GameServer;
import com.meiyoservices.dal.DAOFactory;
import com.meiyoservices.dal.GameServerDAO;

public class ServerManager {
	private static final GameServerDAO ServerDAO= DAOFactory.getGameServerDAO();
	
	public static List<GameServer> getServerList()
	{
		return ServerDAO.selectAll();
	}
	
	public static GameServer getServerByName(String name)
	{
		return ServerDAO.selectByName(name);
	}
	
	public static void updateServer(GameServer gs)
	{
		ServerDAO.update(gs);
	}
	
}
