package com.meiyoservices.bll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if((boolean) request.getSession().getAttribute("isLogged"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/index.jsp");
			request.setAttribute("user", request.getSession().getAttribute("User"));
			rd.forward(request, response);
		} else {
			String url = request.getContextPath() + "/login";
			response.sendRedirect(url);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if((boolean) request.getSession().getAttribute("isLogged"))
		{
			doGet(request, response);
		} else {
			String url = request.getContextPath() + "/login";
			response.sendRedirect(url);
		}
	}

}
