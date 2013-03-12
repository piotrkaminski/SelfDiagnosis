<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div align="right">
    <div>
        <fmt:message key="locale.language"/>:
            
            <c:url var="englishLocaleUrl" value="${urlBase}">
                <c:param name="locale" value="en" />
            </c:url>
            <c:url var="polishLocaleUrl" value="${urlBase}">
                <c:param name="locale" value="pl" />
            </c:url>
        
            <a href='<c:out value="${englishLocaleUrl}"/>'><fmt:message key="locale.english"/></a>
            <a href='<c:out value="${polishLocaleUrl}"/>'><fmt:message key="locale.polish" /></a>
    </div>
    
    <div>&nbsp;</div>
    
    <div><fmt:message key="site.footer"/></div>
</div>