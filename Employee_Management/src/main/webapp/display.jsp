

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<tr>
<th>ID</th>
<th>NAME</th>
<th>PHONE NUMBER</th>
</tr>
<tr>
<td>${employee.getId() }</td>
<td>${employee.getName() }</td>
<td>${employee.getPhone() }</td>

</tr>

</table>

<br><br>
<button> 
<a href="index.jsp"> HOME</a>
</button>


</body>
</html>