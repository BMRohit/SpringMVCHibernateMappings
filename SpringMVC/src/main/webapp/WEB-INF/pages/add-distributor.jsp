<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Distributor</title>
</head>
<body>
	<form:form method="POST" commandName="distributor"
		action="${pageContext.request.contextPath}/product/addDistributor.html">

		<table>
			<tbody>
				<tr>
					<td>Distributor Name :</td>
					<td><form:input path="distributorName" /></td>
				</tr>
				<tr>
					<td>Contact Number :</td>
					<td><form:input path="distributorNumber" /></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><form:input path="distributorEmail" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Add" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Select Products :</td>
					<td>
					<%-- <form:select path="products">
							<form:options items="${products}" itemValue="idAsString" multiple="true" />
						</form:select> --%>
						<form:checkboxes items="${products}" path="distributorProducts" itemValue="idAsString" multiple="true" itemLabel="productName"/>
					</td>
				</tr>
			</tbody>
		</table>



	</form:form>
</body>
</html>