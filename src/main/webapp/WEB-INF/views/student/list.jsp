<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 29/11/2024
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- Option 1: Include in HTML -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
</head>
<body>
<%--JSP:include--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">CodeGym</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/students">Student</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/teachers">Teacher</a>
                </li>

            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="container mt-5">
    <button class="btn btn-primary" type="button" onclick="window.location.href='/students?action=add'">Create</button>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Email</th>
            <th>Point</th>
            <th>DOB</th>
            <th>Class</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%--        for(Student student: students)--%>
        <c:forEach var="student" items="${students}" varStatus="c">
            <tr>
                <td>${c.count}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.point}</td>
                <td>${student.dob}</td>
                <td>${student.idClass}</td>

                <td>
                    <button class="btn btn-warning">Update</button>
                    <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal${student.id}">Remove</button>

                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal${student.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Delete student</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    Do you want to delete this student has name is ${student.name}?
                                    <div style="color: red; font-style: italic">
                                        This action cannot be undone!
                                    </div>
                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                    <button type="button" class="btn btn-primary"  onclick="window.location.href='/students?action=remove&id=${student.id}'">Confirm</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
