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
<title>facebook login page</title>

  <script type="text/javascript"src="jquery-3.1.1.min.js"></script>
  <link rel="stylesheet" href="C:\Users\user\Downloads\bootstrap-3.3.7-dist\css\bootstrap.css">
  <script type="text/javascript"src="script1.js"></script>
</head>
<body>
  <header style="background-color:#3b5998;">
  
      <div><font size="7" color="#fff">facebook</font>
			<input type="submit" value="sign up"style=background-color:green;color:white;></div>

		 </header>
  <form:form action="/Myspring/login" method="post" modelAttribute="loginBean">
  <div class="container-fluid" style="background-color:#dfe3ee;height:70%;"> 
<div class="row">
  <div class="col-md-4" style="background-color:light grey" ></div>
  <div class="col-md-4" style="background-color:#fff;;text-align:center;margin-top:60px">
  <h4><font size="3" color="darkblue"style="float:center;">Facebook Login</font></h4>
    
  Login as: <%-- <input type="hidden"id="username" name="username" value="${username }"> --%>${firstname }${lastname }<br>${username }
     
  <label for="" id="user"></label>
     <br>
   
   Password: <input type="password"id="password"placeholder="Password" name="password" style=margin-top:20px;margin-bottom:20px;>
   <div class="alert warning">
      <span class="closebtn">&times;</span>  
  <strong>Warning!</strong>The Password you've entered is incorrect

</div>
<script>
var close = document.getElementsByClassName("closebtn");
var i;

for (i = 0; i < close.length; i++) {
    close[i].onclick = function(){
        var div = this.parentElement;
        div.style.opacity = "0";
        setTimeout(function(){ div.style.display = "none"; }, 600);
    }
}
</script>
     <label for="" id="pass"></label>
  <br>

     <input type="checkbox"><font color="blue">keep me logged in</font><br>

      
     <input type="submit"  value="log in" id="btn-login"style=background-color:darkblue;margin-top:20px;>
 </div>
 <div class="col-md-4" style="background-color:lightgrey;"> </div>
</div>
</div>
</form:form>
</body>
</html>