<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>6-stone Kalah by Muttalip Kucuk</title>
<style>
div {
	margin: 0;
	padding: 0;
	text-align: center;
}

div #setup {
	width: 600px;
	height: 150px;
}

.house {
	width: 145px;
	height: 300px;
	display: inline-block;
	border: 2px solid black;
	margin: 0;
	padding: 0;
}

#house_left {
	float: left;
}

#house_right {
	float: right;
}

.pits {
	width: 900px;
	height: 300px;
	display: inline-block;
	border: 0;
	margin: 0;
	padding: 0;
}

form {
	width: 1200px;
	margin: 0;
	padding: 0;
}

table {
	margin: 0;
	padding: 0;
}

td {
	width: 150px;
	height: 150px;
}

p {
	font-family: courier;
	font-size: 20px;
}

.pit1 {
	border: 1px solid blue;
}

.pit2 {
	border: 1px solid red;
}

h3.player1{
	color:blue;
}

span.player2{
	color:red;
}

span.vs{
	color:black;
}

h2.player1{
	color:blue;
}

h2.player2{
	color:red;
}

</style>
</head>
<body>
	<%@ page import="com.mkucuk.model.Game"%>
	<%
		Game game = (Game) request.getSession().getAttribute("game");
	%>

	<center>

		<h1>6-stone Kalah</h1>
		
		
	
		
		
		
		<%
			
			if(!game.isGameover()){
				String line = "";
				
				if(game.getPlayerTurn() == game.PLAYER1_ID){
					
					line = "Player1's (blue) turn";
					line = "<h2 class=\"player1\">" + line + "</h2>";
				}else{
					line = "Player2's (red) turn";
					line = "<h2 class=\"player2\">" + line + "</h2>";
					
				}
				
				out.println(line);
			}else{
				
				if(game.getScore()[0]>game.getScore()[1]){
					out.println("<h2 class=\"player1\">Player1 wins!</h2>");
				}else if(game.getScore()[0]<game.getScore()[1]){
					out.println("<h2 class=\"player2\">Player2 wins!</h2>");
				}else{
					out.println("<h2>Draw!</h2>");
				}
				
			}
			
			
			
			
			
			
			
		%>
		
		
		
		
		
		<h3>Step 1: Please select one of the possible pits</h3>



		<form action="./GameServlet" method="POST">
			<div id="setup">

				<div class="house pit2" id="house_left">

					<%
						out.println(game.getHouse(game.PLAYER2_ID).getStones());
					%>
				</div>

				<div class="pits">


					<table>
						<tr>
							<!-- <p>•••</p> <br>-->


							<td class="pit2">
								<%
									out.println(game.getPits()[11].getStones());
								%> <%
 	if (game.getPlayerTurn() == game.PLAYER2_ID && game.getPits()[11].getStones() != 0) {
 %> <br> <input type="radio" name="pit" value="11"> <%
 	}
 %>
							</td>

							<td class="pit2">
								<%
									out.println(game.getPits()[10].getStones());
								%> <%
 	if (game.getPlayerTurn() == game.PLAYER2_ID && game.getPits()[10].getStones() != 0) {
 %> <br> <input type="radio" name="pit" value="10"> <%
 	}
 %>
							</td>

							<td class="pit2">
								<%
									out.println(game.getPits()[9].getStones());
								%> <%
 	if (game.getPlayerTurn() == game.PLAYER2_ID && game.getPits()[9].getStones() != 0) {
 %> <br> <input type="radio" name="pit" value="9"> <%
 	}
 %>
							</td>

							<td class="pit2">
								<%
									out.println(game.getPits()[8].getStones());
								%> <%
 	if (game.getPlayerTurn() == game.PLAYER2_ID && game.getPits()[8].getStones() != 0) {
 %> <br> <input type="radio" name="pit" value="8"> <%
 	}
 %>
							</td>

							<td class="pit2">
								<%
									out.println(game.getPits()[7].getStones());
								%> <%
 	if (game.getPlayerTurn() == game.PLAYER2_ID && game.getPits()[7].getStones() != 0) {
 %> <br> <input type="radio" name="pit" value="7"> <%
 	}
 %>
							</td>

							<td class="pit2">
								<%
									out.println(game.getPits()[6].getStones());
								%> <%
 	if (game.getPlayerTurn() == game.PLAYER2_ID && game.getPits()[6].getStones() != 0) {
 %> <br> <input type="radio" name="pit" value="6"> <%
 	}
 %>
							</td>

						</tr>
						<tr>
							<td class="pit1">
								<%
									out.println(game.getPits()[0].getStones());
								%> <%
 	if (game.getPlayerTurn() == game.PLAYER1_ID && game.getPits()[0].getStones() != 0) {
 %> <br> <input type="radio" name="pit" value="0"> <%
 	}
 %>
							</td>

							<td class="pit1">
								<%
									out.println(game.getPits()[1].getStones());
								%> <%
 	if (game.getPlayerTurn() == game.PLAYER1_ID && game.getPits()[1].getStones() != 0) {
 %> <br> <input type="radio" name="pit" value="1"> <%
 	}
 %>
							</td>

							<td class="pit1">
								<%
									out.println(game.getPits()[2].getStones());
								%> <%
 	if (game.getPlayerTurn() == game.PLAYER1_ID && game.getPits()[2].getStones() != 0) {
 %> <br> <input type="radio" name="pit" value="2"> <%
 	}
 %>
							</td>

							<td class="pit1">
								<%
									out.println(game.getPits()[3].getStones());
								%> <%
 	if (game.getPlayerTurn() == game.PLAYER1_ID && game.getPits()[3].getStones() != 0) {
 %> <br> <input type="radio" name="pit" value="3"> <%
 	}
 %>
							</td>

							<td class="pit1">
								<%
									out.println(game.getPits()[4].getStones());
								%> <%
 	if (game.getPlayerTurn() == game.PLAYER1_ID && game.getPits()[4].getStones() != 0) {
 %> <br> <input type="radio" name="pit" value="4"> <%
 	}
 %>
							</td>

							<td class="pit1">
								<%
									out.println(game.getPits()[5].getStones());
								%> <%
 	if (game.getPlayerTurn() == game.PLAYER1_ID && game.getPits()[5].getStones() != 0) {
 %> <br> <input type="radio" name="pit" value="5"> <%
 	}
 %>
							</td>

						</tr>



					</table>






				</div>


				<div class="house pit1" id="house_right">
					<%
						out.println(game.getHouse(game.PLAYER1_ID).getStones());
					%>
				</div>



			</div>
			<br>
			<h3>Step 2: Please click on the button to play your move</h3>
			
			<input type="submit" value="Play move">
			
			</form>
	
	
	<br>
	<br>
	
	
			<%
				String player1 = "", player2 = "", line = "";
				int[] score = game.getScore();
				player1 += "Player1 (blue) " + score[0];
				
				player2 += score[1] + " (red) Player2";
				
				line = "<h3 class=\"player1\">" + player1 + "<span class=\"vs\"> - " + "</span><span class=\"player2\">" + player2 + "</span></h3>";
				out.println(line);
			%>

</center>



	


</body>
</html>