<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<style>
h2 {
	text-align: center;
	color: white;
}
</style>
</head>
<body>
	<div class='container'>
		<br>
		<h2 style="background-color: blue;">Registered Students List</h2>


		<!-- Add a button -->
		<a href="/add" class="btn btn-primary btn-sm mb-3"> Add Student </a>


		<table class="table table-bordered table-striped">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>DEPARTMENT</th>
				<th>COUNTRY</th>
				<th>ACTION</th>

			</tr>
			<c:forEach items="${Student}" var="student">
				<tr>
					<td>${student.studentid }</td>
					<td>${student.name }</td>
					<td>${student.department }</td>
					<td>${student.country }</td>
					<td>
						<!-- Add "update" button/link --> <a
						href="/update?studentId=${student.studentid}"
						class="btn btn-info btn-sm"> Update </a> <a
						href="/delete?studentId=${student.studentid}"
						class="btn btn-danger btn-sm"
						onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
							Delete </a>
					</td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>