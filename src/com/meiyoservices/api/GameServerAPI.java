package com.meiyoservices.api;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

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
	public String doOnServer(@PathParam("action") String action, @PathParam("servname") String servname, @Context ServletContext servletContext)
	{
		GameServer gs = ServerManager.getServerByName(servname);
		final String BACK_MESSAGE = "<meta http-equiv='refresh' content='3;" + servletContext.getContextPath() + "/index?servername=" + servname + "'><h1>" + action + ":" + servname + " Success (Back to index in 3s)" + "<//h1>";
		switch (action)
		{
			case "boot":
				DesktopServerTools.startServer(gs);
				break;
			case "reboot":
				DesktopServerTools.rebootServer(gs);
				break;
			case "stop":
				DesktopServerTools.stopServer(gs);
				break;
			case "update":
				DesktopServerTools.updateServer(gs);
				break;
			case "save":
				DesktopServerTools.saveServer(gs);
				break;
		}
		return BACK_MESSAGE;
	}
	
	@PUT @Path("/{key:\\d+}")
	public String updateServer(@PathParam("key") int id)
	{
		return "update ok";
	}
	
	@POST 
	@Path("/server/update/{servername}")
	public String updateServData(@PathParam("servername") String serverName, @Context ServletContext servletContext)
	{
		GameServer gs = ServerManager.getServerByName(serverName);
		if(gs != null)
		{
		}
		return null;
	}
	
	@POST
	public String createServer()
	{
		return "create ok";
	}
}
