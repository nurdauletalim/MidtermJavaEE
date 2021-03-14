<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>

<h1>Add New Employee</h1>
<form action="SaveServlet" method="post">
    <table>
        <tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
        <tr><td>Password:</td><td><input type="password" name="password"/></td></tr>
        <tr><td>Email:</td><td><input type="email" name="email"/></td></tr>

        <tr><td colspan="2"><input type="submit" value="Save User"/></td></tr>
    </table>
</form>

<br/>
<a href="ViewServlet">View users</a><br>
<a href="adminPhones.jsp">Phones</a>

</body>
</html>
