<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="gr.ballis.util.Mappings" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Item </h2></caption>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Details</th>
            <th>Deadline</th>
        </tr>
            <tr>
                <td><c:out value="${todoItem.id}"/></td>
                <td><c:out value="${todoItem.title}"/></td>
                <td><c:out value="${todoItem.details}"/></td>
                <td><c:out value="${todoItem.deadline}"/></td>
            </tr>
    </table>
    <c:url var="itemsLink" value="${Mappings.ITEMS}"/>
    <h2><a href="${itemsLink}">Back</a></h2>
</div>

</body>
</html>
