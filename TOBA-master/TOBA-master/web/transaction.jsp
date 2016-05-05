
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

   
<!DOCTYPE html>
<html>
    <head>
        <title>TOBA Titan Online Banking Application</title>
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
	<li><a href="index.jsp">Home</a> </li>
	 <li><a href="login.jsp ">Login</a> </li>
         <li><a href="new_customer.jsp">New Customer Registration </a></li>
</ul>
  
</nav>
		<main>
			
		

<jsp:useBean id="user" class="TOBA.business.Users" scope="session" />
        <h1>Account Activity</h1>
        <c:choose>
            <c:when test="${user.username != ''}">
                <p>Welcome, ${user.firstName} ${user.lastName}.</p><br>
                <p>Account Balances: </p>
                <p>Savings Balance: ${savingsAccount.balance}</p>
                <p>Checking Balance: ${checkingAccount.balance}</p><br>
                <p>Make a transaction: </p>
                <form action="transaction" method="post">
                <p>From account:</p>
                <label>Savings:</label>
                <input type="radio" name="fromAccount" value="savings">
                <label>Checking:</label>
                <input type="radio" name="fromAccount" value="checking"><br>
                <p>To account:</p>
                <label>Savings:</label>
                <input type="radio" name="toAccount" value="savings">
                <label>Checking:</label>
                <input type="radio" name="toAccount" value="checking"><br><br>
                <label>Amount:</label>
                <input type="number" name="amount" required><br><br>
                <input type="submit" value="Transfer Funds">
        </form>
            </c:when>
            <c:otherwise>
                <p>Not logged in</p>
            </c:otherwise>
        </c:choose>
<c:import url="/footer.jsp" />
			
		</main>
		
<footer>
  <c:import url="includes/footer.jsp" />
    <br>
  <small><i> Robert Tessnow-Ramirez rtessn1@mycourses.spcollege.edu </i></small>
</footer>
</div>
</body>
</html>