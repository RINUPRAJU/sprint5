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


<h1>welcome...............</h1>

<style type="text/css">
.image-preview {
  width: 200px;
  height: 200px;
  position: relative;
  overflow: hidden;
  background-color: #000000;
  color: #ecf0f1;
}
input[type="file"] {
    line-height: 200px;
    font-size: 200px;
    position: absolute;
    opacity: 0;
    z-index: 10;
}
  label {
    position: absolute;
    z-index: 5;
    opacity: 0.7;
    cursor: pointer;
    background-color: #bdc3c7;
    width: 200px;
    height: 50px;
    font-size: 20px;
    line-height: 50px;
    text-transform: uppercase;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    margin: auto;
    text-align: center;
  }

</style>

<script type="text/javascript">
$(document).ready(function() {

    $("image-preview").each(
        function(){
                $.uploadPreview({
                    input_field: $(this).find(".image-upload"),
                    preview_box: this,
                    label_field: $(this).find(".image-label")
                });
        }
    );
});
</script>
<!--| catatan penting: yang penting action="" & input type="file" name="image" |-->
<form action="upload.php" method="POST" enctype="multipart/form-data">
    <div class="image-preview">
        <label for="image-upload" class="image-label">+ GAMBAR</label>
        <input type="file" name="my_field[]" class="image-upload" />
    </div>
    <div class="image-preview">
        <label for="image-upload" class="image-label">+ GAMBAR</label>
        <input type="file" name="my_field[]" class="image-upload" />
    </div>
    <input type="submit"/>
</form>


<%-- ${error}
<form:form name="submitForm" action="submit" method="POST">
<div align="center">
<table>
<tr>
<td>user name</td>
<td><input type="text" name="username" /></td>
</tr>
<tr>
<td>Password</td>
<td><input type="text" name="password" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="submit" /></td>
</tr>
</table>
<div style="color=red">${error }</div>
</div>
</form:form> --%>
</body>
</html>