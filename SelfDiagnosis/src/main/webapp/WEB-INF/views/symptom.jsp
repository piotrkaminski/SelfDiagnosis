<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Edit Symptom</title>
</head>
<body>
<h1>
	Enter new Symptom!  
</h1>
<form:form commandName="symptom">
	<table>
		<tr>
			<td><form:input path="name"/></td>
			<td><form:errors path="name"/></td>
		</tr>
		<tr>
			<td><form:input path="description"/></td>
			<td><form:errors path="description"/></td>
		</tr>
		<tr>
			<td>
				<form:select path="bodyPart" items="${bodyParts}" itemLabel="name" itemValue="id"/>
			</td>
            <c:url var="newBodyPart" value="/bodyPart.html"/>
		</tr>
		<tr>
			<td><input type="submit" value="Save"/></td>
		</tr>
	</table>
</form:form>
</body>
</html>