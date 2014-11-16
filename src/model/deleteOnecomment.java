package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DB;

public class deleteOnecomment {
	
	public void deletecomment(int id,int cid){
    DB db=new DB();  
    String sql="delete from comments where userid="+id+"and commentid="+cid;
    try{
    		db.doDelete(sql);}
    catch (Exception e) {  
        e.printStackTrace();  
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
	}
    

}
