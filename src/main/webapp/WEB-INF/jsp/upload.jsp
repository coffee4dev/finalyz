<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>File Uploaded</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<form action="fup" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="fInput">Upload a csv file</label>
			<input type="file" name="file" id="fInput" />
		</div>
		<button type="submit" class="btn btn-default">Up!</button>
	</form>
	<c:if test="${!empty expenses}">
	<table class="table table-striped">
		<c:forEach items="${expenses}" var="ex">
			<tr>
				<td>${ex.date}</td>
				<td>${ex.amount}</td>
				<td>${ex.currency}</td>
				<td><c:forEach items="${ex.tags}" var="tag"><mark>${tag.name}</mark> </c:forEach></td>
				<td>${ex.description}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
</div>
</body>
</html>