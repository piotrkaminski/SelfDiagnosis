<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="mainTemplate" >
<tiles:putAttribute name="body">
<h1>
    <fmt:message key="symptom.form.title"/>  
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
            <span class="input"><form:input path="description" cssErrorClass="error"/></span>
            <form:errors path="description" cssClass="error"/>
        </div>  
        <div class="form-row">
            <label for="bodyPart"><fmt:message key="form.bodyPart"/>:</label>
            <form:select path="bodyPart" items="${bodyParts}" itemLabel="name" itemValue="id"/>
            <input type="submit" name="_eventId_addNewBodyPart" value="<fmt:message key="symptom.form.addNewBodyPart" /> "/>
            <form:errors path="bodyPart" cssClass="error"/>
        </div>  
        <div class="form-row">
            <label for="symptomType"><fmt:message key="form.symptomType"/>:</label>
            <form:select path="symptomType" items="${symptomTypes}" itemLabel="name" itemValue="id"/>
            <input type="submit" name="_eventId_addNewSymptomType" value="<fmt:message key="symptom.form.addNewSymptomType" /> "/>
            <form:errors path="symptomType" cssClass="error"/>
        </div>  
        <div class="form-row">
            <label for="test"><fmt:message key="form.test"/>:</label>
            <form:select path="test" items="${tests}" itemLabel="name" itemValue="id"/>
            <input type="submit" name="_eventId_addNewTest" value="<fmt:message key="symptom.form.addNewTest" /> "/>
            <form:errors path="test" cssClass="error"/>
        </div>  
        <br> 
        <jsp:include page="buttons.jsp"></jsp:include>
    </fieldset>
</form:form>
</tiles:putAttribute>
</tiles:insertDefinition>