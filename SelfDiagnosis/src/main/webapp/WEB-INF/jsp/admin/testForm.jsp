<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Test</title>
</head>
<body>
<h1>
    Enter new Test!  
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
            <td> Test type: </td>
            <td>
                <form:select path="testType" items="${testTypes}" itemLabel="name" itemValue="id"/>
            </td>
            <td><input type="submit" name="_eventId_addNewTestType" value="Add New Test Type"/></td>
        </tr>
        <tr>
            <td> Valid for days: </td>
            <td><form:input path="validForDays"/></td>
            <td><form:errors path="validForDays"/></td>
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