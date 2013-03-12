<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="mainTemplate" >
    <tiles:putAttribute name="body">

<h1>
    <fmt:message key="disease.form.title"/>  
</h1>

<div id="messages">
    <c:if test="${not empty statusMessageKey}">
       <p><fmt:message key="${statusMessageKey}"/></p>
    </c:if>
</div>

<form:form commandName="entity">
    <form:hidden path="id" />

    <fieldset>
        <div class="form-row">
            <label for="name"><fmt:message key="form.name"/>:</label>
            <span class="input"><form:input path="name" /></span>
            <form:errors path="name"/>
        </div>  
        <div class="form-row">
            <label for="description"><fmt:message key="form.description"/>:</label>
            <span class="input"><form:input path="description" /></span>
            <form:errors path="description"/>
        </div>  
        <div class="form-row">
            <label for="frequency"><fmt:message key="form.frequency"/>:</label>
            <span class="input"><form:input path="frequency" /></span>
            <form:errors path="frequency"/>
        </div>  
        <div class="form-row">
        
	    <table>    
	        <tr>
	            <td/>
	            <td><label for="diseaseSymptom.symptom"><fmt:message key="form.symptom"/></label></td>
	            <td><label for="diseaseSymptom.rank"><fmt:message key="form.rank"/></label></td>
	            <td><label for="diseaseSymptom.frequency"><fmt:message key="form.frequency"/></label></td>
	        </tr>
	        <tr>
	            <td><label><fmt:message key="disease.form.newDiseaseSymptom"/>:</label></td>
	            <td>
	                <span class="input"><form:select path="diseaseSymptom.symptom" items="${symptoms}" itemLabel="name" itemValue="id"/></span>
	            </td>
	            <td>
	                <span class="input"><form:input path="diseaseSymptom.rank"/></span>
	            </td>
	            <td>
	                <span class="input"><form:input path="diseaseSymptom.frequency"/></span>
	            </td>
	            <td>
	                <input type="submit" name="_eventId_addNewDiseaseSymptom" value="<fmt:message key="disease.form.addNewDiseaseSymptom"/>" />
	            </td>
	        </tr>
	        <tr>
	            <td/>
	            <td><form:errors path="diseaseSymptom.symptom"/></td>
	            <td><form:errors path="diseaseSymptom.rank"/></td>
	            <td><form:errors path="diseaseSymptom.frequency"/></td>
	        </tr>
	        <tr>
	            <td/>
	            <td><input type="submit" name="_eventId_addNewSymptom" value="<fmt:message key="disease.form.addNewSymptom" /> "/></td>
	        </tr>
	    </table>
	    </div> 
	    <br> 
        <jsp:include page="buttons.jsp"></jsp:include>
    </fieldset> 
    <h2>
        <fmt:message key="disease.form.diseaseSymptomList" /> :  
    </h2>
    <table class="search">
        <tr>
            <td><fmt:message key="form.id" /> </td>
            <td><fmt:message key="form.symptom" /> </td>
            <td><fmt:message key="form.rank" /></td>
            <td><fmt:message key="form.frequency" /></td>
        </tr>
    <c:forEach var="diseaseSymptom" items="${diseaseSymptoms}" varStatus="counter">
        <tr>
            <td>${counter.index}</td>
            <td>${diseaseSymptom.symptom.name}</td>
            <td>${diseaseSymptom.rank}</td>
            <td>${diseaseSymptom.frequency}</td>
            
            <td><a href="${flowExecutionUrl}&_eventId=deleteDiseaseSymptom&diseaseSymptom=${diseaseSymptom}">Delete</a></td>
        </tr>
        <tr/>
    </c:forEach>
    </table>
    
</form:form>
</tiles:putAttribute>
</tiles:insertDefinition>