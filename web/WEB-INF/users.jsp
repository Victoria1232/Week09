<%-- 
    Document   : users
    Created on : Jun 30, 2023, 2:05:40 PM
    Author     : mfgperez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Users Page</title>
    </head>
    <body>
        <h1>Manage Users </h1>

        Users <table border="1">

            <tr>
                <td>Email</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Role</td>
                <td>Edit</td>
                <td>Delete</td>

            </tr>
            <c:forEach items="${accounts}" var="account">
                <tr>
                    <td> User23@gmail.com </td>
                    <td> james </td>
                    <td> makey </td>
                    <td> editor </td>
                    <td><a href="account?edit">edit</a></td>
                    <td><a href="account?delete">delete</a></td>
                </tr>

            </c:forEach>
        </table>

        <h2>Add User</h2>

        <form method="post" action="User">
            Email: <input type="text" name="email"><br> 
            First Name:  <input type="text" name="firstname"><br>
            Last Name <input type="text" name="lastname"><br>  
            Password:  <input type="text" name="password"><br>
        </form>

    </body>
</html>
