package com.meiyoservices.bll;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meiyoservices.bll.manager.ServerManager;
import com.meiyoservices.bo.GameServer;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/file")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servName = request.getParameter("servername");
		GameServer gs = ServerManager.getServerByName(servName);
		//String filename = gs.getDataPath() + "\\save_" + gs.getName() + ".zip";
		String filename = "save_" + gs.getName() + ".zip";      
		
		if(gs instanceof GameServer && gs != null)
		{
			try
			{		      
			    if(filename == null || filename.equals(""))
			    {
			        throw new ServletException("File Name can't be null or empty");
			    }

			    String filepath = gs.getDataPath() + "\\" +filename;   //change your directory path

			    File file = new File(filepath);
			    if(!file.exists())
			    {
			        throw new ServletException("File doesn't exists on server.");
			    }

			    response.setContentType("APPLICATION/OCTET-STREAM");
			    response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\""); 

			    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(filepath);

			    int i; 
			    while ((i=fileInputStream.read()) != -1) 
			    {
			         response.getWriter().write(i); 
			    } 
			    fileInputStream.close();
			}
			catch(Exception e)
			{
			    System.err.println("Error while downloading file["+filename+"]"+e);
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/index");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
