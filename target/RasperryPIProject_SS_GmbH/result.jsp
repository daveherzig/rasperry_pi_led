<%@ page import ="java.util.*,ch.fhnw.model.*,ch.fhnw.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>
Manage Timestamps
</h1>

Year:
<select name="year" form="addform">
    <%
    for (int i=0; i<10; i++) {
       %>
       <option value="<%=2019+i%>"><%=2019+i%></option>
       <%
    }
    %>
</select>
Month:
<select name="month" form="addform">
    <%
    for (int i=0; i<12; i++) {
       %>
       <option value="<%=1+i%>"><%=1+i%></option>
       <%
    }
    %>
</select>
Day:
<select name="day" form="addform">
    <%
    for (int i=0; i<31; i++) {
       %>
       <option value="<%=1+i%>"><%=1+i%></option>
       <%
    }
    %>
</select>
Hour:
<select name="hour" form="addform">
    <%
    for (int i=0; i<24; i++) {
       %>
       <option value="<%=i%>"><%=i%></option>
       <%
    }
    %>
</select>
Minute:
<select name="minute" form="addform">
    <%
    for (int i=0; i<60; i++) {
       %>
       <option value="<%=i%>"><%=i%></option>
       <%
    }
    %>
</select>
Second:
<select name="second" form="addform">
    <%
    for (int i=0; i<60; i++) {
       %>
       <option value="<%=i%>"><%=i%></option>
       <%
    }
    %>
</select>

<br/><br/>

<form method="post" action="AddTimestamp" id="addform">
    <input type="submit" value="Add Timestamp">
</form>

<br/><br/>
    
<%
List result= (List) request.getAttribute("timestamps");
Iterator it = result.iterator();
%>
<table>
<tr>
<th>Timestamp</th>
<th>Date</th>
<th>Delete</th>
</tr>
<%
while(it.hasNext()){
  Information obj = (Information)it.next();
  out.println("<tr>");
  out.println("<td>" + obj.getTimestamp() + "</th>");
  out.println("<td>" + TSUtil.convertTimeStamp(obj.getTimestamp()) + "</th>");
  out.println("<td><button type=\"button\">Delete</button></th>");
  out.println("</tr>");
}
%>
</table>

</body>
</html>