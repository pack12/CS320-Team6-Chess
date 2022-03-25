<!DOCTYPE HTML>
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
function allowDrop(ev) {
  ev.preventDefault();
}

function drag(ev) {
  ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
  ev.preventDefault();
  var data = ev.dataTransfer.getData("text");
  ev.target.appendChild(document.getElementById(data));
}
</script>
</head>
<body style= "background-color:slategrey">

<div class="centerboard">

<p> USER 1 </p>

<div class="capturebox"></div><br> 
<!--a8-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_black_rook.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bRook1" width="60" height="60"/>
</div>
<!--b8-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_black_knight.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bKnight1" width="60" height="60"/>
</div>
<!--c8-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_black_bishop.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bBishop1" width="60" height="60"/>
</div>
<!--d8-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_black_king.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bKing" width="60" height="60"/>
</div>
<!--e8-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_black_queen.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bQueen" width="60" height="60"/>
</div>
<!--f8-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_black_bishop.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bBishop2" width="60" height="60"/>
</div>
<!--g8-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_black_knight.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bKnight2" width="60" height="60"/>
</div>
<!--h8-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_black_rook.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bRook2" width="60" height="60"/>
</div> <br>
<!--a7-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_black_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bPawn1" width="60" height="60"/>
</div>
<!--b7-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_black_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bPawn2" width="60" height="60"/>
</div>
<!--c7-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_black_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bPawn3" width="60" height="60"/>
</div>
<!--d7-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_black_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bPawn4" width="60" height="60"/>
</div>
<!--e7-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_black_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bPawn5" width="60" height="60"/>
</div>
<!--f7-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_black_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bPawn6" width="60" height="60"/>
</div>
<!--g7-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_black_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bPawn7" width="60" height="60"/>
</div>
<!--h7-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_black_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="bPawn8" width="60" height="60"/>
</div> 
<br>
<!--a6-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--b6-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--c6-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--d6-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--e6-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--f6-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--g6-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--h6-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div> <br>
<!--a5-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--b5-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--c5-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--d5-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--e5-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--f5-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--g5-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--h5-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div> <br>
<!--a4-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--b4-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--c4-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--d4-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--e4-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--f4-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--g4-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--h4-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div> <br>
<!--a3-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--b3-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--c3-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--d3-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--e3-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--f3-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--g3-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--h3-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div> <br>
<!--a2-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_white_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wPawn1" width="60" height="60"/>
</div>
<!--b2-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_white_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wPawn2" width="60" height="60"/>
</div>
<!--c2-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_white_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wPawn3" width="60" height="60"/>
</div>
<!--d2-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_white_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wPawn4" width="60" height="60"/>
</div>
<!--e2-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_white_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wPawn5" width="60" height="60"/>
</div>
<!--f2-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_white_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wPawn6" width="60" height="60"/>
</div>
<!--g2-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_white_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wPawn7" width="60" height="60"/>
</div>
<!--h2-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_white_pawn.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wPawn8" width="60" height="60"/>
</div> <br>
<!--a1-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_white_rook.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wRook1" width="60" height="60"/>
</div>
<!--b1-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_white_knight.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wKnight1" width="60" height="60"/>
</div>
<!--c1-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_white_bishop.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wBishop1" width="60" height="60"/>
</div>
<!--d1-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_white_queen.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wQueen" width="60" height="60"/>
</div>
<!--e1-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_white_king.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wKing" width="60" height="60"/>
</div>
<!--f1-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_white_bishop.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wBishop2" width="60" height="60"/>
</div>
<!--g1-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_white_knight.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wKnight2" width="60" height="60"/>
</div>
<!--h1-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="Images/Chess_white_rook.png" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="wRook2" width="60" height="60"/>
</div> 
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>

<div class="centerboard">
<div class="capturebox"></div> 
<p class="right"> USER 2 </p>

</div>





</body>
</html>