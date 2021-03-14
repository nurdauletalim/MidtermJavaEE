<%--
  Created by IntelliJ IDEA.
  User: Nurdaulet
  Date: 14.03.2021
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Phones</title>
</head>
<body>
<h1>Add New Phone</h1>
<form action="SaveServlet" method="post">
    <table>
        <tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
        <tr><td>Price:</td><td><input type="text" name="price"/></td></tr>
        <tr><td>img Link:</td><td><input type="text" name="imgLink"/></td></tr>
        <tr><td colspan="2"><input type="submit" value="Save Employee"/></td></tr>
    </table>
</form>

<br/>
<a href="ViewServlet">view phones</a>

</body>
</html>
