<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="Registration" method="POST">
FirstName:<input type="text"name=firstname>
LastName:<input type="text"name=lastname>
Email:<input type="text"name=email>
Reemail:<input type="text"name=reemail>
Password:<input type="text"name=pswd>
choose file:<input type="file"name=file>
Date of birth:<input  name=dob >
gender<input type ="radio"name=gender>

<input type="submit"value=Save>
</form>
</body>
</html>