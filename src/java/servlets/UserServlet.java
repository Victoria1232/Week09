/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import data_access.ConnectionPool;
import data_access.UserDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.UserService;

/**
 *
 * @author mfgperez
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * GAME PLAN
         *
         * get everything from our data base create a bunch of user objects
         * using the result set containing all users in our db add to array list
         * print out each one in jsp using jstl
         *
         * add edit feature and add user feature delete feature
         *
         */
        // UserService service = new UserService("hhh");
        UserDB userdb = new UserDB();

        try {
            ArrayList<User> usersArray = userdb.getAllUsers();
            

            if (usersArray == null) {

                request.setAttribute("error", "No users found, Please add user");
            }
            
            request.setAttribute("accounts", usersArray);

        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex); // ???
        }

        String edit = request.getParameter("edit");
        String delete = request.getParameter("delete");

        if (edit != null) {
            // go to edit mode 
        } else if (delete != null) {
            // delete user 
        }

        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        return;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String password = request.getParameter("password");
        String role =  request.getParameter("role");

        if (firstName == null || firstName.equalsIgnoreCase("") || lastName == null || lastName.equalsIgnoreCase("") || password == null || password.equalsIgnoreCase("")) {

            request.setAttribute("error", "All fields are required");
            getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            return;
        }
        // otherwise 

        // add user
        // delete users
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        return;

    }

}
