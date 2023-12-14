<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
                list user
            </div>
        </div>

        <jsp:include page="layout/footer.jsp"/>
    </div>
</body>

<jsp:include page="layout/script.jsp"/>
</html>
