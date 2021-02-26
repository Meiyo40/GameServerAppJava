package com.meiyoservices.bo;

import com.meiyoservices.tool.BCrypt;

public class User {
	private int userId;
	public String username;
	private String role;
	private String password;
	private String pwdSalt;
	private String lastIp;
	private String lastConnection;
	
	public User()
	{
		
	}
	
	public User(String pUsername, String pRole, String pPwd, String pLastIp, String pLastConnect)
	{
		this.username = pUsername;
		this.role = pRole;
		this.setPassword(pPwd);
		this.lastIp = pLastIp;
		this.lastConnection = pLastConnect;
	}
	
	public User(int pUId, String pUsername, String pRole, String pPwd, String pPwdSalt, String pLastIp, String pLastConnect)
	{
		this.userId = pUId;
		this.username = pUsername;
		this.role = pRole;
		this.password = pPwd;
		this.pwdSalt = pPwdSalt;
		this.lastIp = pLastIp;
		this.lastConnection = pLastConnect;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", username=");
		builder.append(username);
		builder.append(", role=");
		builder.append(role);
		builder.append(", password=");
		builder.append(password);
		builder.append(", pwdSalt=");
		builder.append(pwdSalt);
		builder.append(", lastIp=");
		builder.append(lastIp);
		builder.append(", lastConnection=");
		builder.append(lastConnection);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = this.hashPassword(password);
	}
	
	private String hashPassword(String pwd)
	{
		this.pwdSalt = BCrypt.gensalt();
		return BCrypt.hashpw(pwd, this.getPwdSalt());
	}
	
	public static void createUser()
	{
		
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the pwdSalt
	 */
	public String getPwdSalt() {
		return pwdSalt;
	}

	/**
	 * @param pwdSalt the pwdSalt to set
	 */
	public void setPwdSalt(String pwdSalt) {
		this.pwdSalt = pwdSalt;
	}

	/**
	 * @return the lastConnection
	 */
	public String getLastConnection() {
		return lastConnection;
	}

	/**
	 * @param lastConnection the lastConnection to set
	 */
	public void setLastConnection(String lastConnection) {
		this.lastConnection = lastConnection;
	}

	/**
	 * @return the lastIp
	 */
	public String getLastIp() {
		return lastIp;
	}

	/**
	 * @param lastIp the lastIp to set
	 */
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
}
