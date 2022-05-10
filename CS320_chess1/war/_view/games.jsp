<%@ page import = "java.io.*,java.util.*" %>
<%
   // Get session creation time.
   Date createTime = new Date(session.getCreationTime());
   
   // Get last access time of this Webpage.
   Date lastAccessTime = new Date(session.getLastAccessedTime());

   String title = "Welcome Back to my website";
   Integer visitCount = new Integer(0);
   String visitCountKey = new String("visitCount");
   String userIDKey = new String("userID");
   String userID = new String("ABCD");

   // Check if this is new comer on your Webpage.
   if (session.isNew() ){
      title = "Welcome to my website";
      session.setAttribute(userIDKey, userID);
      session.setAttribute(visitCountKey,  visitCount);
   } 
   //visitCount = (Integer)session.getAttribute(visitCountKey);
   visitCount = visitCount + 1;
   userID = (String)session.getAttribute(userIDKey);
   session.setAttribute(visitCountKey,  visitCount);
%>
<!DOCTYPE html>

<html>
	<head>
		<title>Chess Team6</title>
		<style>
		h1{
		text-align: Center;
		font-size: 100px;
		}
		input[type=Submit] {
		text-align: Center;
		font-size: 40px;
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
		

		
		</script>
	</head>

	<body style="background-color:SteelBlue">
	
	
	
		<h1>${username}'s Games<h1>
		
		<br>
          
        <div style = "text-align: center; font-size: 50px;">
        	<p> GAME STATS </p>
        </div>
        
        <div style = "text-align: center; font-size: 20px;" id = "theBreadAndButter"><ul style = "list-style-type:none">${innerstuff} </ul></div>
         
         
         
          <form action="${pageContext.servletContext.contextPath}/fullmenu" method="get">
	<button onclick="back()" name="goBack" value=${goBack}> Go back</button> </form>
	
       <!--
        <center>
         <h1>Session Tracking</h1>
      </center>
      
      <table border = "1" align = "center"> 
         <tr bgcolor = "#949494">
            <th>Session info</th>
            <th>Value</th>
         </tr> 
         <tr>
            <td>id</td>
            <td><% out.print( session.getId()); %></td>
         </tr> 
         <tr>
            <td>Creation Time</td>
            <td><% out.print(createTime); %></td>
         </tr> 
         <tr>
            <td>Time of Last Access</td>
            <td><% out.print(lastAccessTime); %></td>
         </tr> 
         <tr>
            <td>User ID</td>
            <td><% out.print(userID); %></td>
         </tr> 
         <tr>
            <td>Number of visits</td>
            <td><% out.print(visitCount); %></td>
         </tr> 
      </table>
      -->
	</body>
</html>