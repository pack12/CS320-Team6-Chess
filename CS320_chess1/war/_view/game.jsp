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
		
		button{
		border-radius: 10px;
		background: SandyBrown;
		}
		
		</style>
		<script>
		let goBack=false;
		
		function back(){
		
		goBack=true;
		document.getElementById('goBack').value = goBack;
		console.log(goBack);
		
		}
		
		function forward(){
		goBack=false;
		console.log(goBack);}
		
		function drag(ev) {
		  ev.dataTransfer.setData("text", ev.target.id);
		  var start = event.target.parentNode.getAttribute("id");
		  document.getElementById("startLoc").value = start;
		  
		  <!--
		  var image = event.target.parentNode.get
		  document.getElementById("imgsrc").value = image 
		  -->
		 
		}
		
		function allowDrop(event) {
		  event.preventDefault();
		  var end = event.target.parentNode.getAttribute("id");
		  document.getElementById("endLoc").value = end;
		}
		
		function drop(ev) {
		  event.preventDefault();
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
				<input type="hidden" id="imgsrc" name="img" value="${image}" />
				<div class="capturebox"></div><br> 
		<!--a8-->
				<div class="div1" id="a8" ondrop="drop(event)" ondragover="allowDrop(event)">${value8}
					<img src="${a8Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="bRook1" width="60" height="60"/>
				</div>
		<!--b8-->
				<div class="div2" id="b8" ondrop="drop(event)" ondragover="allowDrop(event)">${value16}
					<img src="${b8Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="bKnight1" width="60" height="60"/>
				</div>
		<!--c8-->
				<div class="div1" id="c8" ondrop="drop(event)" ondragover="allowDrop(event)">${value24}
					<img src="${c8Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="bBishop1" width="60" height="60"/>
				</div>
		<!--d8-->
				<div class="div2" id="d8" ondrop="drop(event)" ondragover="allowDrop(event)">${value32}
					<img src="${d8Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="bKing" width="60" height="60"/>
				</div>
		<!--e8-->
				<div class="div1" id="e8" ondrop="drop(event)" ondragover="allowDrop(event)">${value40}
					<img src="${e8Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="bQueen" width="60" height="60"/>
				</div>
		<!--f8-->
				<div class="div2" id="f8" ondrop="drop(event)" ondragover="allowDrop(event)">${value48}
					<img src="${f8Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="bBishop2" width="60" height="60"/>
				</div>
		<!--g8-->
				<div class="div1" id="g8" ondrop="drop(event)" ondragover="allowDrop(event)">${value56}
					<img src="${g8Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="bKnight2" width="60" height="60"/>
				</div>
		<!--h8-->
				<div class="div2" id="h8" ondrop="drop(event)" ondragover="allowDrop(event)">${value64}
					<img src="${h8Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="bRook2" width="60" height="60"/>
				</div> <br>
		<!--a7-->
				<div class="div2" id="a7" ondrop="drop(event)" ondragover="allowDrop(event)">${value7}
					<img src="${a7Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="bPawn1" width="60" height="60"/>
				</div>
		<!--b7-->
				<div class="div1" id="b7" ondrop="drop(event)" ondragover="allowDrop(event)">${value15}
					<img src="${b7Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="bPawn2" width="60" height="60"/>
				</div>
		<!--c7-->
				<div class="div2" id="c7" ondrop="drop(event)" ondragover="allowDrop(event)">${value23}
					<img src="${c7Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="bPawn3" width="60" height="60"/>
				</div>
		<!--d7-->
				<div class="div1" id="d7" ondrop="drop(event)" ondragover="allowDrop(event)">${value31}
					<img src="${d7Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="bPawn4" width="60" height="60"/>
				</div>
		<!--e7-->
				<div class="div2" id="e7" ondrop="drop(event)" ondragover="allowDrop(event)">${value39}
					<img src="${e7Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="bPawn5" width="60" height="60"/>
				</div>
		<!--f7-->
				<div class="div1" id="f7" ondrop="drop(event)" ondragover="allowDrop(event)">${value47}
					<img src="${f7Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="bPawn6" width="60" height="60"/>
				</div>
		<!--g7-->
				<div class="div2" id="g7" ondrop="drop(event)" ondragover="allowDrop(event)">${value55}
					<img src="${g7Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="bPawn7" width="60" height="60"/>
				</div>
		<!--h7-->
				<div class="div1" id="h7" ondrop="drop(event)" ondragover="allowDrop(event)">${value63}
					<img src="${h7Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="bPawn8" width="60" height="60"/>
				</div> 
		<br>
		<!--a6-->
				<div class="div1" id="a6" ondrop="drop(event)" ondragover="allowDrop(event)">${value6}
				<img src="${a6Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
				
		<!--b6-->
				<div class="div2" id="b6" ondrop="drop(event)" ondragover="allowDrop(event)">${value14}
				<img src="${b6Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--c6-->
				<div class="div1" id="c6" ondrop="drop(event)" ondragover="allowDrop(event)">${value22}
				<img src="${c6Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--d6-->
				<div class="div2" id="d6" ondrop="drop(event)" ondragover="allowDrop(event)">${value30}
				<img src="${d6Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--e6-->
				<div class="div1" id="e6" ondrop="drop(event)" ondragover="allowDrop(event)">${value38}
				<img src="${e6Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--f6-->
				<div class="div2" id="f6" ondrop="drop(event)" ondragover="allowDrop(event)">${value46}
				<img src="${f6Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--g6-->
				<div class="div1" id="g6" ondrop="drop(event)" ondragover="allowDrop(event)">${value54}
				<img src="${g6Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--h6-->
				<div class="div2" id="h6" ondrop="drop(event)" ondragover="allowDrop(event)">${value62}
				<img src="${h6Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div> <br>
		<!--a5-->
				<div class="div2" id="a5" ondrop="drop(event)" ondragover="allowDrop(event)">${value5}
				<img src="${a5Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--b5-->
				<div class="div1" id="b5" ondrop="drop(event)" ondragover="allowDrop(event)">${value13}
				<img src="${b5Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--c5-->
				<div class="div2" id="c5" ondrop="drop(event)" ondragover="allowDrop(event)">${value21}
				<img src="${c5Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--d5-->
				<div class="div1" id="d5" ondrop="drop(event)" ondragover="allowDrop(event)">${value29}
				<img src="${d5Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--e5-->
				<div class="div2" id="e5" ondrop="drop(event)" ondragover="allowDrop(event)">${value37}
				<img src="${e5Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--f5-->
				<div class="div1" id="f5" ondrop="drop(event)" ondragover="allowDrop(event)">${value45}
				<img src="${f5Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--g5-->
				<div class="div2" id="g5" ondrop="drop(event)" ondragover="allowDrop(event)">${value53}
				<img src="${g5Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--h5-->
				<div class="div1" id="h5" ondrop="drop(event)" ondragover="allowDrop(event)">${value61}
				<img src="${h5Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div> <br>
		<!--a4-->
				<div class="div1" id="a4" ondrop="drop(event)" ondragover="allowDrop(event)">${value4}
				<img src="${a4Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--b4-->
				<div class="div2" id="b4" ondrop="drop(event)" ondragover="allowDrop(event)">${value12}
				<img src="${b4Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--c4-->
				<div class="div1" id="c4" ondrop="drop(event)" ondragover="allowDrop(event)">${value20}
				<img src="${c4Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--d4-->
				<div class="div2" id="d4" ondrop="drop(event)" ondragover="allowDrop(event)">${value28}
				<img src="${d4Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--e4-->
				<div class="div1" id="e4" ondrop="drop(event)" ondragover="allowDrop(event)">${value36}
				<img src="${e4Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--f4-->
				<div class="div2" id="f4" ondrop="drop(event)" ondragover="allowDrop(event)">${value44}
				<img src="${f4Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--g4-->
				<div class="div1" id="g4" ondrop="drop(event)" ondragover="allowDrop(event)">${value52}
				<img src="${g4Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--h4-->
				<div class="div2" id="h4" ondrop="drop(event)" ondragover="allowDrop(event)">${value60}
				<img src="${h4Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div> <br>
		<!--a3-->
				<div class="div2" id="a3" ondrop="drop(event)" ondragover="allowDrop(event)">${value3}
				<img src="${a3Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--b3-->
				<div class="div1" id="b3" ondrop="drop(event)" ondragover="allowDrop(event)">${value11}
				<img src="${b3Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--c3-->
				<div class="div2" id="c3" ondrop="drop(event)" ondragover="allowDrop(event)">${value19}
				<img src="${c3Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--d3-->
				<div class="div1" id="d3" ondrop="drop(event)" ondragover="allowDrop(event)">${value27}
				<img src="${d3Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--e3-->
				<div class="div2" id="e3" ondrop="drop(event)" ondragover="allowDrop(event)">${value35}
				<img src="${e3Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--f3-->
				<div class="div1" id="f3" ondrop="drop(event)" ondragover="allowDrop(event)">${value43}
				<img src="${f3Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--g3-->
				<div class="div2" id="g3" ondrop="drop(event)" ondragover="allowDrop(event)">${value51}
				<img src="${g3Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div>
		<!--h3-->
				<div class="div1" id="h3" ondrop="drop(event)" ondragover="allowDrop(event)">${value59}
				<img src="${h3Image}" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)"  width="60" height="60"/>
				</div> <br>
		<!--a2-->
				<div class="div1" id="a2" ondrop="drop(event)" ondragover="allowDrop(event)">${value2}
					<img src="${a2Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="wPawn1" width="60" height="60"/>
				</div>
		<!--b2-->
				<div class="div2" id="b2" ondrop="drop(event)" ondragover="allowDrop(event)">${value10}
					<img src="${b2Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="wPawn2" width="60" height="60"/>
				</div>
		<!--c2-->
				<div class="div1" id="c2" ondrop="drop(event)" ondragover="allowDrop(event)">${value18}
					<img src="${c2Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="wPawn3" width="60" height="60"/>
				</div>
		<!--d2-->
				<div class="div2" id="d2" ondrop="drop(event)" ondragover="allowDrop(event)">${value26}
					<img src="${d2Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="wPawn4" width="60" height="60"/>
				</div>
		<!--e2-->
				<div class="div1" id="e2" ondrop="drop(event)" ondragover="allowDrop(event)">${value34}
					<img src="${e2Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="wPawn5" width="60" height="60"/>
				</div>
		<!--f2-->
				<div class="div2" id="f2" ondrop="drop(event)" ondragover="allowDrop(event)">${value42}
					<img src="${f2Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="wPawn6" width="60" height="60"/>
				</div>
		<!--g2-->
				<div class="div1" id="g2" ondrop="drop(event)" ondragover="allowDrop(event)">${value50}
					<img src="${g2Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="wPawn7" width="60" height="60"/>
				</div>
		<!--h2-->
				<div class="div2" id="h2" ondrop="drop(event)" ondragover="allowDrop(event)">${value58}
					<img src="${h2Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="wPawn8" width="60" height="60"/>
				</div> <br>
		<!--a1-->
				<div class="div2" id="a1" ondrop="drop(event)" ondragover="allowDrop(event)">${value1}
					<img src="${a1Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="wRook1" width="60" height="60"/>
				</div>
		<!--b1-->
				<div class="div1" id="b1" ondrop="drop(event)" ondragover="allowDrop(event)">${value9}
					<img src="${b1Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="wKnight1" width="60" height="60"/>
				</div>
		<!--c1-->
				<div class="div2" id="c1" ondrop="drop(event)" ondragover="allowDrop(event)">${value17}
					<img src="${c1Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="wBishop1" width="60" height="60"/>
				</div>
		<!--d1-->
				<div class="div1" id="d1" ondrop="drop(event)" ondragover="allowDrop(event)">${value25}
					<img src="${d1Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="wQueen" width="60" height="60"/>
				</div>
		<!--e1-->
				<div class="div2" id="e1" ondrop="drop(event)" ondragover="allowDrop(event)">${value33}
					<img src="${e1Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="wKing" width="60" height="60"/>
				</div>
		<!--f1-->
				<div class="div1" id="f1" ondrop="drop(event)" ondragover="allowDrop(event)">${value41}
					<img src="${f1Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="wBishop2" width="60" height="60"/>
				</div>
		<!--g1-->
				<div class="div2" id="g1" ondrop="drop(event)" ondragover="allowDrop(event)">${value49}
					<img src="${g1Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="wKnight2" width="60" height="60"/>
				</div>
		<!--h1-->
				<div class="div1" id="h1" ondrop="drop(event)" ondragover="allowDrop(event)">${value57}
					<img src="${h1Image}" alt="Black Queen" draggable="true" ondragstart="drag(event)" ondrop="drop(event)" ondragover="allowDrop(event)" id="wRook2" width="60" height="60"/>
				</div>
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		
	<div class="capturebox"></div> 
	<p class="right"> USER 2 </p>
	</form>
	</div>
	<form action="${pageContext.servletContext.contextPath}/fullmenu" method="get">
	<button onclick="back()" name="goBack" value=${goBack}> Go back</button> <button onclick="forward()"> Go forward </button> </form>
	<p> ${goBack}</p>
	
	
	</body>
</html>