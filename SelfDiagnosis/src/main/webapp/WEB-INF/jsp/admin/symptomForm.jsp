<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="mainTemplate" >
<tiles:putAttribute name="body">
<h1>
    Enter new Symptom!  
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
            <td> Body part: </td>
            <td>
                <form:select path="bodyPart" items="${bodyParts}" itemLabel="name" itemValue="id"/>
            </td>
            <td><input type="submit" name="_eventId_addNewBodyPart" value="Add New Body part"/></td>
        </tr>
        <tr>
            <td> Symptom Type: </td>
            <td>
                <form:select path="symptomType" items="${symptomTypes}" itemLabel="name" itemValue="id"/>
            </td>
            <td><input type="submit" name="_eventId_addNewSymptomType" value="Add New Symptom Type"/></td>
        </tr>
        <tr>
            <td> Test: </td>
            <td>
                <form:select path="test" items="${tests}" itemLabel="name" itemValue="id"/>
            </td>
            <td><input type="submit" name="_eventId_addNewTest" value="Add New Test"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="_eventId_back" value="Back"/></td>
            <td><input type="submit" name="_eventId_save" value="Save"/></td>
            <td><input type="submit" name="_eventId_saveAndNew" value="Save and New"/></td>
            <td><input type="submit" name="_eventId_saveAndBack" value="Save and Back"/></td>
        </tr>
    </table>
</form:form>
</tiles:putAttribute>
</tiles:insertDefinition>