<%@ page import="com.urise.webapp.model.ContactType" %>
<%@ page import="com.urise.webapp.model.ContactType" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 31.01.2023
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список всех резюме</title>
</head>
<body>
<section>
    <table border="1" cellpadding="8" cellspacing="0">
        <tr>
            <th>Name</th>
            <th>Email</th>
        </tr>
        <c:forEach items="${resumes}" var="resume">
            ruslan
            <jsp:useBean id="resume" type="com.urise.webapp.model.Resume"/>
            <tr>
                <td><a href="resume?uuid=${resume.uuid}">${resume.fullName}</a></td>
                <td>${resume.getContacts(ContactType.MAIL)}</td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
