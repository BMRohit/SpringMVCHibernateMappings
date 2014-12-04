<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Category</title>
</head>
<body>
<form:form method="POST" commandName="category" action="${pageContext.request.contextPath}/category/addcategory.html">

<table>
<tbody>
	<tr>
		<td>Category Name :</td>
		<td><form:input path="categoryName" /></td>
	</tr>
	<tr>
		<td>Category Description :</td>
		<td><form:input path="categoryDescription" /></td>
	</tr>
	<tr>
		<td><input type="submit" value="Add Category" /></td>
		<td></td>
	</tr>
</tbody>
</table>



</form:form>
</body>
</html>