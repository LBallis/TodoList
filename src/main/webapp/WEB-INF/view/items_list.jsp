<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="gr.ballis.util.Mappings" %>
<html>
<head>
    <title>Todo Items</title>
</head>
<body>
    <div align="center">
        <c:url var="addItemLink" value="${Mappings.ADD_ITEM}"/>
        <a href="${addItemLink}">Add Item</a>
        <table border="1" cellpadding="5">
            <caption><h2>Todo Items</h2></caption>
            <tr>
                <th>Title</th>
                <th>Deadline</th>
                <th>View</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="item" items="${todoData.items}">
                <c:url var="viewItem" value="${Mappings.VIEW_ITEM}">
                    <c:param name="id" value="${item.id}"/>
                </c:url>
                <c:url var="editItem" value="${Mappings.ADD_ITEM}">
                    <c:param name="id" value="${item.id}"/>
                </c:url>
                <c:url var="deleteItem" value="${Mappings.DELETE_ITEM}">
                    <c:param name="id" value="${item.id}"/>
                </c:url>
                <tr>
                    <td><c:out value="${item.title}"/></td>
                    <td><c:out value="${item.deadline}"/></td>
                    <td><a href="${viewItem}">View</a></td>
                    <td><a href="${editItem}">Edit</a></td>
                    <td><a href="${deleteItem}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
