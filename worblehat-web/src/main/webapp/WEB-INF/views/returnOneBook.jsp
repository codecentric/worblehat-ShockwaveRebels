<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<title>Return One book - Worblehat Bookmanager</title>
</head>
<body>
	<h1>Return One book</h1>

	<form:form commandName="returnOneBookFormData" method="POST">
            ISBN/Title:<form:input id="isbn_title" path="isbn_title" />
		<form:errors path="isbn_title" />
		<br />
            Email:<form:input id="email" path="email" />
		<form:errors path="email" />
		<br />
		<input type="submit" id="returnBook" value="Return Book" />
		<hr />
		<a href="<spring:url value="/" htmlEscape="true" />">Back to Home</a>
	</form:form>


</body>
</html>
