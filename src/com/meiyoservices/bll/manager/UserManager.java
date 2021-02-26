package com.meiyoservices.bll.manager;

import javax.servlet.http.HttpServletRequest;

import com.meiyoservices.bo.User;
import com.meiyoservices.dal.DAOFactory;
import com.meiyoservices.dal.UserDAO;
import com.meiyoservices.tool.GenericToolbox;

public class UserManager {
	private static final String ADMINKEY = "LLsd$8!E!Ef8NsYp8x$b";
	private static UserDAO userDAO = DAOFactory.getUserDao();
	
	public static boolean CreateUser(HttpServletRequest request)
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String passChk = request.getParameter("passwordCheck");
		String userRole = request.getParameter("role");
		String key = request.getParameter("key");
		String ip = request.getRemoteAddr();
		String lastCon = GenericToolbox.getDate();
		
		if(key.equals(UserManager.ADMINKEY) && (password.equals(passChk)))
		{
			User user = new User(username, userRole, password, ip, lastCon);
			userDAO.insert(user);
			return true;
		} else {
			return false;
		}
	}
	
	public static void connectUser()
	{
		
	}
}
