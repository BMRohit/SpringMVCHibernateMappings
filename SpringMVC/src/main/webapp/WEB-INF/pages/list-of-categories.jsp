<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of products</title>
</head>
<body>
<h1>List of categories</h1>
<p>You can edit/delete the categories.</p>
<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="40%">Category Name</th><th width="20%">description</th><th width="30%">actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="category" items="${categories}">
<tr>
	<td>${category.categoryName}</td>
	<td>${category.categoryDescription}</td>
	<td>
	<a href="">Edit</a><br/>
	<a href="${pageContext.request.contextPath}/category/delete/${category.categoryID}.html">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>