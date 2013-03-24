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
            <span class="input"><form:textarea path="description" cssErrorClass="error" rows="15" cols="70" /></span>
            <form:errors path="description" cssClass="error"/>
        </div>  
        <div class="form-row">
            <label for="frequency"><fmt:message key="form.frequency"/>:</label>
            <span class="input"><form:input path="frequency" cssErrorClass="error"/></span>
            <form:errors path="frequency" cssClass="error"/>
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
	                <span class="input"><form:input path="diseaseSymptom.rank" cssErrorClass="error"/></span>
	            </td>
	            <td>
	                <span class="input"><form:input path="diseaseSymptom.frequency" cssErrorClass="error"/></span>
	            </td>
	            <td>
	                <input type="submit" name="_eventId_addNewDiseaseSymptom" value="<fmt:message key="disease.form.addNewDiseaseSymptom"/>" />
	            </td>
	        </tr>
	        <tr>
	            <td/>
	            <td><form:errors path="diseaseSymptom.symptom" cssClass="error" /></td>
	            <td><form:errors path="diseaseSymptom.rank" cssClass="error"/></td>
	            <td><form:errors path="diseaseSymptom.frequency" cssClass="error"/></td>
	        </tr>
	        <tr>
	            <td/>
	            <td><input type="image" name="_eventId_addNewSymptom" src="/images/button_add.jpg"/></td>
	            <!--value="<fmt:message key="disease.form.addNewSymptom" /> "/></td> -->
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
    <thead>
        <tr>
            <td><fmt:message key="form.id" /> </td>
            <td><fmt:message key="form.symptom" /> </td>
            <td><fmt:message key="form.rank" /></td>
            <td><fmt:message key="form.frequency" /></td>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="diseaseSymptom" items="${diseaseSymptoms}" varStatus="counter">
        <tr>
            <td>${counter.index}</td>
            <td>${diseaseSymptom.symptom.name}</td>
            <td>${diseaseSymptom.rank}</td>
            <td>${diseaseSymptom.frequency}</td>
            
            <td><a href="${flowExecutionUrl}&_eventId=deleteDiseaseSymptom&diseaseSymptom=${diseaseSymptom}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
    
</form:form>
</tiles:putAttribute>
</tiles:insertDefinition>