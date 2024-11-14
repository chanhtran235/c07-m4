<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 9/18/2024
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create</h1>

<form:form action="/students/create" method="post" modelAttribute="student">
    ID:
    <form:input path="id"/><br>
    Name:
    <form:input path="name"/><br>
    Gender:
    <form:radiobutton path="gender" value="true"/>Male
    <form:radiobutton path="gender" value="false"/>Female<br>
    Languages:
    <form:checkboxes path="languages" items="${languages}"/><br>
    <form:select path="classId">
        <form:option value="1">C0724L1</form:option>
        <form:option value="2">C0824L1</form:option>
        <form:option value="3">C0924L1</form:option>
    </form:select>
    <form:button>Save</form:button>
</form:form>

</body>
</html>
























<%--<form:form action="/students/create" method="post" modelAttribute="student">--%>
<%--    ID:--%>
<%--    <form:input path="id"/><br>--%>
<%--    Name:--%>
<%--    <form:input path="name"/><br>--%>
<%--    Gender:--%>
<%--    <form:radiobutton path="gender" value="true"/>Male--%>
<%--    <form:radiobutton path="gender" value="false"/>Female<br>--%>
<%--    Languages:--%>
<%--    <form:checkboxes path="languages" items="${languages}"/><br>--%>
<%--    Class ID:--%>
<%--    <form:select path="classId">--%>
<%--        <form:option value="1"> C03</form:option>--%>
<%--        <form:option value="2"> C04</form:option>--%>
<%--        <form:option value="3"> C05</form:option>--%>
<%--    </form:select><br>--%>
<%--    <form:button>Save</form:button>--%>
<%--</form:form>--%>

