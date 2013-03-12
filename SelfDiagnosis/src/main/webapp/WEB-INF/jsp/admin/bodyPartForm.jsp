<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<h1>
    Enter new Body Part!  
</h1>
<form:form commandName="entity">
    <table>
        <tr>
            <td> Name: </td>
            <td colspan="2"><form:input path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
            <td> Parent Body Part </td>
            <td colspan="2"><form:select path="parentBodyPart" items="${bodyParts}" itemLabel="name" itemValue="id">
            </form:select></td>
        </tr>
        <tr>
            <td><input type="submit" name="_eventId_back" value="Back"/></td>
            <td><input type="submit" name="_eventId_save" value="Save"/></td>
            <td><input type="submit" name="_eventId_saveAndNew" value="Save and New"/></td>
            <td><input type="submit" name="_eventId_saveAndBack" value="Save and Back"/></td>
        </tr>
    </table>
</form:form>
