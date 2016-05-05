
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<head>
        <title>TOBA: Login</title>
              <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <div id="wrapper">
		<header>
        <h1> <c:import url="/includes/header.html" /></h1>
     
       
                </header>
                <nav>
 <ul>
	<li><a href="index.jsp">Home</a> </li>
	 <li><a href="login.jsp">Login</a> </li>
	 <li><a href="new_customer.jsp">New Customer Sign Up page</a> </li>
        
</ul>
  
</nav>
        <main>
             <h2>Login with your credentials</h2>
        <form action="LoginServlet" method="post">
            <input type="hidden" name="action" value="add">
            <label class="pad_top">Username:</label>
            <input type="text" name="username" required><br>
            <label class="pad_top">Password:</label>
            <input type="password" name="password"><br>

            <input type="submit" value="Login" class="margin-left">
        </form>
        </main>
        
            
               <footer>
   <c:import url="includes/footer.jsp" /> <br>
  <small><i> Robert Tessnow-Ramirez rtessn1@mycourses.spcollege.edu </i></small>
</footer>
    </div>
        
           
