
<%@page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
    int currentMonth = currentDate.get(Calendar.MONTH);
    int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);
%>

<p>&copy; Copyright <%= currentMonth + 1%>/<%=currentDay %>/<%= currentYear %> TOBA Titan Online Banking Application </p>

</body>
</html>

