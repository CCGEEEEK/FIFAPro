package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.DB;
import beans.Player;
import beans.Players;

public class BrowsePlayer {
	
	public ArrayList<Players> selectPlayerList() {
		
		ArrayList<Players> list = new ArrayList<Players>();
		try{
			
		ResultSet rs=null;  
        DB db=new DB();  
        String sql="SELECT distinct player.playerid, PICURL,playername,dob,height,AVG(ratings) ratings,goalscored,teamname FROM player,rate,playerpic,Team, PlaysFor P where p.TeamID=Team.TeamID and p.PlayerID=Player.PlayerID and Player.PlayerID=playerpic.playerid and Player.PlayerID=rate.playerid group by PICURL,player.playerid, playername,dob,height,goalscored,teamname order by GoalScored desc";
        rs = db.doSelect(sql);
    	
        while (rs.next()) {
        	Players player = new Players();
            player.setPid(rs.getInt("playerid"));
            player.setPname(rs.getString("playername"));
            player.setUrl(rs.getString("PICURL"));
            player.setDob(rs.getDate("dob"));
            player.setHeight(rs.getInt("height"));
            player.setRate(rs.getDouble("ratings"));
            player.setGoalscored(rs.getInt("goalscored"));
            player.setTeam(rs.getString("Teamname"));
            
            list.add(player);
            
        }
        
        db.close();
		}
		 catch (Exception e) {  
             e.printStackTrace();  
         }  
  	return list;
		
	}

}
