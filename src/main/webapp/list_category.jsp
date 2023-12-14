<%@ page import="web.website.entity.Category" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*" %>
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
                <h1 class="h3 mb-2 text-gray-800">Category</h1>
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <a data-toggle="modal" data-target="#addCategory" class="btn btn-primary">Thêm mới</a>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Hành Động</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach var="item" items="${categories}">
                                    <tr>
                                        <td>${item.id}</td>
                                        <td>${item.name}</td>
                                        <td>
                                            <a class="btn btn-primary edit-brand" data-id="${item.id}">Sửa</a>
                                            <a class="btn btn-danger delete-brand" data-id="${item.id}">Xóa</a>

                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>


            <jsp:include page="layout/footer.jsp"/>
        </div>

        <div class="modal fade" id="addCategory" tabindex="-1" role="dialog" aria-labelledby="addCategoryLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addCategoryLabel">
                            Thêm mới danh mục
                        </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="category" method="post">
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">Tên danh mục:</label>
                                <input type="text" class="form-control" id="recipient-name" name="name">
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                            <button type="submit" class="btn btn-primary">Thêm mới</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
        <div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="addCategoryLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="editCategory">
                            Sửa danh mục
                        </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="category" method="post">
                        <input type="hidden" name="id" id="id">
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">Tên danh mục:</label>
                                <input type="text" class="form-control" name="name" id="name">
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                            <button type="submit" class="btn btn-primary">Thêm mới</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</body>
<jsp:include page="layout/script.jsp"/>

<script>
    $(document).ready(function () {

    });
</script>

</html>
