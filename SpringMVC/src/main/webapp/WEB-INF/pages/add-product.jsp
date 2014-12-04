<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<form:form method="POST" commandName="product"
		action="${pageContext.request.contextPath}/product/addproduct.html">

		<table>
			<tbody>
				<tr>
					<td>Product Name :</td>
					<td><form:input path="productName" /></td>
				</tr>
				<tr>
					<td>Price :</td>
					<td><form:input path="price" /></td>
				</tr>
				<tr>
					<td>Category :</td>
					<td>
						<form:select path="category" >
							<form:options items="${categoryList}" itemValue="idAsString" itemLabel="categoryName" />
						</form:select> 
					</td>
				</tr>
				
				<tr>
					<td>Brand Name :</td>
					<td><form:input path="brandInfo.brandName" /></td>
				</tr>
				<tr>
					<td>Contact Number :</td>
					<td><form:input path="brandInfo.contactNumber" /></td>
				</tr>
				<tr>
					<td>Contact Email :</td>
					<td><form:input path="brandInfo.email" /></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Add" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>



	</form:form>
</body>
</html>