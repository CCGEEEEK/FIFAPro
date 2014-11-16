package model;

import java.sql.ResultSet;
import java.util.ArrayList;

import Database.DB;
import beans.Game;
import beans.Teams;

public class BrowseGame {
	
	
public ArrayList<Game> selectGameList() {
		
		ArrayList<Game> gamelist = new ArrayList<Game>();
		
		try{
			
		ResultSet rs=null;  
        DB db=new DB();  
        String sql="SELECT * FROM Game";
        rs = db.doSelect(sql);
        System.out.println(rs);
        while (rs.next()) {

        	Game Game = new Game();

        	Game.setGamename(rs.getString("gamename"));
        	Game.setGamedate(rs.getDate("gamedate"));
        	Game.setGameresult(rs.getString("gameresult"));    
        	gamelist.add(Game);
            
        } db.close();
		} 
		 catch (Exception e) {  
             e.printStackTrace();  
         }  
     
	
		
		return gamelist;
		
	}

}
