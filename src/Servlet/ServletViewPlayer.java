package Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BrowseOnePlayer;
import model.BrowsePlayer;
import Database.DB;
import beans.Player;
import beans.Players;

/**
 * Servlet implementation class ServletViewPlayer
 */
@WebServlet("/ServletViewPlayer")
public class ServletViewPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletViewPlayer() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//return one player's info
		
		int Pid = Integer.parseInt(request.getParameter("PlayerId"));
		System.out.println(Pid);
        BrowseOnePlayer bop=new BrowseOnePlayer();
    	ArrayList<Player> list = bop.selectOnePlayerList(Pid);
        request.setAttribute("list", list);
        String forward = "playerinfo.jsp"; 
        RequestDispatcher rd=request.getRequestDispatcher(forward);  
        rd.forward(request,response);  
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	

}
}
