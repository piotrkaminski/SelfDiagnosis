<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Disease</title>
</head>
<body>
<h1>
    Enter new Disease!  
</h1>
<form:form commandName="entity">
    <table>
        <tr>
            <td> Name: </td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
            <td> Description: </td>
            <td><form:input path="description"/></td>
            <td><form:errors path="description"/></td>
        </tr>
        <tr>
            <td> Frequency: </td>
            <td><form:input path="frequency"/></td>
            <td><form:errors path="frequency"/></td>
        </tr>
    <c:forEach var="diseaseSymptom" items="${diseaseSymptoms}" varStatus="counter">
        <tr>
            <td>${counter}</td>
	        <td>${diseaseSymptom.symptom.name}</td>
            <td><a href="${flowExecutionUrl}&_eventId=deleteDiseaseSymptom&diseaseSymptom=${diseaseSymptom}">Delete</a></td>
        </tr>
    </c:forEach>
        
        <tr>
            <td></td>
            <td> Symptom: </td>
        </tr>
        <tr>
            <td> New Disease Symptom: </td>
            <td>
                <form:select path="symptom" items="${symptoms}" itemLabel="name" itemValue="id"/>
            </td>
            <td>
                <input type="submit" name="_eventId_addNewDiseaseSymptom" value="Add New Disease Symptom"/>
            </td>
        </tr>
        <tr>
            <td/>
            <td><input type="submit" name="_eventId_addNewSymptom" value="Add New Symptom"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="_eventId_back" value="Back"/></td>
            <td><input type="submit" name="_eventId_save" value="Save"/></td>
            <td><input type="submit" name="_eventId_saveAndNew" value="Save and New"/></td>
            <td><input type="submit" name="_eventId_saveAndBack" value="Save and Back"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>