     <%@page contentType="text/html" pageEncoding="utf-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <!DOCTYPE html>

<html>
    <head>
        <title>TOBA: New Customer</title>
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
      
</ul>
  
</nav>          

        <main>
            <h2>Register a new account</h2>
            <i><h2>${message}</h2></i>
        <form class ="ex" action="NewCustomerServlet" method="post">
            <input type="hidden" name="action" value="add">
            <label>First Name:</label>
            <input type="text" name="firstName" ><br>
            <label>Last Name:</label>
            <input type="text" name="lastName" ><br>
            <label>Phone #:</label>
            <input type="text" name="phoneNumber" ><br>
            <label>Address:</label>
            <input type="text" name="address" ><br>
            <label>City:</label>
            <input type="text" name="city" ><br>
            <label>State:</label>
            <input type="text" name="state" ><br>
            <label>Zip Code:</label>
            <input type="text" name="zipcode" ><br>
            <label>Email:</label>
            <input type="email" name="email" ><br>

            <input type="submit" value="Submit" class="margin-left">
        </form>
        </main>
        

       

        <footer>
  <c:import url="includes/footer.jsp" />
    <br>
  <small><i> Robert Tessnow-Ramirez rtessn1@mycourses.spcollege.edu </i></small>
</footer>
 </div>
    </body>
</html>
