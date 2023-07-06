/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import data_access.ConnectionPool;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mfgperez
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ConnectionPool pool = ConnectionPool.getInstance(); // make a pool 
        Connection connection = pool.getConnection(); // get a connection object 

        pool.freeConnection(connection); // close the connection object 

        String edit = request.getParameter("edit");
        String delete = request.getParameter("delete");
        
        
        if (edit != null) {
            // go to edit mode 
        }
        else if (delete != null) {
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

        if (firstName == null || firstName.equalsIgnoreCase("") || lastName == null || lastName.equalsIgnoreCase("") || password == null || password.equalsIgnoreCase("")) {

            request.setAttribute("error", "All fields are required");
            getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        return;

    }

}
