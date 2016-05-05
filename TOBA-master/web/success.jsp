
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>TOBA:Success</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            		<header>
			<h1><c:import url="/includes/header.html" /></h1>
		</header>

<nav>
 <ul>
     <li><a href="login.jsp">Login</a> </li>
     <a href="index.jsp">Home</a> 
</ul>
  
</nav>
		<main>
                    <h2>Account created successfully!<br>

    Here is the information that you entered:</h2>
           

<br><br>

<h3><label>First Name: </label>
<span>${user.firstName}</span><br>
<label>Last Name: </label>
<span>${user.lastName}</span><br>
<label>Phone Number: </label>
<span>${user.phoneNumber}</span><br>
<label>Address: </label>
<span>${user.address}</span><br>
<label>City: </label>
<span>${user.city}</span><br>
<label>State: </label>
<span>${user.state}</span><br>
<label>Zipcode: </label>
<span>${user.zipcode}</span><br>
<label>Email: </label>
<span>${user.email}</span><br>
<label>Username: </label>
<span>${user.username}</span><br>
<label>Password: </label>
<span>${user.password}</span><br>
</h3>
 </main>




<footer>
   <c:import url="includes/footer.jsp" /> <br>
  <small><i> Robert Tessnow-Ramirez rtessn1@mycourses.spcollege.edu </i></small>
</footer>
        </div>
  


