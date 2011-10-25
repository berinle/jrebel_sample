<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Foggy | Home</title>
    <script type="text/javascript" src='<c:url value="/resources/js/sample.js"/>'></script>
</head>
<body>
<ul>
<c:forEach items="${bubbles}" var="bubble">
    <li><c:out value="${bubble.name}"/></li>
</c:forEach>
</ul>

<a href="#" onclick="foo();">foo</a>

</body>
</html>