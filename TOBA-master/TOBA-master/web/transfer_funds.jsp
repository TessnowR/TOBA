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
                    <li><a href="account_activity.jsp">Account Activity</a> </li>
                </ul>

            </nav>
            <main>
                <h2> Transfer Funds</h2>

                <c:if test="${sessionScope.user != null}">
                    Welcome ${user.firstName} ${user.lastName}.
                </c:if>
                <h2>Account Balances</h2>
                <h3>Checking: ${checking.balance} || Savings: ${savings.balance}</h3>
                <p>====================================================</p>
                <h2>Transfer Funds from Checking to Savings</h2>
                <p><i>${message}</i></p>
                <form action="transfer" method="post" >
                    <input type="hidden" name="action" value="toSavings">

                    <label>Transfer Amount: </label>
                    <input type="double" name="amount" >
                    <p></p>
                    <input type="submit" value="Transfer to Savings">
                </form>
                <p>====================================================</p>
                <h2>Transfer Funds from Savings to Checking</h2>
                <p><i>${message}</i></p>
                <form action="transfer" method="post" >
                    <input type="hidden" name="action" value="toChecking">
                    <label>Transfer Amount: </label>
                    <input type="double" name="amount" >
                    <p></p>
                    <input type="submit" value="Transfer to Checking">
                </form>

            </main>




            <footer>
                <c:import url="includes/footer.jsp" /><br>
                <small><i> Robert Tessnow-Ramirez rtessn1@mycourses.spcollege.edu </i></small>
            </footer>
        </div>



