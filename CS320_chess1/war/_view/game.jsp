<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<style>
		
		.centerboard{
		  margin: auto;
		  width: 496px;
		  padding: 0px;
		}
		
		.div1 {
		  float: left;
		  width: 60px;
		  height: 60px;
		  border: 1px solid black;
		  background:#FFEBCD;
		  padding: 0px;
		  }
		  
		.capturebox {
		  height: 60px;
		  padding: 10px;
		  border: 2px solid black;
		  background-color:BlanchedAlmond
		}
		
		.div2 {
		  float: left;
		  width: 60px;
		  height: 60px;
		  border: 1px solid black;
		  background: green;
		  padding: 0px;
		}
		
		.right {
		  text-align: right;
		}
		
		</style>
		<script>
		
		function drag(ev) {
		  ev.dataTransfer.setData("text", ev.target.id);
		  var start = event.target.parentNode.getAttribute("id");
		  document.getElementById("startLoc").value = start;
		  document.getElementById("submitForm").submit();
		 
		}
		
		function allowDrop(event) {
		  event.preventDefault();
		}
		
		function drop(ev) {
		  event.preventDefault();
		  var end = document.getElementById(event.target.id).id;
		  document.getElementById("endLoc").value = end;
		  document.getElementById("submitForm").submit();
		}
		</script>
	</head>
	
	<body style= "background-color:slategrey">
		<div class="centerboard">
			<p> USER 1 </p>
			<form id="submitForm"/chess/game" name="chess" method="post">
				<input type="hidden" id="startLoc" name="start" value="$(start)" />
				<input type="hidden" id="endLoc" name="end" value="$(end)" />
				<div class="capturebox"></div><br> 
		<!--a8-->
				<div class="div1" id="a8" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_black_rook.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bKnight1" width="60" height="60"/>
				</div>
		<!--b8-->
				<div class="div2" id="b8" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_black_knight.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bKnight1" width="60" height="60"/>
				</div>
		<!--c8-->
				<div class="div1" id="c8" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_black_bishop.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bBishop1" width="60" height="60"/>
				</div>
		<!--d8-->
				<div class="div2" id="d8" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_black_king.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bKing" width="60" height="60"/>
				</div>
		<!--e8-->
				<div class="div1" id="e8" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_black_queen.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bQueen" width="60" height="60"/>
				</div>
		<!--f8-->
				<div class="div2" id="f8" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_black_bishop.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bBishop2" width="60" height="60"/>
				</div>
		<!--g8-->
				<div class="div1" id="g8" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_black_knight.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bKnight2" width="60" height="60"/>
				</div>
		<!--h8-->
				<div class="div2" id="h8" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_black_rook.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bRook2" width="60" height="60"/>
				</div> <br>
		<!--a7-->
				<div class="div2" id="a7" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_black_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bPawn1" width="60" height="60"/>
				</div>
		<!--b7-->
				<div class="div1" id="a=b7" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_black_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bPawn2" width="60" height="60"/>
				</div>
		<!--c7-->
				<div class="div2" id="c7" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_black_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bPawn3" width="60" height="60"/>
				</div>
		<!--d7-->
				<div class="div1" id="d7" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_black_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bPawn4" width="60" height="60"/>
				</div>
		<!--e7-->
				<div class="div2" id="e7" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_black_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bPawn5" width="60" height="60"/>
				</div>
		<!--f7-->
				<div class="div1" id="f7" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_black_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bPawn6" width="60" height="60"/>
				</div>
		<!--g7-->
				<div class="div2" id="g7" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_black_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bPawn7" width="60" height="60"/>
				</div>
		<!--h7-->
				<div class="div1" id="h7" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_black_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bPawn8" width="60" height="60"/>
				</div> 
		<br>
		<!--a6-->
				<div class="div1" id="a6" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
				
		<!--b6-->
				<div class="div2" id="b6" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--c6-->
				<div class="div1" id="c6" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--d6-->
				<div class="div2" id="d6" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--e6-->
				<div class="div1" id="e6" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--f6-->
				<div class="div2" id="f6" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--g6-->
				<div class="div1" id="g6" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--h6-->
				<div class="div2" id="h6" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div> <br>
		<!--a5-->
				<div class="div2" id="a5" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--b5-->
				<div class="div1" id="b5" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--c5-->
				<div class="div2" id="c5" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--d5-->
				<div class="div1" id="d5" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--e5-->
				<div class="div2" id="e5" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--f5-->
				<div class="div1" id="f5" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--g5-->
				<div class="div2" id="g5" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--h5-->
				<div class="div1" id="h5" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div> <br>
		<!--a4-->
				<div class="div1" id="a4" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--b4-->
				<div class="div2" id="b4" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--c4-->
				<div class="div1" id="c4" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--d4-->
				<div class="div2" id="d4" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--e4-->
				<div class="div1" id="e4" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--f4-->
				<div class="div2" id="f4" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--g4-->
				<div class="div1" id="g4" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--h4-->
				<div class="div2" id="h4" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div> <br>
		<!--a3-->
				<div class="div2" id="a3" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--b3-->
				<div class="div1" id="b3" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--c3-->
				<div class="div2" id="c3" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--d3-->
				<div class="div1" id="d3" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--e3-->
				<div class="div2" id="e3" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--f3-->
				<div class="div1" id="f3" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--g3-->
				<div class="div2" id="g3" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div>
		<!--h3-->
				<div class="div1" id="h3" ondrop="drop(event)" ondragover="allowDrop(event)">
				<img src="" draggable="true" ondragstart="drag(event)"  width="60" height="60"/>
				</div> <br>
		<!--a2-->
				<div class="div1" id="a2" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_white_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wPawn1" width="60" height="60"/>
				</div>
		<!--b2-->
				<div class="div2" id="b2" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_white_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wPawn2" width="60" height="60"/>
				</div>
		<!--c2-->
				<div class="div1" id="c2" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_white_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wPawn3" width="60" height="60"/>
				</div>
		<!--d2-->
				<div class="div2" id="d2" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_white_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wPawn4" width="60" height="60"/>
				</div>
		<!--e2-->
				<div class="div1" id="e2" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_white_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wPawn5" width="60" height="60"/>
				</div>
		<!--f2-->
				<div class="div2" id="f2" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_white_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wPawn6" width="60" height="60"/>
				</div>
		<!--g2-->
				<div class="div1" id="g2" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_white_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wPawn7" width="60" height="60"/>
				</div>
		<!--h2-->
				<div class="div2" id="h2" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_white_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wPawn8" width="60" height="60"/>
				</div> <br>
		<!--a1-->
				<div class="div2" id="a1" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_white_rook.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wRook1" width="60" height="60"/>
				</div>
		<!--b1-->
				<div class="div1" id="b1" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_white_knight.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wKnight1" width="60" height="60"/>
				</div>
		<!--c1-->
				<div class="div2" id="c1" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_white_bishop.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wBishop1" width="60" height="60"/>
				</div>
		<!--d1-->
				<div class="div1" id="d1" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_white_queen.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wQueen" width="60" height="60"/>
				</div>
		<!--e1-->
				<div class="div2" id="e1" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_white_king.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wKing" width="60" height="60"/>
				</div>
		<!--f1-->
				<div class="div1" id="f1" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_white_bishop.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wBishop2" width="60" height="60"/>
				</div>
		<!--g1-->
				<div class="div2" id="g1" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_white_knight.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wKnight2" width="60" height="60"/>
				</div>
		<!--h1-->
				<div class="div1" id="h1" ondrop="drop(event)" ondragover="allowDrop(event)">
					<img src="Images/Chess_white_rook.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wRook2" width="60" height="60"/>
				</div>
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		
	<div class="capturebox"></div> 
	<p class="right"> USER 2 </p>
	</form>
	</div>
	
	
	
	
	</body>
</html>