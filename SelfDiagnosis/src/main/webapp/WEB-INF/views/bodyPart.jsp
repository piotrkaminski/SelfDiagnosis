<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Edit Body part</title>
</head>
<body>
<h1>
	Enter new Body Part!  
</h1>
<form:form commandName="bodyPart">
	<table>
		<tr>
			<td><form:input path="name"/></td>
			<td><form:errors path="name"/></td>
		</tr>
		<tr>
			<td><form:select path="parentBodyPart" items="${bodyParts}" itemLabel="name" itemValue="id">
			</form:select></td>
		</tr>
		<tr>
			<td><input type="submit" value="Save"/></td>
		</tr>
	</table>
</form:form>
</body>
</html>