<%@ page import="web.website.entity.Category" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <jsp:include page="../../layout/style.jsp"/>
</head>
<body id="page-top">
<div id="wrapper">
    <jsp:include page="../../layout/navbar.jsp"/>

    <div id="content-wrapper" class="d-flex flex-column">
        <div id="content">
            <jsp:include page="../../layout/header.jsp"/>
            <div class="container-fluid page-container">
                <h1 class="h3 mb-2 text-gray-800">Sửa danh mục</h1>
                <div class="card shadow mb-4">
                    <div class="card-body">
                        <form method="post" action="edit-category">
                            <input type="hidden" name="id" value="${category.id}"/>
                            <div class="form-group">
                                <label for="name">Category Name</label>
                                <input type="text" class="form-control" id="name" name="name" value="${category.name}"
                                       required>
                            </div>

                            <button type="submit" class="btn btn-primary">Sửa</button>
                        </form>
                    </div>
                </div>
            </div>

            <jsp:include page="../../layout/footer.jsp"/>
        </div>


    </div>
</body>
<jsp:include page="../../layout/script.jsp"/>

</html>
