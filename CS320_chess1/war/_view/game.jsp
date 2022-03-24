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
  background: white;
  padding: 0px;
  }
  
.capturebox {
  height: 60px;
  padding: 10px;
  border: 2px solid black;
}
  
.div2 {
  float: left;
  width: 60px;
  height: 60px;
  border: 1px solid black;
  background: black;
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
<body>

<div class="centerboard">

<p> USER 1 </p>

<div class="capturebox"></div><br> 
<!--a8-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
<img src="https://upload.wikimedia.org/wikipedia/commons/8/81/Chess_bdt60.png" title="bQueen" alt="Black Queen" draggable="true" ondragstart="drag(event)" id="drag1" width="60" height="60"/>
</div>
<!--b8-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--c8-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
</div>
<!--d8-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--e8-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--f8-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--g8-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--h8-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div> <br>
<!--a7-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--b7-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--c7-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--d7-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--e7-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--f7-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--g7-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--h7-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div> <br>
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
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--b2-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--c2-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--d2-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--e2-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--f2-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--g2-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--h2-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div> <br>
<!--a1-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--b1-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--c1-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--d1-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--e1-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--f1-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--g1-->
<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<!--h1-->
<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div> 
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>

<div class="centerboard">
<div class="capturebox"></div> 
<p class="right"> USER 2 </p>

</div>





</body>
</html>