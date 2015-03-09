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
<%-- 	<p>${fcontent}</p> --%>
</div>
</body>
</html>