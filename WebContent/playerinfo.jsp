<%@ page import="beans.Player"%>
<%@ page import="beans.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.BrowseOnePlayer"%>
<%@ page import="beans.Player"%>
<%@ page import="Database.DB"%>
<%@ page import="java.sql.ResultSet"%>



<% ArrayList<Player> list = (ArrayList<Player>)(request.getAttribute("list")); %>

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
						<li class="active"><a href="home.html"><span>Home
									Page</span></a></li>
						<li><a href="playerlist.jsp"><span>Player</span></a></li>
						<li><a href="teamlist.jsp"><span>Team</span></a></li>
						<li><a href="gamelist.jsp"><span>Game</span></a></li>
					</ul>
				</div>
				<div class="logo">
					<h1>
						<a href="index.html">2014<span>FIFA</span> <small>BY
								BINGJIE SUN & WEIXIN WU</small></a>
					</h1>
				</div>

				<div class="slider"></div>
				<div class="clr"></div>
			</div>
		</div>
		<div class="content">

			<div id="main">



				<table border="1" align="center" style="border-collapse: collapse;">
					<tr align="center">
					<tr>
						<td>Player Name</td>
						<td colspan="3"><%=list.get(0).getPname() %></td>
					</tr>
					<tr>
						<td>Player ID</td>
						<td colspan="3" id="td1"><%=list.get(0).getPid() %></td>
					</tr>
					<tr>
						<td>Player Image</td>
						<td colspan="3"><img src="<%=list.get(0).getUrl() %>"></td>
					</tr>
					<tr>
						<td>Team Name</td>
						<td colspan="3"><%=list.get(0).getTeam() %></td>
					</tr>
					<tr>
						<td>Goal Scored</td>
						<td colspan="3"><%=list.get(0).getGoalscored() %></td>
					</tr>
					<tr>
						<td>Rating</td>
						<td colspan="3"><%=list.get(0).getRate() %></td>
					</tr>
					<tr>
						<td>Birthday</td>
						<td colspan="3"><%=list.get(0).getDob() %></td>
					</tr>
					<tr>
						<td>Height</td>
						<td colspan="3"><%=list.get(0).getHeight() %></td>
					</tr>
					<tr>
						<td>Position</td>
						<td colspan="3"><%=list.get(0).getCategory() %></td>
					</tr>
					<tr>
						<td>Club</td>
						<td colspan="3"><%=list.get(0).getClubname()%></td>
					</tr>
					<tr>
						<td>Club Location</td>
						<td colspan="3"><%=list.get(0).getClubLocation() %></td>
					</tr>
						<%for(int i = 0 ; i<list.size();i++) {
	                Player player = list.get(i);%>
						<tr align="center">
						<td>Comments</td>
						<td><%=player.getComment() %></td>
						<td><%=player.getID() %></td>
						<td><a
							href="ServletUserDelete?id=<%=player.getID() %>&cid=<%=player.getCID() %> ">Delete</a></td>

					</tr>
					<% 
            }
            %>
					</tr>

					<input type="button" value="Back"
						onclick="javascript:history.go(-1)">

				</table>


				<script language="JavaScript">  
    function submitForm(){ 
      alert("yee");
      document.forms['form3'].action= "ServletCommentPlayer?PlayerId="+document.getElementById("td1").innerHTML;     
      document.forms['form3'].submit();  
      alert("yeehahah");
    }  
    </script>

				<script language="JavaScript">  
    function submitRate(){  
      document.forms['form4'].action= "ServletRatePlayer?PlayerId="+document.getElementById("td1").innerHTML;     
      document.forms['form4'].submit();  
    }  
    </script>

				<form name="form3" method="post" align="center">
					Comment: <input type="text" name="comment"> <input
						type="button" value="submit" onclick="submitForm()">
				</form>
				<form name="form4" method="post" align="center">
					Rate: <input type="text" name="rate"> <input type="button"
						value="submit" onclick="submitRate()">
				</form>


			</div>
		</div>

		<div class="fbg">
			<div class="fbg_resize">

				<div class="col c1">
					<h2>
						<span>FIFA</span> Database Project Part 4
					</h2>
					<h3>
						<p>Team Member: Bingjie Sun Weixin Wu.</p>
					</h3>
					<h3>
						<p>Uni: bs2888, ww2383</p>
					</h3>
					<h3>
						<p></p>
						<span>E-mail:</span> <a href="#">ww2383@columbia.edu</a>
						</p>
					</h3>
					<h3>
						<p></p>
						<span>E-mail:</span> <a href="#">bs2888@columbia.edu</a>
						</p>
					</h3>
				</div>
				<div class="col c2">
					<h2>
						<span>Main</span> Idea
					</h2>
					<h3>
						<p>Choose your favorite players here.</p>
					</h3>
					<p>The project we choose to work on is about 2014 FIFA World
						Cup.</p>
					<p>Its major function is to provide users a platform to rate
						and comment the players and teams by the given information about
						the football stars and teams.</p>
					<p>The project will contain comprehensive real world data about
						the players and teams, which can be considered as references for
						users to comment and rate.</p>


				</div>
				<div class="clr"></div>
			</div>
		</div>
</body>
</html>