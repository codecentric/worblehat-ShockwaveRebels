<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
	<title>Delete one Book</title>
</head>
<body>
	<table>
	<thead>  
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>Year</th>
			<th>Edition</th>
			<th>ISBN</th>
			<th>Borrower</th>
			<th>Description</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${books}" var="book">
		<tr>
			<td>${book.title}</td>
			<td>${book.author}</td>
			<td>${book.year}</td>
			<td>${book.edition}</td>
			<td>${book.isbn}</td>
			<td>${book.currentBorrowing.borrowerEmailAddress}</td>
			<td>${book.description}</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<hr />
	
	<form:form commandName="deleteBookFormData" method="POST">
            Title:       <form:input id="title" path="title" />
		<form:errors path="title" />
		<br />
            Edition:     <form:input id="edition" path="edition" />
		<form:errors path="edition" />
		<br />
            ISBN:        <form:input id="isbn" path="isbn" />
		<form:errors path="isbn" />
		<br />
		<input type="submit" id="deleteBook" value="Delete Book" />
		<hr/>
	</form:form>
	
	
	<hr />
	<a href="<spring:url value="/" htmlEscape="true" />">Back to Home</a>
</body>
</html>