package beans;

import java.sql.Date;

public class Game {
	
	private Date gamedate;
	private String gameresult;
	private String gamename;
	
	
	public Date getGamedate(){
		return gamedate;
	}
	public void setGamedate(Date gamedate){
		this.gamedate=gamedate;
	}
	
	public String getGameresult(){
		return gameresult;
	}
	public void setGameresult(String gameresult){
		this.gameresult=gameresult;
	}
	
	public String getGamename(){
		return gamename;
	}
	public void setGamename(String gamename){
		this.gamename=gamename;
	}

}
