package beans;

import java.util.Date;

public class Player extends Players {
	
	private String GameResult;
	private String GameName;
	private Date GameDate;
	private String Clubname;
	private String ClubLocation;
	private String Category;
	private String Comments;
	private int cuserid;
	private int cid;
	
	
	
	
	public void setCID(int id){
		this.cid=id;
	}
	
	public int getCID(){
		return cid;
	}

	public void setID(int id){
		this.cuserid=id;
	}
	
	public int getID(){
		return cuserid;
	}
	
	public void setPid(String GameResult){
		this.GameResult=GameResult;
	}
	
	public String getGameName(){
		return GameName;
	}
	public void setGameName(String GameName){
		this.GameName=GameName;
	}
	
	public Date getGameDate(){
		return GameDate;
	}
	public void setGameDate(Date GameDate){
		this.GameDate=GameDate;
	}
	
	
	public String getClubname(){
		return Clubname;
	}
	public void setClubname(String Clubname){
		this.Clubname=Clubname;
	}
	
	public String getClubLocation(){
		return ClubLocation;
	}
	public void setClubLocation(String ClubLocation){
		this.ClubLocation=ClubLocation;
	}

	public String getCategory(){
		return Category;
	}
	public void setCategory(String Category){
		this.Category=Category;
	}

	
	public String getComment(){
		return Comments;
	}
	public void setComment(String co){
		this.Comments=co;
	}
	
	public String getGameResult(){
		return GameResult;
	}

	public void setGameResult(String result) {
		this.GameResult=result;
	}

}
