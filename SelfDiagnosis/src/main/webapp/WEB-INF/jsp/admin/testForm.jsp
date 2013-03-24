<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="mainTemplate" >
<tiles:putAttribute name="body">
<h1>
    <fmt:message key="test.form.title"/>  
</h1>
<form:form commandName="entity">
    <form:hidden path="id" />

    <fieldset>
        <div id="messages" class="success">
            <c:if test="${not empty statusMessageKey}">
               <p><fmt:message key="${statusMessageKey}"/></p>
            </c:if>
        </div>
        <div class="form-row">
            <label for="name"><fmt:message key="form.name"/>:</label>
            <span class="input"><form:input path="name" cssErrorClass="error"/></span>
            <form:errors path="name" cssClass="error"/>
        </div>  
        <div class="form-row">
            <label for="description"><fmt:message key="form.description"/>:</label>
            <span class="input"><form:textarea path="description" cssErrorClass="error" rows="10" cols="70" /></span>
            <form:errors path="description" cssClass="error"/>
        </div>
        <div class="form-row">
            <label for="testType"><fmt:message key="form.testType"/>:</label>
            <form:select path="testType" items="${testTypes}" itemLabel="name" itemValue="id"/>
            <input type="submit" name="_eventId_addNewTestType" value="<fmt:message key="test.form.addNewTestType" /> "/>
            <form:errors path="testType" cssClass="error"/>
        </div>  
        <div class="form-row">
            <label for="validForDays"><fmt:message key="form.validForDays"/>:</label>
            <span class="input"><form:input path="validForDays" cssErrorClass="error"/></span>
            <form:errors path="validForDays" cssClass="error"/>
        </div>
          
        <br> 
        <jsp:include page="buttons.jsp"></jsp:include>
    </fieldset>
</form:form>
</tiles:putAttribute>
</tiles:insertDefinition>