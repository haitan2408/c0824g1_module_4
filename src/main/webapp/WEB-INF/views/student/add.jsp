<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 29/11/2024
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
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
                    <a class="nav-link" href="/student">Student</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/teacher">Teacher</a>
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
    <c:if test="${not empty errors}">
        <div class="alert alert-danger">
            <c:forEach var="error" items="${errors}">
                <li>${error.defaultMessage}</li>
            </c:forEach>
        </div>
    </c:if>
    <form:form method="post" action="/student/create" modelAttribute="student">
        <div class="mb-3">
            <label for="inputName" class="form-label">Name</label>
            <form:input type="text" class="form-control" name="name" id="inputName" pattern="^[a-zA-Z ]+$" path="name"/>
        </div>
        <div class="mb-3">
            <label for="inputEmail" class="form-label">Email</label>
            <form:input type="email" class="form-control" name="email" id="inputEmail" path="email"/>
        </div>
        <div class="mb-3">
            <label for="inputPoint" class="form-label">Point</label>
            <form:input type="number" class="form-control" name="point" id="inputPoint" min="0" max="100" path="point"/>
        </div>
        <div class="mb-3">
            <label for="inputDOB" class="form-label">DOB</label>
            <form:input type="date" class="form-control" name="dob" id="inputDOB" path="dob"/>
        </div>
        <div class="mb-3">
            <label for="classname" class="form-label">Class</label>
            <form:select path="idClass" class="form-select" name="idClass" id="classname">
                <form:option value="">---Chọn lớp---</form:option>
                <form:options items="${classrooms}"></form:options>
            </form:select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</html>
