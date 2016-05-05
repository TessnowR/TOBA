<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


 <head>
     <title>TOBA: Account Activity</title>
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
     <li><a href="password_reset.jsp">Reset Password</a> </li>
     <li><a href="index.jsp"> Home</a></li>
     <li><a href="login.jsp">Login</a></li>
     <a href="transfer_funds.jsp">Transfer Funds</a> 
</ul>
  
</nav>               
<main>
<h2>Account Activity</h2>

<c:if test="${sessionScope.user != null}">
    Welcome ${user.firstName} ${user.lastName}.
    <p>Account Details</p>
    <p>Savings Balance: </p>${savings.balance}
    <p>Checking Balance: </p>${checking.balance}
    
    
</c:if>
<c:if test="${sessionScope.user == null}">
    You are not logged in.
</c:if>




</main>
        <footer>
  <c:import url="includes/footer.jsp" />
    <br>
  <small><i> Robert Tessnow-Ramirez rtessn1@mycourses.spcollege.edu </i></small>
</footer>
