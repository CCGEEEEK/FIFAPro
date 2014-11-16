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
import beans.Player;
import Database.DB;


@WebServlet("/ServletCommentPlayer")
public class ServletRatePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletRatePlayer() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int Pid = Integer.parseInt(request.getParameter("PlayerId"));      
		String str=request.getParameter("rate"); 
		
		ResultSet rsk=null;
		
        DB db=new DB();  
        String sql="select max(ratingid) ratingid from rate";
        rsk = db.doSelect(sql);
        System.out.println(rsk);
    
			int rtid = 100006;
			try {
				while (rsk.next()) {
				   
				rtid = 1 + rsk.getInt(1);
				}
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		
		
		if(str!=null){
			String sql2="Insert into Rate values('"+rtid+"','"+str+"',60001,'"+Pid+"')";   
			db.doInsert(sql2);
			
			try {
				db.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			BrowseOnePlayer bop=new BrowseOnePlayer();
	    	ArrayList<Player> list = bop.selectOnePlayerList(Pid);
	    	
    	 request.setAttribute("list", list);
    	 String forward = "playerinfo.jsp"; 
         RequestDispatcher rd=request.getRequestDispatcher(forward);  
         rd.forward(request,response);  
			
		}
	}

}
