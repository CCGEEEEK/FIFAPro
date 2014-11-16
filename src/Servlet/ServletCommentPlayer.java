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
import javax.servlet.http.HttpSession;

import model.BrowseOnePlayer;
import beans.Player;
import Database.DB;


@WebServlet("/ServletCommentPlayer")
public class ServletCommentPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletCommentPlayer() {
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
		String str=request.getParameter("comment"); 
		HttpSession session = request.getSession(); 
	    System.out.println(session.getAttribute("uid"));
	        
	    String uid=session.getAttribute("uid").toString();
	    
		ResultSet rsk=null;
	
        DB db=new DB();  
        String sql="select max(commentid) commentid from comments";
        
        rsk = db.doSelect(sql);
        
    		
        int comid = 200013;
			try {
				while (rsk.next()) {
				   
				comid = 1 + rsk.getInt(1);
				}
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
	
		
		if(str!=null){
			int userid;
			try {
				
				String selectuid="select userid from users where account='"+uid+"'";
				System.out.println(selectuid);
				ResultSet rsuid=null;
				rsuid=db.doSelect(selectuid);
				rsuid.next();
				
				
				
			
				
				userid = rsuid.getInt(1);
				session.setAttribute("id", userid); 
				System.out.println(userid);
				String sql2="Insert into comments values('"+comid+"','"+str+"','"+userid+"','"+Pid+"')";   
				db.doInsert(sql2);
				System.out.println("hhahhahah~~~??!");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
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
