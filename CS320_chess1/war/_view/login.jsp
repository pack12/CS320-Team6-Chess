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
	.error {
			color: red;
		}
</style>
	<body style="background-color:SteelBlue">
	
	<h1>Login</h1>
	<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
		<form  action="${pageContext.servletContext.contextPath}/login" method="post">
		
					<div>
                               User Name <input type="text" name="username" value="${username}"/><br><br>
                              Password <input type="password" name="password" value="${password}"/><br><br>
                              
                              
					</div>
           
          <!-- <a href=fullmenu> --> 
                           <input type="submit" value="login" class="center"/>  <!-- </a> -->
                          </form>
                           <!-- Put form end tag here-->
                           
                          
	</body>
</html>
