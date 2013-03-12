<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="mainTemplate" >
<tiles:putAttribute name="body">

<h1><fmt:message key="index.title"/></h1>

<p><fmt:message key="index.message"/></p>
</tiles:putAttribute>
</tiles:insertDefinition>
