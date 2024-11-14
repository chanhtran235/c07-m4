<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 9/17/2024
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${mess}</h1>
<h1>Trang danh sách</h1>
<a href="/students/create">Add New Student</a>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Gender</td>
        <td>Language </td>
        <td>Class ID</td>
        <td>Detail- RequestParam</td>
        <td>Detail-PathVariable</td>
    </tr>
    <c:forEach items="${studentList}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.gender}</td>
            <td>
                <c:forEach var="lag" items="${s.languages}">
                   <span>${lag}</span>
                </c:forEach>
            </td>
            <td>${s.classId}</td>
            <td><a href="/students/detail?id=${s.id}">Detail1</a></td>
            <td><a href="/students/${s.id}/detail">Detail2</a></td>
        </tr>
    </c:forEach>
</table>
<h1>${languages[0]}</h1>
</body>
</html>
