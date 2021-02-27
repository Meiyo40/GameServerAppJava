package com.meiyoservices.bo;


public class GameServer{
	
	private int id;
	private String name;
	private String processName;
	private String platform;
	private String dirPath;
	private String dataPath;
	private String worldDir;
	private String launchOption;
	private String uptime;
	private String lastBoot;
	
	public GameServer() {}
	public GameServer(String pName, String pProcessName, String pPlatform, String pDirPath, String pDataPath, String pWorldDir, String pLaunchOption, String pUptime, String pLastBoot) {
		this.name = pName;
		this.setProcessName(pProcessName);
		this.setDataPath(pDataPath);
		this.platform = pPlatform;
		this.dirPath = pDirPath;
		this.setWorldDir(pWorldDir);
		this.lastBoot = pLastBoot;
		this.uptime = pUptime;
		this.launchOption = pLaunchOption;
	}
	public GameServer(int pId, String pName, String pProcessName, String pPlatform, String pDirPath, String pWorldDir, String pDataPath, String pLaunchOption, String pUptime, String pLastBoot) {
		this.id = pId;
		this.name = pName;
		this.setProcessName(pProcessName);
		this.platform = pPlatform;
		this.dirPath = pDirPath;
		this.setDataPath(pDataPath);
		this.setWorldDir(pWorldDir);
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
	/**
	 * @return the processName
	 */
	public String getProcessName() {
		return processName;
	}
	/**
	 * @param processName the processName to set
	 */
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	/**
	 * @return the dataPath
	 */
	public String getDataPath() {
		return dataPath;
	}
	/**
	 * @param dataPath the dataPath to set
	 */
	public void setDataPath(String dataPath) {
		this.dataPath = dataPath;
	}
	/**
	 * @return the worldDir
	 */
	public String getWorldDir() {
		return worldDir;
	}
	/**
	 * @param worldDir the worldDir to set
	 */
	public void setWorldDir(String worldDir) {
		this.worldDir = worldDir;
	}
}
