<!DOCTYPE HTML>
<html>
<head>
<style>

.centerboard{
  margin: auto;
  width: 27.78%;
  padding: 10px;
}

.div1 {
  float: none;
  width: 60px;
  height: 60px;
  border: 1px solid black;
  background: white;
  display: inline-block;
  padding: 0px;
  }
  
.capturebox {
  height: 60px;
  padding: 10px;
  border: 2px solid black;
}
  
.div2 {
  float: none;
  width: 60px;
  height: 60px;
  border: 1px solid black;
  background: black;
  display: inline-block;
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

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div> <br>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div> <br>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div> <br>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div> <br>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div> <br>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div> <br>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div> <br>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<div class="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div> <br><br>

<div class="capturebox"></div> 

<p class="right"> USER 2 </p>

</div>



</body>
</html>