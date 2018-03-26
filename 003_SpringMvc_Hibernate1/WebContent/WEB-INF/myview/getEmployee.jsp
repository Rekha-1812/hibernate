<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view all employee</title>
</head>
<body>
  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th></tr>  

   <c:forEach var="emp" items="${allEmployees}">   
   <c:url var="delete" value="deleteEmployee.html">
				<c:param name="employeeId" value="${emp.id}"></c:param>
			</c:url>

			<c:url var="update" value="updateEmployee.html">
				<c:param name="employeeId" value="${emp.id}"></c:param>
			</c:url>
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.employeeName}</td>  
   <td>${emp.employeeSalary}</td>  
   <td>${emp.employeeDesignation}</td>  
   <td><a href="${delete}">Delete</a></td>
   <td><a href="${update}">Update</a></td>
   </tr>  
   </c:forEach>  
   </table> 
   <a href="empform.html">Add Employee</a>  
<a href="viewEmployee.html">View Employee</a>
</body>
</html>