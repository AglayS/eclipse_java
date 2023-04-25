<%-- Aglay Saenz CNT4714--%> 
<!DOCTYPE html>

<%-- start scriptlet --%>
<%
   String userInput = (String) session.getAttribute("userInput");
   if (userInput == null) userInput = "select * from suppliers";
   String message = (String) session.getAttribute("message");
   if (message ==null) message = " ";
%>

<html lang="en">
<body>
	<meta charset="utf-8">
	 <style type="text/css">
   	 <!--
   		body { background-color: white; color:blue; font-family: verdana, arial, sans-serif; font-size: 1.4em;  }
         h1 { color:black; font-size: 1.3em; }
         input[type="button"] {background-color: blue; font-weight:bold;}
         span {color: red;}
         #servlet {color:purple;}
         #jsp {color:cyan;}
   	  -->
	  </style>
<h1 style="text-align:center;">Welcome to the Summer 2022 Project 3 Enterprise Database System</h1>
<h1 style="text-align:center;">A Servlet/JSP-based Multi-tiered Enterprise Application Using a Tomcat Container</h1>

</body>

<body>
<hr>
<h3 style="text-align:center;">You are connected to the Project 3 Enterprise System as a client-level user.</h3>
<h3 style="text-align:center;">Please enter any valid SQL query or update command in the box below.</h3>

<form action = "/HW_3_CNT4714/clientHomePage" method = "post">
<p style="text-align:center;"><textarea id="userInput"  rows="5" cols="60" name="userInput"></textarea></p>

<p style="text-align:center;">
<input type = "submit" style="margin:5px;" value = "Execute Command" /> </input>
<input type="button" value="Clear" onclick="javascript:eraseText();">
</p>

</form>

<br><br><br>
<h3 style="text-align:center;">All execution results will appear below this line.</h3>
</body>

<body>
<hr>
<h3 style="text-align:center;">Database Results:</h3>

<table align=center border = "1">

<%-- JSP expression to access the message sent from the servlet --%>
<%=message%>

</table>

</body>

<script>
function eraseText(){
	document.getElementById("userInput").value = "";
}
</script>

</html>

