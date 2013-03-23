<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="side-bar">
    <a href="<c:url value="/"/>"><fmt:message key="menu.home"/></a>
    
    <p><fmt:message key="menu.disease"/></p>
    <a href="<c:url value="/disease.html"/>"><fmt:message key="menu.newDisease"/></a> 
    <a href="<c:url value="/diseaseList.html"/>"><fmt:message key="menu.diseaseList"/></a>

    <p><fmt:message key="menu.symptom"/></p>
    <a href="<c:url value="/symptom.html"/>"><fmt:message key="menu.newSymptom"/></a> 
    <a href="<c:url value="/symptomList.html"/>"><fmt:message key="menu.symptomList"/></a>

    <p><fmt:message key="menu.symptomType"/></p>
    <a href="<c:url value="/symptomType.html"/>"><fmt:message key="menu.newSymptomType"/></a> 
    <a href="<c:url value="/symptomTypeList.html"/>"><fmt:message key="menu.symptomTypeList"/></a>

    <p><fmt:message key="menu.bodyPart"/></p>
    <a href="<c:url value="/bodyPart.html"/>"><fmt:message key="menu.newBodyPart"/></a> 
    <a href="<c:url value="/bodyPartList.html"/>"><fmt:message key="menu.bodyPartList"/></a>

    <p><fmt:message key="menu.test"/></p>
    <a href="<c:url value="/test.html"/>"><fmt:message key="menu.newTest"/></a> 
    <a href="<c:url value="/testList.html"/>"><fmt:message key="menu.testList"/></a>

    <p><fmt:message key="menu.testType"/></p>
    <a href="<c:url value="/testType.html"/>"><fmt:message key="menu.newTestType"/></a> 
    <a href="<c:url value="/testTypeList.html"/>"><fmt:message key="menu.testTypeList"/></a>

</div>
