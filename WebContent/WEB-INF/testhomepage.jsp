<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title> 
</head>
<body>
${error}
<form:form name="submitForm" action="Registration" method="POST">
<div align="center">
<table>
<tr>
<td>First Name</td>
<td><input type="text" name="Firstname" /></td>
</tr>
<tr>
<td>LastName</td>
<td><input type="text" name="Lastname" /></td>
</tr>
<tr>
<tr>
<td>PhoneNo</td>
<td><input type="text" name="Phoneno" /></td>
</tr>
<tr>
<tr>
<td>Email ID</td>
<td><input type="text" name="Emailid" /></td>
</tr>
<tr>
<tr>
<td>Password</td>
<td><input type="text" name="Password" /></td>
</tr>
<tr>
<tr>
<td></td>
<td><input type="submit" value="submit" /></td>
</tr>
</table>
<div style="color=red">${error }</div>
</div>
</form:form>
</body>
</html>