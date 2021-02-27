package com.meiyoservices.api;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.meiyoservices.bll.manager.ServerManager;
import com.meiyoservices.bo.GameServer;
import com.meiyoservices.tool.DesktopServerTools;

@Path("/server")
public class GameServerAPI {
	
	@GET
	public String getDatas()
	{
		return "get ok";
	}
	
	@GET @Path("/{key:\\d+}")
	public String getServerData(@PathParam("key") int id)
	{
		return "ok param ok";
	}
	
	@GET @Path("/{action}/{servname}")
	public String doOnServer(@PathParam("action") String action, @PathParam("servname") String servname)
	{
		GameServer gs = ServerManager.getServerByName(servname);
		switch (action)
		{
			case "boot":
				//DesktopServerTools.startServer(gs);
				//break;
			case "reboot":
				//DesktopServerTools.rebootServer(gs);
				break;
			case "stop":
				//DesktopServerTools.stopServer(gs);
				break;
			case "update":
				ServerManager.updateServer(gs);
				//TODO FORM DATA pour l'update GameServer
				break;
			case "save":
				DesktopServerTools.saveServer(gs.getWorldDir());
				//TODO ZIP FILE COMMAND => DesktopServerTools
				break;
			case "download":
				//DesktopServerTools.getSave(gs.getDataPath());
				break;
		}
		return action + ":" + servname;
	}
	
	@PUT @Path("/{key:\\d+}")
	public String updateServer(@PathParam("key") int id)
	{
		return "update ok";
	}
	
	@POST
	public String createServer()
	{
		return "create ok";
	}
}
