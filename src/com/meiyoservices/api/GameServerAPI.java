package com.meiyoservices.api;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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
		switch (action)
		{
			case "boot":
				break;
			case "reboot":
				break;
			case "stop":
				break;
			case "update":
				break;
			case "save":
				break;
			case "download":
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
