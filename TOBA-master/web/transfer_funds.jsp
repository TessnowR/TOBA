
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
     <a href="account_activity.jsp">Account Activity</a> 
</ul>
  
</nav>
		<main>
                    <h2> Transfer Funds</h2>

<c:if test="${sessionScope.user != null}">
    Welcome ${user.firstName} ${user.lastName}.
</c:if>
    
<br><br><label>Savings Account Balance: $</label>
<span>${savings.balance}</span><br>

<br><label>Checking Account Balance: $</label>
<span>${checking.balance}</span><br>

<form action="Transaction" method="post">
    <input type="hidden" name="action" value="transfertosavings">
    <label>Transfer to Savings</label>
    <input type="number" name="savings" ><br>
    <input type="submit" value="Submit Transfer" class="margin-left">
</form>

<form action="Transaction" method="post">
    <input type="hidden" name="action" value="transfertochecking">
    <label>Transfer to Checking</label>
    <input type="number" name="checking" ><br>
    <input type="submit" value="Submit Transfer" class="margin-left">
</form>

 </main>




<footer>
   <c:import url="includes/footer.jsp" /><br>
  <small><i> Robert Tessnow-Ramirez rtessn1@mycourses.spcollege.edu </i></small>
</footer>
        </div>
  


