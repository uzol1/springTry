<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Student Form</h1>
 <spring:form action="student" method="post" modelAttribute="smodel">
  
     <table>
     	<tr>
     		<td>FirstName :</td>
     		<td> <spring:input path="fname"/></td>
     	</tr>
     	<tr>
     		<td>LastName :</td>
     		<td> <spring:input path="lname"/></td>
     	</tr>
     	<tr>
     		<td>Gender :</td>
     		<td> <spring:radiobutton path="gender" value="male"/>Male </td>
     		<td> <spring:radiobutton path="gender" value="female"/>Female</td>
     	</tr>
     	<tr>
     		<td>Country :</td>
     		<td> <spring:input path="address.country"/></td>
     	</tr>
     	<tr>
     		<td>State :</td>
     		<td> <spring:select path="address.state">
     		     <spring:option value="">-----select state-----</spring:option>
     		      <spring:option value="state-1">state-1</spring:option>
     		       <spring:option value="state-2">state-2</spring:option>
     		        <spring:option value="state-3">state-3</spring:option>
     		         <spring:option value="state-4">state-4</spring:option>
     		          <spring:option value="state-5">state-5</spring:option>
     		</spring:select></td>
     	</tr>
     	<tr>
     		<td>City :</td>
     		<td> <spring:input path="address.city"/></td>
     	</tr>
     	<tr>
     		<td>Zip :</td>
     		<td> <spring:input path="address.zip"/></td>
     	</tr>
     	<tr>
     		
     		<td> <input type="submit" value="save"/></td>
     	</tr>
     </table>
    </spring:form>

</body>
</html>