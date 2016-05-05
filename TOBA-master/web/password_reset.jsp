
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<head>
    <title>TOBA: password reset</title>
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
                <li><a href="login.jsp">Login</a> </li>
                <li><a href="new_customer.jsp">New Customer Sign Up page</a> </li>
                <li><a href="password_reset.jsp">Reset Password</a> </li>
            </ul>

        </nav>
        <h2>Reset Your Password</h2>
         <i><h2>${message}</h2></i>
        <main>
            <form class="ex" action="password_reset" method="post">
                <input type="hidden" name="action" value="reset">
                <label>Current Password: ${user.password}</label>
                <br>

                <label>New Password: </label>
                <input type="password" name="password"><br>

                <input type="submit" value="submit">
            </form>

        </main>

        <footer>
            <c:import url="includes/footer.jsp" />
            <br>
            <small><i> Robert Tessnow-Ramirez rtessn1@mycourses.spcollege.edu </i></small>
        </footer>
    </div>
</body>