<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<title>Worblehat Bookmanager</title>
</head>
<body>
	<h1 id="welcome_heading">Worblehat Bookmanager - <spring:message code="versionsnummer"></spring:message></h1>

<ul>
<li><a href="<spring:url value="/bookList" htmlEscape="true" />">Show all Books</a></li>
  <li><a href="<spring:url value="/insertBooks" htmlEscape="true" />">Add a new book</a></li>
   <li><a href="<spring:url value="/borrow" htmlEscape="true" />">Borrow Book</a></li>
   <li><a id="returnAllBooks" href="<spring:url value="/returnAllBooks" htmlEscape="true" />">Return all Books</a></li>
   <li><a id="returnOneBook" href="<spring:url value="/returnOneBook" htmlEscape="true" />">Return one Book</a></li>
   <li><a href="<spring:url value="/myBooks" htmlEscape="true" />">Show Books by mail</a></li>
   <li><a href="<spring:url value="/deleteBook" htmlEscape="true" />">Delete one Book from Store</a></li>
</ul>

</body>
</html>
