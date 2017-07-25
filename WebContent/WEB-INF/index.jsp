<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Facebook</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <link  rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="">
       <script type="text/javascript">

          $(document).ready(function(){
    	   var valid=false;
           $("#loginform").submit(function(e)
           {
             if(valid==false)
    		 {
    		 return false;
    		 }
    		 else
    		 {
    		 return true;
    		 }
    	   });
    
           $("#log").click(function(){
		      var userlog=$("#username").val();
	          var pswdlog= $("#logpass").val();
	    
	          if(pswdlog=="")
	          {
	    	    $("#user").text("Required Field");
	    	    valid=false;
	          }
	          else
		      {
		        $("#user").text("");
		        valid=true;
		      }
	    
	          if(userlog=="")
	          {
	    	    $("#logpswd").text("Required Field");
	    	    valid=false;
	          }
	          else
		      {
		        $("#logpswd").text("");
		        valid=true;
		      }
	     
	         });
             $("#registerform").submit(function(e){
        		 
               if(ok==false)
        	  {
        	   return false;
              }
        	  else
        	  {
        	   return true;
        	  }
    	   });
     
	       $("#create").click(function(){
	
		      ok=true;
		      if($("#firstname").val()==""){
		    	   $("#fst").text("Please Enter first name");
		    	   ok=false;
		         }
		       else
			     {
			       $("#fst").text("");
			       ok=true;
			     }
 
               if($("#lastname").val()=="")
                {
    	          $("#lst").text("Please Enter last name");
    	          ok=false;
                }
               else
    	        {
    	           $("#lst").text("");
    	           ok=true;
    	        }
            
              var emailID = $("#email").val();
              var atpos = emailID.indexOf("@");
              var dotpos = emailID.lastIndexOf(".");
             
               if(emailID=="")
               {
                 $("#el").text("Please enter email");
                 ok=false;
               }
               else if (atpos < 1 || ( dotpos - atpos < 2 )) 
                {
                   $("#el").text("Invalid Format");
                   ok=false;
                }
               else
            	{
            	  $("#el").text("");
            	  ok=true;
            	}
       
                var ReemailID = $("#reemail").val();
                if(ReemailID =="")
                {
                  $("#re").text("Please re-enter email");
                  ok=false;
                }
                else
    	        {
    	           $("#re").text("");
    	           ok=true;
    	        }
    
                if (ReemailID != emailID)
                {
                  alert("Enter the same email Id");
                } 
                var pass=$("#Password").val();
                var val_password = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;  
                
                if(pass=="")
                {
                  $("#pswd").text("Required Field");
                  ok=false;
                }
                else if(!val_password.test(pass))
                {
               	  $("#pswd").text("Invalid Format");
               	  ok=false;
               	}
                else
                {
                  $("#pswd").text("");
                  ok=true;
                }
                  
                $('input[type="file"]').change(function(event) {
                   maxsize=5;
                   ok=true;
                   var _size = this.files[0].size;
                   var fSExt = new Array('Bytes', 'KB', 'MB', 'GB'),
                   i=0;while(_size>900){_size/=1024;i++;}
                   var exactSize = (Math.round(_size*100)/100)+' '+fSExt[i];
                   var imgsize=(Math.round(maxsize*100)/100)+' '+fSExt[i];
                   alert(imgsize);
                   if(exactSize>imgsize)
                      {
                       $("#imgerror").text("Maximum size of ProfilePic shuld be 5MB");
                  	   ok=false;
                      }
                    else
                      {
                      $("#imgerror").text("");
                      ok=true;
                      }
                    return ok;
                  });
                  var day=$("#day").val();
                  var month=$("#mnth").val();
                  var Year=$("#year").val();
                  dob=month+"/"+day+"/"+Year;
                  var minage=13;
                  var today = new Date();
                  var  dob=new Date(dob);
                  var age = today.getFullYear()-dob.getFullYear();
                  if(day==""||month==""||Year=="")
                    {
                       $("#lbldob").text("Select your date of Birth");
                       ok=false;
                    }
                  else  if(age<minage)
                    {
                       $("#lbldob").text("Minimum age for joining facebook is 13 years");
                       ok=false;
                    }   
                  else
                    {
                        $("#lbldob").text("");
                        ok=true;
                    }
	
                   var gender= $('#gen:checked').val()?true:false;
                   if(gender==false)
                    {
                        $("#Gen").text("Please select your gender");
                        ok=false;
                    }
                   else
                    {
                        $("#Gen").text("");
                        ok=true;
                    }    
           
                   /*
               	var size = file.size;
               	if(size >5120)
               {
                     alert("file size more then 5MB");
                     ok=false;
               }*/
                   return ok;
          
                    });    
	
                  });

   </script>

  <style type="text/css">
         .btn-login
         {
          background-color:#3b5998; 
          margin-top:25px;
          color:white;
         }
         .btn-signup
         {
        background-color:green;
         margin-top:25px;
          color:white;
         }

 
  </style>
  
 </head>
 <body>
	<header class="hidden-xs hidden-sm" style="height: 100px;background-color:#3b5998;">
    <div class="container">
  	  <div class="row">
  	    <div class="col-md-6 col-sm-4" style=" margin-top: 20px;">
           <img src="<c:url value="/images/logo.png" />"/></div>  
  	     <div class="col-md-6">
  	      <div class="row">
  	   	    <form:form action="/Myspring/login" method="post" modelAttribute="loginBean" id="loginform"> 
  	  		   <div class="col-md-5 sm-4" style=" margin-top: 20px;">
  	  				<font size="2"color="white">username</font>
  	  				<input type="text" id="username" name="username">
  	  				<label for=""style="color:red;" id="user"></label>
  	  				<div class="row">
                      <div class="col-md-10" style="color:white;"><input type="checkbox" >Keep me logged in</div>
                    </div>
  	  		   </div>
  	  		   <div class="col-md-5" style=" margin-top: 20px;">
  	  				<font size="2"color="white">Password</font>
  	  				 <input type="password" id="logpass" name="password">
  	  				 <div class="row">
                      <div class="col-md-10" style="color:white"><a href="">Forgotten Password?</a></div>
                    </div>
  	  				 
  	  				<label for=""style="color:red;" id="logpswd"></label>
  	  		   </div>
  	  		   <div class="col-md-2" style=" margin-top: 20px;" >
                 <input type="submit" class="btn btn-primary" id="log" value="Log In" style="background-color:#4e69a2; color:white; margin-top:15px;"></div>
             </form:form>
               </div>
               </div>
               </div>
               </div>
    </header> 
<div class="mobile hidden-md hidden-lg">

  <div class="mobile-header text-center" style="background-color:darkblue;text-align:center;">
    <img src="<c:url value="/images/logo.png" />"/>  
  </div>
  <div class="container text-center" style="background-color:lightgrey;">
    <div class="row">
    <form:form action="Login" method="post">
      <div class="col-xs-12">
     
          <input type="text" placeholder="Email address or phone number" class="form-control">
        </div>
        <div class="col-xs-12">
          <input type="text" placeholder="Password"class="form-control">
    </div>
     <div class="col-xs-12">
      <input type="submit" value="Log in" class="btn btn-default btn-login btn-block" >
    </div>
    <div class="col-xs-12">
      <input type="submit" value="Create New account" class="btn btn-default btn-signup" align="center">
    </div>
    <div class="col-xs-12">
     <h5><font color="white">Forgotten password? Help centre</font>
     </h5>
    </div>
    </form:form>
    </div>
    </div>
   
  <div class="container">
    
  <div class="row">
    <div class="col-xs-6">
      <h5>English(UK)</h5>
      <h5>Hindi</h5>
    </div>

<div class="col-xs-6">
   <h5>Malayalam</h5>
      <h5>More</h5>
    </div>
  </div>
</div>
</div>
<section class="hidden-xs hidden-sm" style="background-color:#dfe3ee;height:700px;">

	<div class="container">
	  <div class="row">
	    <div class="col-md-7">
		   <h3><font color="#3b5998">Facebook help you connect and share <br>with the people in your life</font></h3>
			<img src="<c:url value="/images/connect.png" />"/>
        </div>
        <div class="col-md-5">
        <form:form action="/Myspring/create" method="post" enctype="multipart/form-data"  ModelAttribute="registerbean" id="registerform">
             <h1><b>Create an account</b></h1>
             <h3>its free and always will be</h3>
           <div class="row">
	          <div class="col-md-6">
	              	<input type="text" id="firstname" name="Firstname" class="form-control" placeholder="Firstname">
	                <label for="" style="color:red;"id="fst"></label>
	          </div>
	          <div class="col-md-6">
	                <input type="text" id="lastname" placeholder="Last name" name="Lastname"class="form-control">
	                <label for=""style="color:red;" id="lst"></label>
	          </div>
	          <div class="col-md-12">
	                <input type="text" id="email" placeholder="Email" name="Email"class="form-control">
	                <label for="" style="color:red;"id="el"></label>
	          </div>
	          <div class="col-md-12">
	                <input type="text" id="reemail"placeholder="Re-enter Email" name="Reemail"class="form-control">
	                <label for="" style="color:red;"id="re"></label>
	          </div>
	          <div class="col-md-12">
	                <input type="password" id="Password" placeholder="Password" name="Password"class="form-control">
                    <label for="" style="color:red;"id="pswd"></label>
	            
	           </div>
	           <div class="col-md-12" style="margin-top:12px;">
	            	<input type="file"  name="file" class="btn btn-success"/>
	            	<label for="" style="color:red;"id="imgerror"></label>
	            
	            </div>
	            <div class="col-md-12">
	            <font size="4">Birthday</font>
	           
	            </div>
	            <div class="col-md-12" style="margin-top:5px; size:4px;">
	              <select id="day" name="Day">
                     <option value="">Day</option>
    		<option value="1">1</option>
    		<option value="2">2</option>
    		<option value="3">3</option>
    		<option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
            <option value="13">13</option>
            <option value="14">14</option>
            <option value="15">15</option>
            <option value="16">16</option>
            <option value="17">17</option>
            <option value="18">18</option>
            <option value="19">19</option>
            <option value="20">20</option>
            <option value="21">21</option>
            <option value="22">22</option>
            <option value="23">23</option>
            <option value="24">24</option>
            <option value="25">25</option>
            <option value="26">26</option>
            <option value="27">27</option>
            <option value="28">28</option>
            <option value="29">29</option>
            <option value="30">30</option>
            <option value="31">31</option>
            
    	</select>
    	<select id=mnth name="Month">
        	<option value="">Month</option>
            <option value="01">Jan</option>
            <option value="02">Feb</option>
            <option value="03">Mar</option>
            <option value="04">Apr</option>
            <option value="05">May</option>
            <option value="06">Jun</option>
            <option value="07">Jul</option>
            <option value="08">Aug</option>
            <option value="09">Sep</option>
            <option value="10">Oct</option>
            <option value="11">Nov</option>
            <option value="12">Dec</option>
            
        </select>
        <select id=year name="Year">
        	<option value="">year</option>
    		<option value="2017">2017</option>
    		<option value="2016">2016</option>
    		<option value="2015">2015</option>
    		<option value="2014">2014</option>
    		<option value="2013">2013</option>
    		<option value="2012">2012</option>
    		<option value="2010">2010</option>
    		<option value="2009">2009</option>
    		<option value="2008">2008</option>
    		<option value="2007">2007</option>
    		<option value="2006">2006</option>
    		<option value="2005">2005</option>
    		<option value="2004">2004</option>
    		<option value="2003">2003</option>
    		<option value="2002">2002</option>
    		<option value="2001">2001</option>
    		<option value="2000">2000</option>
    		<option value="1999">1999</option>
    		<option value="1998">1998</option>
    		<option value="1997">1997</option>
    		<option value="1996">1996</option>
    		<option value="1995">1995</option>
    		<option value="1994">1994</option>
    		<option value="1993">1993</option>
    		<option value="1992">1992</option>
    		<option value="1991">1991</option>
    		<option value="1990">1990</option>
    		<option value="1989">1989</option>
    		<option value="1988">1988</option>
    		<option value="1987">1987</option>
    		
         </select>
	              <label for=""style="color:red;" id="lbldob"></label>
	              <font size='2'><a href="">why do I need to provide my date of birth?</a></font><br>
	             </div>
	             
                 <div class="col-md-12" style="margin-top:12px;">
	               <input type="radio" name="Gender" id="gen" value=female>Female
	               <input type="radio" name="Gender" id="gen" value=male>Male
                   <label for="" style="color:red;"id="Gen"></label>
                 </div>
                 <div class="col-md-12" style="margin-top:12px;">
                  <font size="1">By clicking Create an account,you agree to our terms and confirm that you have read our Data Policy,including our Cookie use Policy.
                  You may receive SMS message notification from Facebook and can opt out at any time.<br></font>
                 </div>
                 
                 <div class="col-md-12" style="margin-top:15px;">
                    <input type="submit" value="create an account" id="create" class="btn btn-success">
                 </div>
                 </form:form>
             </div>
            </div>
           </div>
          
   
  <div id="contact"> </div>


</section>
</body>  
</html>