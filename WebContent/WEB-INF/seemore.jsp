<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head style="background-color:#3b5998;">
<link rel="stylesheet" href="css/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="JS/jquery.autocomplete.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>Friendrequest</title>
<script>
	
$( function() {
   
	//call ajax function
	 $( "#searchbox" ).autocomplete({
     // source: availableTags{
    	 source:function(request,response)
	//  var availableTags = [];
	 {
	                   $.ajax({
		                        url : "/Myspring/search",
		                        type : "GET",
		                        data : {
		                        	searchbox : request.term
		                        },
		                        dataType : "json",
		                        success : function(data) {
	                                response(data);
	                        }

		                        });
                             }
                        });
});

</script>

</head>
<body>
<header style="background-color:#3b5998;">
<div class="container">
	<div class="row">
	  <div class="col-md-6">
	   <%
	System.out.println(session.getAttribute("firstname"));
	System.out.println(session.getAttribute("lastname"));
	System.out.println(session.getAttribute("file"));
	System.out.println(session.getAttribute("userid"));
	
	%>
		<input type="text" placeholder="search facebook" name="searchbox" id="searchbox" style="width:60%; margin-top:8px;">
		<span class="glyphicon glyphicon-search" style="position: absolute;left:330px;top:14px; "></span></div>
		  
	  <div class="col-md-5">
    <h5><font color="#fff"><img height="40" width="40"src="<c:url value="/images/${file}" />"/></font>${firstname} ${lastname}</h5></div>
     <div class="col-md-1" class="btn btn-primary;"style="margin-top:12px;"><a href="logout">Logout</a></div>
			</div>
			</div>
</head>

<div class="container-fluid"style="background-color:#f7f7f7">
  <div class="row" style="margin-top:20px;">
    <div class="col-md-2"><img height="40" width="40"src="<c:url value="/images/${file}" />"/> ${firstname} ${lastname} <br>
     <span class="glyphicon glyphicon-edit"></span> Edit profile<br>
     <span class="glyphicon glyphicon-edit"style="color:blue;"></span><a href="friendrequest">Approve Friend</a><br>
	<span class="glyphicon glyphicon-edit"style="color:blue;"></span><a href="searchfriend">Search Friend</a></div>
    <div class="col-md-6" style="margin-left:20px;margin-right:20px;margin-bottom:3px;">
       <c:forEach var="listValue" items="${lists}">
       <div class="row"style="height:100px;background-color:white;margin-bottom:3px;">
           <div class="col-md-2"> <img height="40" width="40"src="<c:url value="/images/${listValue.getFile()}" />"/></div>
           <div class="col-md-4">${listValue.getFirstname()} ${listValue.getLastname()}</div>
            <!-- <div class="col_md_5">  <input type="submit" value="Add Friend" id="addfrnd"> -->
           <div class="col-md-4"><a href="/Myspring/addfriend?id=<c:out value="${listValue.getID()}"/>" style="color:grey;">ADD FRIEND</a></div>
           
       </div>
       </c:forEach> 
    </div>
 <div class="col-md-3"style="background-color:#3d5998;height:200px;">Trending</div>
  </div>
</div>
    

</body>
</html>