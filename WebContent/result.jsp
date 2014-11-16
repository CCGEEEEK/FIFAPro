<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@page import="Database.DB"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="beans.Players"%>
<%@page import="java.util.ArrayList"%>

<html xmlns="">
<head>
<title>FIFA Favorite Player</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-titillium-250.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>

</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="menu_nav">
        <ul>
          <li class="active"><a href="home.html"><span>Home Page</span></a></li>
          <li><a href="playerlist.jsp"><span>Player</span></a></li>
          <li><a href="teamlist.jsp"><span>Team</span></a></li>
          <li><a href="gamelist.jsp"><span>Game</span></a></li>
        </ul>
      </div>
      <div class="logo">
        <h1><a href="index.html">2014<span>FIFA</span> <small>BY BINGJIE SUN & WEIXIN WU</small></a></h1>
      </div>
   
      <div class="slider">

     
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="content">

<%
    String str = request.getParameter("search");

    DB db = new DB();
    ResultSet rs = null;
    String sql = "select distinct playerid, playername from player, team where playername like '"+ str +"%' or teamname like '"+ str +"%'";
 
    rs = db.doSelect(sql);
    
    //db.close();
    ArrayList<Players> list = new ArrayList<Players>();
    
    
    while (rs.next()) {

      Players player = new Players();

      player.setPid(rs.getInt("playerid"));
      player.setPname(rs.getString("playername"));
      
      list.add(player);

    }
    for (int i = 0; i < list.size(); i++) {

      Players player = list.get(i);
  %>

  <div id="result"><a href="ServletViewPlayer?PlayerId=<%=player.getPid()%>"><%=player.getPname()%></a>
  <br></div>

  <%
    }
  %>
  <form action="playerlist.jsp" method="post" name="form2">
  <input type="submit" value="return">
</form>
    </div> 
    
 <div class="fbg">
    <div class="fbg_resize">
      
      <div class="col c1">
        <h2><span>FIFA</span> Database Project Part 4</h2>
          <h3>  <p>Team Member: Bingjie Sun Weixin Wu.</p></h3>
          <h3>  <p>Uni: bs2888, ww2383</p></h3>
          <h3><p></p><span>E-mail:</span> <a href="#">ww2383@columbia.edu</a></p></h3>
          <h3><p></p><span>E-mail:</span> <a href="#">bs2888@columbia.edu</a></p></h3>
      </div>
      <div class="col c2">
        <h2><span>Main</span> Idea </h2>
     <h3> <p>Choose your favorite players here.</p></h3>
    <p>The project we choose to work on is about 2014 FIFA World Cup. </p>
     <p>Its major function is to provide users a platform to rate and comment the players and teams by the given information about the football stars and teams.</p>
      <p> The project will contain comprehensive real world data about the players and teams, which can be considered as references for users to comment and rate.</p>
    
    
    </div>
      <div class="clr"></div>
    </div>
  </div>
 
</body>
</html>