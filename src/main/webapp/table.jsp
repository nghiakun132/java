<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <jsp:include page="layout/style.jsp"/>
</head>
<body id="page-top">
<div id="wrapper">
    <jsp:include page="layout/navbar.jsp"/>

    <div id="content-wrapper" class="d-flex flex-column">
        <div id="content">
            <jsp:include page="layout/header.jsp"/>
            <div class="container-fluid">
                <ul class="list-group">
                    <c:forEach var="item" items="[1,2,3,4,5]">
                        <li class="list-group-item">${item}</li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <jsp:include page="layout/footer.jsp"/>
    </div>
</body>

<jsp:include page="layout/script.jsp"/>
</html>
