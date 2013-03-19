<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
	<title>Show Books</title>
</head>
<body>

<form:form commandName="mailFormData" method="POST">
            Email:<form:input id="email" path="email"/>
		<input type="submit" id="showBooks" value="Show Books" />
		<hr/>
	</form:form>
	<table>
	<thead>  
		<tr>
			<th>Return-Date</th>
			<th>Title</th>
			<th>ISBN</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${books}" var="book">
		<tr>
			<td>${book.currentBorrowing.returnDate}</td>
			<td>${book.title}</td>
			<td>${book.isbn}</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<hr />
	<a href="<spring:url value="/" htmlEscape="true" />">Back to Home</a>
</body>
</html>