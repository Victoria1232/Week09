<%-- 
    Document   : users
    Created on : Jun 30, 2023, 2:05:40 PM
    Author     : mfgperez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Users Page</title>
    </head>

    <body>
        <h1>Manage Users </h1>


        <p>${error}</p>
        <br>
        <strong>Users</strong><table border="1">

            <tr>
                <td> Email</td>
                <td> First Name</td>
                <td> Last Name</td>
                <td> Role</td>
                <td>Edit</td>
                <td>Delete</td>

            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.email}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>

                    <td><a href="/?action=edit&amp;user_name=${user.firstName}">edit</a></td>
                    <td><a href="/?action=delete&amp;user_name=${user.firstName}">delete</a></td>
                </tr>

            </c:forEach>
        </table>

        <br>
        <p>${message}</p>


        <c:if test="${selectedUser eq null}">

            <h2>Edit User</h2>
            <form action="user" method="post">
                
                <p>${selectedUser.email}</p>
                First Name:  <input type="text" name="firstname"><br>
                Last Name <input type="text" name="lastname"><br>  
                Password:  <input type="text" name="password"><br>

                <select name="roles">
                    <option name="admin" value="1">System Admin</option>
                    <option value="reg_user">Regular User</option>
                </select><br>
                <br>

                <input type="hidden" name="action" value="update">
                <input type="submit" value="Update">
            </form>
        </c:if>


        <br>
        
        

        <h2>${header2value}</h2>
        <form action="user" method="post">

            <input hidden type="text" name="email" value="${users_email}"><br> 

            Email: <input  type="text" name="email"><br> 
            First Name:  <input type="text" name="firstname"><br>
            Last Name <input type="text" name="lastname"><br>  
            Password:  <input type="text" name="password"><br>



            <select name="roles">
                <option name="admin" value="1">System Admin</option>
                <option value="reg_user">Regular User</option>
            </select><br>
            <br>

            <input type="submit" value="${submitvalue}">
        </form>



    </body>
</html>
