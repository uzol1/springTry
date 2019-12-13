
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.12.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.js"></script>

<title>Home</title>
</head>
<body> 
	<p>Welcome:${user}</p>

	<table id="myTable" class="table table-stripted">
		<thead>
			<tr class="success">
				<td>FirstName</td>
				<td>LastName</td>
				<td>Country</td>
				<td>gender</td>
			</tr>
		<tbody>
			<c:forEach var="student" items="${slist}">
				<tr class="danger">
					<td>${student.fname}</td>
					<td>${student.lname}</td>
					<td>${student.address.country}</td>
					<td>${student.gender}</td>
					<td><input type="button" class="btn btn-success"
						onclick="editStudent(${student.id})" value="edit"> <input
						type="button" class="btn btn-danger"
						onClick="deleteStudent(${student.id})" value="delete"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<script type="text/javascript">
	function editStudent(id){
			window.location="${pageContext.request.contextPath}/"+id+"/edit";
	}
	function deleteStudent(id){
	var msg=confirm("do you want to delete?");
	if (msg==true){
		window.location="${pageContext.request.contextPath}/"+id+"/delete";
	}
	
	}
	$(document).ready( function () {
	    $('#myTable').DataTable();
	} );
	</script>
</body>
</html>
