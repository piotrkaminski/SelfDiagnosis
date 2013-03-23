<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="mainTemplate" >
<tiles:putAttribute name="body">
<h1>
    <fmt:message key="symptomType.form.title"/>  
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
        <br> 
        <jsp:include page="buttons.jsp"></jsp:include>
    </fieldset>
</form:form>
</tiles:putAttribute>
</tiles:insertDefinition>