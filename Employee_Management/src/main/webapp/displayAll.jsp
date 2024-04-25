<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border= 2px>
<thead>
<tr>

<th>ID</th>
<th>NAME</th>
<th>DESIGNATION</th>
<th>PHONE NUMBER</th>

</tr>
</thead>
<tbody>
<c:forEach items="${employeelist}" var= "employee" >
<tr>
	<td>${employee.getId()}</td>
	<td>${employee.getName()}</td>
	<td>${employee.getDesignation()}</td>
	<td>${employee.getPhone()}</td>

</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>