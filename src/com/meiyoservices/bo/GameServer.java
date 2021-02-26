package com.meiyoservices.bo;


public class GameServer{
	
	private int id;
	private String name;
	private String platform;
	private String dirPath;
	private String launchOption;
	private String uptime;
	private String lastBoot;
	
	public GameServer() {}
	public GameServer(String pName, String pPlatform, String pDirPath, String pLaunchOption, String pUptime, String pLastBoot) {
		this.name = pName;
		this.platform = pPlatform;
		this.dirPath = pDirPath;
		this.lastBoot = pLastBoot;
		this.uptime = pUptime;
		this.launchOption = pLaunchOption;
	}
	public GameServer(int pId, String pName, String pPlatform, String pDirPath, String pLaunchOption, String pUptime, String pLastBoot) {
		this.id = pId;
		this.name = pName;
		this.platform = pPlatform;
		this.dirPath = pDirPath;
		this.lastBoot = pLastBoot;
		this.uptime = pUptime;
		this.launchOption = pLaunchOption;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getDirPath() {
		return dirPath;
	}

	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}

	public String getLaunchOption() {
		return launchOption;
	}

	public void setLaunchOption(String launchOption) {
		this.launchOption = launchOption;
	}

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	public String getLastBoot() {
		return lastBoot;
	}

	public void setLastBoot(String lastBoot) {
		this.lastBoot = lastBoot;
	}
}
