<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="side-bar">
    <a href="<c:url value="/"/>"><fmt:message key="menu.home"/></a>
    
    <p><fmt:message key="menu.disease"/></p>
    <a href="<c:url value="/disease.html"/>"><fmt:message key="menu.newDisease"/></a> 
    <a href="<c:url value="/diseaseList.html"/>"><fmt:message key="menu.diseaseList"/></a>
</div>
