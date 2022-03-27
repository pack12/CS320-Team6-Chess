<!DOCTYPE html>

<html>
	<head>
		<title>Login Page </title>
	</head>

<style>
	h1{
	text-align: center;
	font-size: 100px;
	}
	
	div{
	text-align: center;
	}
	.center{
	margin: 0;
	position: absolute;
	left: 50%;}
</style>
	<body style="background-color:SteelBlue">
	
	<h1>Login</h1>
	
		<form  action="${pageContext.servletContext.contextPath}/fullmenu" method="post">
		
					<div>
                               User Name <input type="text" value="${username}"/><br><br>
                              Password <input type="password" value="${password}"/><br><br>
                              
                              
					</div>
           
          <!-- <a href=fullmenu> -->
                           <input type="submit" value="login" class="center">  <!-- </a> -->
                           </form>
                           <form action="${pageContext.servletContext.contextPath}/login" method="post">
                           <input type="submit" value="press" method="post">
                           </form>
                           
                          
	</body>
</html>
