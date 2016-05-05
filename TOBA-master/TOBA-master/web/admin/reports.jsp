<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
    <head>
        <title>Admin Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../styles/main.css" type="text/css"/>
    </head>
    <body>
<div id="wrapper">
		<header>
                    <h1></h1>

			
		</header>
<nav>
 <ul>
	<li><a href="../index.jsp">Home</a> </li>
	 <li><a href="../login.jsp ">Login</a> </li>
         <li><a href="../new_customer.jsp">New Customer Registration </a></li>
</ul>
  
</nav>
		<main>
			<h1>Report</h1>
         <p><a href="downloadFile?name=userReport.xls">Download Report</a></p>

        <label>First Name:</label>
        <span><c:out value="${user.firstName}" /></span><br>
        <label>Last Name:</label>
        <span><c:out value="${user.lastName}" /></span><br>
        <label>Phone:</label>
        <span><c:out value="${user.phoneNumber}" /></span><br>
        <label>Address:</label>
        <span><c:out value="${user.address}" /></span><br>
        <label>City:</label>
        <span><c:out value="${user.city}" /></span><br>
        <label>State:</label>
        <span>${user.state}</span><br>
        <label>Zip Code:</label>
        <span>${user.zipcode}</span><br>
        <label>Email:</label>
        <span>${user.email}</span><br>
        <label>Username:</label>
        <span>${user.username}</span><br>
        <label>Password:</label>
        <span>${user.password}</span><br>

        <p>
        <a href="../index.jsp">Return to Main Page</a>
        </p>	
			
		</main>
		
<footer>
  
    <br>
  <small><i> Robert Tessnow-Ramirez rtessn1@mycourses.spcollege.edu </i></small>
</footer>
</div>
</body>
</html>
