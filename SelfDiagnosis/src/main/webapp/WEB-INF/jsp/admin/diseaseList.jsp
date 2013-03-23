<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="mainTemplate" >
    <tiles:putAttribute name="body">

<h1>
    <fmt:message key="disease.list.title"/>  
</h1>
    <table class="search">
	    <thead>
	        <tr>
	            <td><fmt:message key="form.id" /> </td>
	            <td><fmt:message key="form.name" /> </td>
	            <td><fmt:message key="form.description" /></td>
	            <td><fmt:message key="form.frequency" /></td>
	            <td><fmt:message key="button.edit"/></td>
	            <td><fmt:message key="button.delete"/></td>
	        </tr>
	    </thead>
    <tbody>
	    <c:forEach var="disease" items="${diseases}" varStatus="counter">
	        <tr>
	            <td>${disease.id}</td>
	            <td>${disease.name}</td>
	            <td>${disease.description}</td>
	            <td>${disease.frequency}</td>
	            <td><a href="${flowExecutionUrl}&_eventId=editEntity&entity=${disease}"><fmt:message key="button.edit"/></a>
	            </td>
	            <td>
    	            <sec:authorize ifAllGranted="ROLE_ADMINISTRATOR">
                        <a href="${flowExecutionUrl}&_eventId=deleteEntity&entity=${disease}"><fmt:message key="button.delete"/></a> 
                    </sec:authorize>
                </td>
	        </tr>
	    </c:forEach>
    </tbody>
    </table>
</tiles:putAttribute>
</tiles:insertDefinition>